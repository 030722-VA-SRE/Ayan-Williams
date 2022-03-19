package com.revature.services;

import java.util.List;


//import java.util.List;

import com.revature.daos.BuggDao;
import com.revature.daos.BuggPostgres;
import com.revature.exceptions.BuggNotFoundException;
import com.revature.models.Bugg;

//Service layer for buisness logic
//layer connecting to Dao layer
public class BuggService {
	private BuggDao bDao = new BuggPostgres();
	
	
	public List<Bugg> getBugg() throws BuggNotFoundException {
		List<Bugg> bL = bDao.getBugg();
		if(bL.isEmpty()) {
			throw new BuggNotFoundException();
		}
	return bL;
	}
	
	
	public Bugg getById(int id) throws BuggNotFoundException {
		Bugg bugg = bDao.getBuggById(id);
		if(bugg == null) {
			throw new BuggNotFoundException();
		}
		return bugg;
	}
	
	
	public boolean deleteBuggById(int id) throws BuggNotFoundException{
		 boolean bugg = bDao.deleteBuggById(id);
		 if(!bugg) {
				throw new BuggNotFoundException();
			}
		 return true;
	}


	
	
	
	
//	public Bugg getByKind(String kind) throws BuggNotFoundException{
//		Bugg bugg = bDao.getBuggByKind(kind);
//		if(bugg == null) {
//			throw new BuggNotFoundException();
//		}
//		return bugg;
//	}

	
	
	
	
//	public Bugg getByPrice(int price) throws BuggNotFoundException{
//		Bugg bugg = bDao.getBuggByPrice(price);
//		if(bugg == null) {
//			throw new BuggNotFoundException();
//		}
//		return bugg;
//	}
}