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

	

	public boolean updateBugg(Bugg bugg) throws BuggNotFoundException{
		boolean bugg2 = bDao.updateBugg(bugg);
		if(!bugg2) {
			throw new BuggNotFoundException();
		}
		return true;
	}
	
	
	public boolean createBugg(Bugg bugg) { //from Dao (this was previously initialized in Dao)
		int generatedId = bDao.createBugg(bugg);
		if(generatedId != 1) {
			return true;
		}
		return false;
	}
	
	public List<Bugg> getBuggByFam(String fam) throws BuggNotFoundException {
		List<Bugg> bL = bDao.getBuggByFam(fam);
		if(bL.isEmpty()) {
			throw new BuggNotFoundException();
		}
	return bL;
	}

	public List<Bugg> getBuggByHab(String hab) throws BuggNotFoundException {
		List<Bugg> bL = bDao.getBuggByHab(hab);
		if(bL.isEmpty()) {
			throw new BuggNotFoundException();
		}
	return bL;
	}
	
	public List<Bugg> getByFamandHab(String fam, String hab) throws BuggNotFoundException{
		List <Bugg> bL = bDao.getByFamandHab(fam, hab);
		if(bL.isEmpty()) {
			throw new BuggNotFoundException();
		}
		return bL;
}

}
	





