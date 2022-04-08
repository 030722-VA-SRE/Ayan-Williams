package com.revature.services;

import java.util.List;
import com.revature.daos.BuggDao;
import com.revature.daos.BuggPostgres;
import com.revature.exceptions.BuggNotFoundException;
import com.revature.models.Bugg;

public class BuggService {
	
	private BuggDao bp;
	
	public BuggService() {
		bp = new BuggPostgres();
}
	
	


	public List<Bugg> getBugg() throws BuggNotFoundException {
		List<Bugg> bL = bp.getBugg();
		if(bL.isEmpty()) {
			throw new BuggNotFoundException();
		}
	return bL;
	}
	
	
	public Bugg getById(int id) throws BuggNotFoundException {
		Bugg bugg = bp.getBuggById(id);
		if(bugg == null) {
			throw new BuggNotFoundException();
		}
		return bugg;
	}
	
	
	public boolean deleteBuggById(int id) throws BuggNotFoundException{
		 boolean bugg = bp.deleteBuggById(id);
		 if(!bugg) {
				throw new BuggNotFoundException();
			}
		 return true;
	}

	

	public boolean updateBugg(Bugg bugg) throws BuggNotFoundException{
		boolean bugg2 = bp.updateBugg(bugg);
		if(!bugg2) {
			throw new BuggNotFoundException();
		}
		return true;
	}
	
	
	public boolean createBugg(Bugg bugg) { 
		int generatedId = bp.createBugg(bugg);
		if(generatedId == 1) {
			return true;
		}
		return false;
	}
	
	public List<Bugg> getBuggByFam(String fam) throws BuggNotFoundException {
		List<Bugg> bL = bp.getBuggByFam(fam);
		if(bL.isEmpty()) {
			throw new BuggNotFoundException();
		}
	return bL;
	}

	public List<Bugg> getBuggByHab(String hab) throws BuggNotFoundException {
		List<Bugg> bL = bp.getBuggByHab(hab);
		if(bL.isEmpty()) {
			throw new BuggNotFoundException();
		}
	return bL;
	}
	
	public List<Bugg> getByFamandHab(String fam, String hab) throws BuggNotFoundException{
		List <Bugg> bL = bp.getByFamandHab(fam, hab);
		if(bL.isEmpty()) {
			throw new BuggNotFoundException();
		}
		return bL;
}

}
	





