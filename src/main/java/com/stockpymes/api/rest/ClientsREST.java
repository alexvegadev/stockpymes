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

import com.stockpymes.api.dao.ClientsDAO;
import com.stockpymes.api.entitys.Client;

/**
 * @author Alex P. Vega
 */
@RestController
@CrossOrigin
@RequestMapping("clients")
public class ClientsREST {
	
	@Autowired
	private ClientsDAO clientsDAO;
	
	@GetMapping
	public ResponseEntity<List<Client>> getClients(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit){
		var pager = PageRequest.of(page, limit);
		var list = clientsDAO.findAll(pager);
		return ResponseEntity.ok(list.getContent());
	}
	
	@GetMapping("name")
	public ResponseEntity<List<Client>> getClientsByName(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "60") Integer limit,@RequestParam(required = true) String name){
		var pager = PageRequest.of(page, limit);
		var list = clientsDAO.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(pager, name, name);
		return ResponseEntity.ok(list.getContent());
	}
	
	@RequestMapping(value = "{clientId}")
	public ResponseEntity<Client> getClient(@PathVariable("clientId") Long clientId){
		var optional = clientsDAO.findById(clientId);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		var newClient = clientsDAO.save(client);
		return ResponseEntity.ok(newClient);
	}
	
	@DeleteMapping(value = "{clientId}")
	public ResponseEntity<Client> deleteClient(@PathVariable("clientId") Long clientId){
		clientsDAO.deleteById(clientId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Client> updateClient(@RequestBody Client client){
		var optional = clientsDAO.findById(client.getId());
		if(optional.isPresent()) {
			var clientUpdate = optional.get();
			clientUpdate.setFirstName(client.getFirstName());
			clientsDAO.save(clientUpdate);
			return ResponseEntity.ok(clientUpdate);
		}
		return ResponseEntity.notFound().build();
	}
	
}
