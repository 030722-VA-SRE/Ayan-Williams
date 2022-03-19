package com.revature.daos;
import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Bugg;
import com.revature.util.ConnectionUtil;
public class BuggPostgres implements BuggDao{
	
	@Override
	public Bugg getBuggById(int id) {
		String sql = "select * from bugg where id = ?;";
		Bugg bugg = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				bugg = new Bugg();
				bugg.setID(rs.getInt("id"));
				bugg.setKind(rs.getString("kind"));
				bugg.setPrice(rs.getInt("price"));
				bugg.setHabitat(rs.getString("habitat"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bugg;
	}
	
	@Override
	public List<Bugg> getBugg() {
		String sql = "select * from bugg;";
		List<Bugg> bL = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			
			Statement ps = c.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				Bugg bugg = new Bugg();
				bugg.setID(rs.getInt("id"));
				bugg.setKind(rs.getString("kind"));
				bugg.setPrice(rs.getInt("price"));
				bugg.setHabitat(rs.getString("habitat"));
				
				bL.add(bugg);
			}
		} catch (SQLException e) {
		e.printStackTrace();
	}
	return bL;	
	}
	
	

	public boolean deleteBuggById(int id) {
			String sql = "delete from bugg where id = ?;";

			try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
				PreparedStatement ps = c.prepareStatement(sql);
//	
				ps.setInt(1, id);
	
				ResultSet rs = ps.executeQuery();
//	
				if (rs.next()) {
					System.out.println("Buggs :)");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}

	

//
//	@Override
//	public Bugg getBuggByKind(String kind) {
//		
//		return null;
//	}
//
//	@Override
//	public boolean updateBugg(Bugg bugg) {
//		
//		return false;
//	}
//
//
//	@Override
//	public int createBugg(Bugg bugg) {
//		
//		return 0;
//	}
//
//	@Override
//	public Bugg getBuggByPrice(int price) {
//		
//		return null;
//	}
//
//	@Override
//	public Bugg getBugg() {
//		
//		return null;
//	}
}

