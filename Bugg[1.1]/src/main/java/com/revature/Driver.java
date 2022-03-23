package com.revature;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.http.HttpStatus;
import com.revature.exceptions.BuggNotFoundException;
import com.revature.models.Bugg;
import com.revature.services.BuggService;
import io.javalin.Javalin;




public class Driver {	
static final Logger Log = LogManager.getRootLogger();


@SuppressWarnings("unused")
public static void main(String[] args){
	
	

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
			Log.error("User attempted to find Bugg that does not exist. Bugg id: " + id);
	}

});
	

	//DELETE BY ID
	app.delete("bugg/{id}", (ctx)->{
		
		int id = Integer.parseInt(ctx.pathParam("id"));

		try {
			boolean bugg = bs.deleteBuggById(id);
			ctx.result("Goodbye Bugg #" + id + " !");
			ctx.status(200);
			} catch (BuggNotFoundException e) {
				ctx.status(404);
				ctx.result("Bugg of id: " + id + " was not found");
				Log.error("User attempted to delete a Bugg that does not exist. Bugg id: " + id);
		}

	});	
		
		//CREATE-A-BUGG
	app.post("bugg", (ctx)->{
		Bugg newBugg = ctx.bodyAsClass(Bugg.class);
	
		if(bs.createBugg(newBugg)) {
		ctx.status(HttpStatus.CREATED_201);
		}else {
			ctx.status(400);
			ctx.result("Unable hatch bugg :(");
			Log.error("Creation of new Bugg denied.");
		 }
	});
	
	
		//UPDATE-A-BUGG
	app.put("bugg/{id}", (ctx) ->{
		int id = Integer.parseInt(ctx.pathParam("id"));
		Bugg bugg = ctx.bodyAsClass(Bugg.class);
		
		try {
			Bugg bugg1 = bs.getById(id);
			ctx.json(bugg);
			ctx.status(200);
			} catch (BuggNotFoundException e) {
				ctx.status(404);
				ctx.result("Bugg of id: " + id + " was not found");
				Log.error("User attempted to update a Bugg that does not exist. Bugg id: " + id);
		}
//		bugg.setID(id);
//		if(bs.updateBugg(bugg)) {
//		ctx.status(HttpStatus.OK_200);			
//		}else {
//			ctx.status(400);
//			ctx.result("Do not touch the bugg!");
//			Log.error("Cannot set the id for this Bugg. Bugg id: " + id);
//		}
//		
	});
	

//	------------QUERY PARAMS BUGG-BY-FAM AND BUG-BY-HAB---------------------
				app.get("bugg", (ctx) -> {
				String fam = ctx.queryParam("fam");
				String hab = ctx.queryParam("hab");
			
				
				if(fam == null && hab == null) {
					ctx.json(bs.getBugg());
					try {
						List<Bugg> bL = bs.getBugg();
						ctx.json(bL);
						ctx.status(200);
						} catch (BuggNotFoundException e) {
							ctx.status(404);
							ctx.result("No buggs here :( ");
							Log.error("User attempted to find Buggs. There are none.");
						}
				} else if (fam != null && hab == null) {
					try {
						List<Bugg> bL = bs.getBuggByFam(fam);
						ctx.json(bL);
						ctx.status(200);
						} catch (BuggNotFoundException e) {
							ctx.status(404);
							ctx.result("Bugg of family: " + fam + " was not found");
							Log.error("User attempted to find Bugg family that doesn't exist");
					}
				} else if (fam == null && hab != null) {
					try {
			
						List<Bugg> bL = bs.getBuggByHab(hab);
						ctx.json(bL);
						ctx.status(200);
						} catch (BuggNotFoundException e) {
							ctx.status(404);
							ctx.result("Bugg of hab: " + hab + " was not found");
							Log.error("User attempted to find Bugg hab that doesn't exist");
					}
				} else {
					try {
						List<Bugg> bL = bs.getByFamandHab(fam, hab);
						ctx.json(bL);
						ctx.status(200);
						} catch (BuggNotFoundException e) {
							ctx.status(404);
							ctx.result("No buggs here :( ");
							Log.error("User attempted to find Buggs. There are none.");
						}
				
				
				}
			});
				
				
}
}	
				