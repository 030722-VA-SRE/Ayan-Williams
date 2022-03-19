package com.revature;

import java.util.List;


//import java.util.List;

import com.revature.exceptions.BuggNotFoundException;

import com.revature.models.Bugg;
import com.revature.services.BuggService;

import io.javalin.Javalin;

public class Driver {	
public static void main(String[] args){
	//allows us to interact with methods in the bugg service class
		//And the service methods interact with the BuggPostgres to handle persistence while adding buisness logic
	BuggService bs = new BuggService();
	
	Javalin app = Javalin.create();
	app.start(8080);

	
		//RETURN BUGG BY ID
	app.get("bugg/{id}", (ctx) -> {
		
		int id = Integer.parseInt(ctx.pathParam("id"));
			
		try {
		Bugg bugg = bs.getById(id);
		ctx.json(bugg);
		ctx.status(200);
		} catch (BuggNotFoundException e) {
			ctx.status(404);
			ctx.result("Bugg of id: " + id + " was not found");
			// log this to file
	}

});
	
//	RETURN ALL BUGGS HERE
	app.get("bugg", (ctx)->{
		try {
			List<Bugg> bL = bs.getBugg();
			ctx.json(bL);
			ctx.status(200);
			} catch (BuggNotFoundException e) {
				ctx.status(404);
				ctx.result("No buggs here :( ");
				// log this to file
			}
	});
	
			//RETURN BUGG BY KIND
//	app.get("bugg/{kind}", (ctx) -> {
//		String kind = (ctx.pathParam("kind"));
//			
//		try {
//		Bugg bugg = bs.getByKind(kind);
//		ctx.json(bugg);
//		ctx.status(200);
//		}catch(BuggNotFoundException e) {
//			ctx.status(404);
//			ctx.result("Bugg of kind: " + kind + " was not found");
//			//log this to a file
//		}
//	});
	
		
		//RETURN BUGG BY PRICE
//	app.get("bugg/{price}", (ctx) -> {
//		// returns the value of path parameter of name id, converted string to int
//	int price = Integer.parseInt(ctx.pathParam("price"));
//		// retrieve bugg using bugg service method
//	try {
//	Bugg bugg = bs.getByPrice(price);
//	ctx.json(bugg);
//	ctx.status(200);
//	} catch (BuggNotFoundException e) { //?????????????????????????????????????????????
//		ctx.status(404);
//		ctx.result("Bugg of price: " + price + " was not found");
//		// log this to file
//			}
//		
//		});	
	}
}

