package com.revature.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Bugg;
import com.revature.services.BuggService;


@RestController
@RequestMapping("/bugg")
public class BuggController {
	
	private BuggService bs;

	@Autowired
	public BuggController(BuggService bs) {
		super();
		this.bs = bs;
	}
	
	@GetMapping
	public ResponseEntity<List<Bugg>> getAll() {
		return new ResponseEntity<>(bs.getAll(), HttpStatus.OK);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Bugg> getBuggById(@PathVariable("id") int id){
		return new ResponseEntity<>(bs.getById(id),HttpStatus.OK);
	}
	
	
	//requestparam
//	@GetMapping("?fam={fam}")
//	public ResponseEntity<List<Bugg>> getBuggByFam(@PathVariable("fam") String fam){
//		return new ResponseEntity<>(bs.getByFam(),HttpStatus.OK);
//	}
	
	
	@PostMapping
	public ResponseEntity<String> createBugg(@RequestBody Bugg bugg){
		Bugg b = bs.createBugg(bugg);
		return new ResponseEntity<>("Bugg " + b.getKind() + " has been created.", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Bugg> updateBugg(@RequestBody Bugg bugg, @PathVariable("id") int id) {
		return new ResponseEntity<>(bs.updateBugg(id, bugg), HttpStatus.OK); 
		//"Bugg #"+id+" has been updated",
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		bs.deleteBuggById(id);
		return new ResponseEntity<>("Bugg #"+id +" was deleted", HttpStatus.OK);
	}
}