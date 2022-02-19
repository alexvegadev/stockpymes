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

import com.stockpymes.api.dao.ProvidersDAO;
import com.stockpymes.api.entitys.Provider;

/**
 * @author Alex P. Vega
 */
@RestController
@CrossOrigin
@RequestMapping("providers")
public class ProvidersREST {
	
	@Autowired
	private ProvidersDAO providersDAO;
	
	@GetMapping
	public ResponseEntity<List<Provider>> getProviders(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit) {
		var pager = PageRequest.of(page, limit);
		var list = providersDAO.findAll(pager);
		return ResponseEntity.ok(list.getContent());
	}
	
	@RequestMapping(value = "{providerId}")
	public ResponseEntity<Provider> getProvider(@PathVariable("providerId") Long providerId){
		var optional = providersDAO.findById(providerId);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping
	public ResponseEntity<Provider> createProvider(@RequestBody Provider provider){
		var newProvider = providersDAO.save(provider);
		return ResponseEntity.ok(newProvider);
	}
	
	@DeleteMapping(value = "{providerId}")
	public ResponseEntity<Provider> deleteProvider(@PathVariable("providerId") Long providerId){
		providersDAO.deleteById(providerId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Provider> updateProvider(@RequestBody Provider provider){
		var optional = providersDAO.findById(provider.getId());
		if(optional.isPresent()) {
			var providerUpdate = optional.get();
			providerUpdate.setProviderName(provider.getProviderName());
			providersDAO.save(providerUpdate);
			return ResponseEntity.ok(providerUpdate);
		}
		return ResponseEntity.notFound().build();
	}

}
