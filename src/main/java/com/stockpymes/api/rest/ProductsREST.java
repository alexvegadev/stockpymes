package com.stockpymes.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockpymes.api.dao.ProductsDAO;
import com.stockpymes.api.entitys.Product;


/**
 * @author Alex P. Vega
 */
@RestController
@CrossOrigin
@RequestMapping("products")
public class ProductsREST {
	
	
	@Autowired
	private ProductsDAO productsDAO;
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit){
		var pager = PageRequest.of(page, limit);
		var list = productsDAO.findAll(pager);
		return ResponseEntity.ok(list.getContent());
	}
	
	@GetMapping("name")
	public ResponseEntity<List<Product>> getProductByName(@RequestParam String name, @RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit){
		var pager = PageRequest.of(page, limit);
		var list = productsDAO.findByNameContainingIgnoreCase(pager, name);
		return ResponseEntity.ok(list.getContent());
	}
	
	
	@RequestMapping(value = "{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") Long productId) {
		var optional = productsDAO.findById(productId);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return ResponseEntity.notFound().build();
	}
	

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		var newProduct = productsDAO.save(product);
		return ResponseEntity.ok(newProduct);
	}
	
	@DeleteMapping(value = "{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(name = "productId") Long id) {
		productsDAO.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		var optional = productsDAO.findById(product.getId());
		if(optional.isPresent()) {
			var productUpdate = optional.get();
			productUpdate.setName(product.getName());
			productsDAO.save(productUpdate);
			return ResponseEntity.ok(productUpdate);
		}
		return ResponseEntity.notFound().build();
	}

}