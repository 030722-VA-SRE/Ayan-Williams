package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.Bugg;

@Repository
public interface BuggRepository extends JpaRepository<Bugg, Integer>{
		
	public Bugg deleteById(int id);

}


