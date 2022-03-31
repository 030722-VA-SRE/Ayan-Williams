package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.exceptions.BuggNotFoundException;
import com.revature.models.Bugg;
import com.revature.repositories.BuggRepository;
import com.revature.repositories.UserRepository;

@Service
public class BuggService {
	
	private BuggRepository br;
	@Autowired
	public BuggService(UserRepository ur, BuggRepository br) {
		super();
		this.br = br;
	}
	
	
	public List<Bugg> getAll(){
		return br.findAll();
	}
	
	
	public Bugg getById(int id) throws BuggNotFoundException{
		Bugg bugg;
		bugg = br.findById(id).orElseThrow(BuggNotFoundException::new);
		return bugg;
	}

	@Transactional
	public Bugg deleteBuggById(int id) {
		return br.deleteById(id);
		
	}
	
	@Transactional
	public Bugg createBugg(Bugg bugg) {
		return br.save(bugg);
	}

	
	@Transactional
	public Bugg updateBugg(int id, Bugg bugg) throws BuggNotFoundException{
		Bugg b = br.findById(id).orElseThrow(BuggNotFoundException::new);
		
		bugg.setid(b.getid());
			
		return br.save(bugg);		
		

	}
	
}
