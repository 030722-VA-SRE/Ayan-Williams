package com.revature.daos;

import java.util.List;

//import java.util.List;


import com.revature.models.Bugg;

public interface BuggDao {
	
	public Bugg getBuggById(int id);
	public List<Bugg> getBugg();
	public boolean deleteBuggById(int id);
	public boolean updateBugg (Bugg bugg);
	public int createBugg (Bugg bugg);
	public List<Bugg> getBuggByFam(String fam);
	public List<Bugg> getBuggByHab(String fam);
	public List<Bugg> getByFamandHab(String fam, String hab);
}
