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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockpymes.api.dao.ConsumesDAO;
import com.stockpymes.api.entitys.Consume;

/**
 * This represents the rest controller of the "Consumes" table
 * @author Alex P. Vega
 */
@RestController
@CrossOrigin
@RequestMapping("consumes")
public class ConsumesREST {
	@Autowired
	private ConsumesDAO consumeRepo;
	
	@GetMapping
	public ResponseEntity<List<Consume>> getConsumes(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit){
		var pager = PageRequest.of(page, limit);
		var list = consumeRepo.findAll(pager);
		return ResponseEntity.ok(list.getContent());
	}
	
	@GetMapping("sum")
	public ResponseEntity<Object> getSumConsumes(@RequestParam(required = true) Long id, @RequestParam(required = true) Integer year,@RequestParam(required = true) Integer month) {
		var sum = consumeRepo.sumConsumesByClientId(id, year, month);
		
		return ResponseEntity.ok(sum);
	}
	
	
	@RequestMapping(value = "{clientId}")
	public ResponseEntity<List<Consume>> getConsumesByClient(@PathVariable(name = "clientId", required = false) Long clientId, @RequestParam(name = "productId", required = false) Long productId){
		if(clientId != null && productId != null) {
			var list = consumeRepo.findByClientIdAndProductId(clientId, productId);
			
			return (list != null && list.size() > 0) ? ResponseEntity.ok(list) : ResponseEntity.notFound().build();
		}
		else if(clientId != null) {
			var list = consumeRepo.findByClientId(clientId);
			
			return (list != null && list.size() > 0) ? ResponseEntity.ok(list) : ResponseEntity.notFound().build();
		}
		else if(productId != null) {
			var list = consumeRepo.findByProductId(productId);
			
			return (list != null && list.size() > 0) ? ResponseEntity.ok(list) : ResponseEntity.notFound().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Consume> insertConsume(@RequestBody Consume consume){
		var newConsume = consumeRepo.save(consume);
		return ResponseEntity.ok(newConsume);
	}
	
	@DeleteMapping(value = {"{clientId}", "{productId}"})
	public ResponseEntity<Consume> deleteConsume(@PathVariable(name = "clientId", required = false) Long clientId, @PathVariable(name = "productId", required = false) Long productId){
		if(clientId != null && productId != null) {
			consumeRepo.deleteByClientIdAndProductId(clientId, productId);
			return ResponseEntity.ok(null);
		}
		else if(clientId != null) {
			consumeRepo.deleteByClientId(clientId);
			return ResponseEntity.ok(null);
		}
		else if(productId != null) {
			consumeRepo.deleteByProductId(productId);
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.noContent().build();
	}
	
}
