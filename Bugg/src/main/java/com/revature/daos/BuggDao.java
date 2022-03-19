package com.revature.daos;

import java.util.List;

//import java.util.List;


import com.revature.models.Bugg;

public interface BuggDao {
	
	public Bugg getBuggById(int id);
	public List<Bugg> getBugg();
//	public int createBugg(Bugg bugg);
//	public Bugg getBuggByKind(String kind);
//	public Bugg getBuggByPrice(int price);
//	public boolean updateBugg(Bugg bugg);
	public boolean deleteBuggById(int id);
}
