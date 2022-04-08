package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.revature.daos.BuggPostgres;
import com.revature.exceptions.BuggNotFoundException;
import com.revature.models.Bugg;
import com.revature.services.BuggService;

//@TestMethodOrder(OrderAnnotation.class)
class BuggTest {
	
	private static BuggPostgres bp;
	private static BuggService bs;
	private static List<Bugg> bugg;
	private static List<Bugg> bHab;
	private static List<Bugg> bFam;
	private static List<Bugg> bFamHab;
	
	@BeforeAll
	public static void setup() {
		bp = new BuggPostgres();
		bs = new BuggService();
		
bugg = new ArrayList<>();
		
		
		bugg.add(new Bugg(1, "Pink Winged Stick Insect", "stick bug", 25, "Tropical forest"));
		bugg.add(new Bugg(2, "Orchid Mantis", "praying mantis", 46, "Rain forest"));
		bugg.add(new Bugg(3, "Giant Land Snail", "snail", 6, "Temperate"));
		bugg.add(new Bugg(4, "Bumble Bee","bee", 160, "Temperate"));
		bugg.add(new Bugg(5, "Lunar Moth", "moth", 25, "Temperate forest" ));
		bugg.add(new Bugg(6, "Goliath Beetle", "beetle", 60, "Tropical rain forest"));
		
bHab = new ArrayList<>();

		bHab.add(new Bugg(3, "Giant Land Snail", "snail", 6, "Temperate"));
		bHab.add(new Bugg(4, "Bumble Bee","bee", 160, "Temperate"));
		
bFam = new ArrayList<>();
		bFam.add(new Bugg(4, "Bumble Bee","bee", 160, "Temperate"));
		
bFamHab = new ArrayList<>();
		bFamHab.add(new Bugg(3, "Giant Land Snail", "snail", 6, "Temperate"));
	}


//	@Test
//	@Order(1) 
//	public void getAllBuggsTest() throws BuggNotFoundException{
//		List<Bugg> dbBugg = bs.getBugg();
//		System.out.println(bugg);
//		assertEquals(bugg, dbBugg);
//		}
	
	
//	@Test
//	@Order(2) 
//	public void getByIdTest() throws BuggNotFoundException {
//		assertEquals(bugg.get(0), bs.getById(1));
//	}
//
//	@Test 
//	@Order(8)
//	public void deleteBuggByIdTest() throws BuggNotFoundException {
//		boolean ifBuggDeleted = bs.deleteBuggById(0);
//		assertEquals(true, ifBuggDeleted);
//	}
//	
//
//	@Test
//	@Order(6)
//	public void updateBuggTest() throws BuggNotFoundException {
//		boolean ifBuggUpdated = bs.updateBugg(bugg.get(1));
//		assertEquals(true, ifBuggUpdated);
//		}
//	
//	
//	@Test 
//	@Order(7)
//	public void createBuggTest() {
//		boolean ifBuggAdded = bs.createBugg(bugg.get(1));
//		assertEquals(true, ifBuggAdded);
//	}
//	
//	@Test
//	@Order(3)
//	public void getBuggByHabTest() throws BuggNotFoundException{
//		List<Bugg> dbBugg = bp.getBuggByHab("Temperate");
//		assertEquals(bHab, dbBugg);
//	}
//
//	@Test
//	@Order(4)
//	public void getBuggByFamTest() throws BuggNotFoundException {
//		List<Bugg> dbBugg = bs.getBuggByFam("bee");
//		assertEquals(bFam, dbBugg);
//	}
//	
//	@Test 
//	@Order(5)
//	public void getBuggByFamandHabTest() throws BuggNotFoundException{
//		List<Bugg> dbBugg = bs.getByFamandHab("snail", "Temperate");
//		System.out.println(bugg);
//		assertEquals(bFamHab, dbBugg);
//	}
//	
}

