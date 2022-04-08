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
				bugg.setFam(rs.getString("fam"));
				bugg.setPrice(rs.getInt("price"));
				bugg.setHab(rs.getString("hab"));
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
				bugg.setFam(rs.getString("fam"));
				bugg.setPrice(rs.getInt("price"));
				bugg.setHab(rs.getString("hab"));
				
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
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("Buggs :)");
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
			return true;
	}


	@Override
	public boolean updateBugg(Bugg bugg) {
		String sql = "update bugg set kind = ?, set fam = ?, price = ?, hab = ? where id = ? returning *;";
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1, bugg.getKind());
				ps.setString(2, bugg.getFam());
				ps.setInt(3,  bugg.getPrice());
				ps.setString(4,  bugg.getHab());
				ps.setInt(5,  bugg.getID());
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("Buggs :)");
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
			return true;
		
	}
	
	@Override
	public int createBugg(Bugg bugg) {
		String sql = "insert into bugg (kind, fam, price, hab) values (?, ?, ?, ?) returning Id;";
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, bugg.getKind());
			ps.setString(2, bugg.getFam());
			ps.setInt(3,  bugg.getPrice());
			ps.setString(4,  bugg.getHab());
//			ps.setInt(5,  bugg.getID());
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
//				bugg = new Bugg();
//				bugg.setID(rs.getInt("id"));
//				bugg.setKind(rs.getString("kind"));
//				bugg.setFam(rs.getString("fam"));
//				bugg.setPrice(rs.getInt("price"));
//				bugg.sethab(rs.getString("hab"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
		}

	@Override
	public List<Bugg> getBuggByFam(String fam) {
		String sql = "select * from bugg where fam = ?;";
		List<Bugg> bL = new ArrayList<>();
		Bugg bugg = null;
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
		
			ps.setString(1, fam);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				bugg = new Bugg();
				bugg.setID(rs.getInt("id"));
				bugg.setKind(rs.getString("kind"));
				bugg.setFam(rs.getString("fam"));
				bugg.setPrice(rs.getInt("price"));
				bugg.setHab(rs.getString("hab"));
				
				bL.add(bugg);
			}
		} catch (SQLException e) {
		e.printStackTrace();
	}
	return bL;
	}

	@Override
	public List<Bugg> getBuggByHab(String hab) {
		String sql = "select * from bugg where hab = ?;";
		List<Bugg> bL = new ArrayList<>();
		Bugg bugg = null;
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, hab);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				bugg = new Bugg();
				bugg.setID(rs.getInt("id"));
				bugg.setKind(rs.getString("kind"));
				bugg.setFam(rs.getString("fam"));
				bugg.setPrice(rs.getInt("price"));
				bugg.setHab(rs.getString("hab"));
				
				bL.add(bugg);
			}
		} catch (SQLException e) {
		e.printStackTrace();
	}
	return bL;
	
	}

	@Override
	public List<Bugg> getByFamandHab(String fam, String hab) {
		String sql = "select * from bugg where Fam = ? and Hab = ?;";
		List<Bugg> bL = new ArrayList<>();
		Bugg bugg = null;
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, fam);
			ps.setString(2, hab);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				bugg = new Bugg();
				bugg.setID(rs.getInt("id"));
				bugg.setKind(rs.getString("kind"));
				bugg.setFam(rs.getString("fam"));
				bugg.setPrice(rs.getInt("price"));
				bugg.setHab(rs.getString("hab"));
				
				bL.add(bugg);
			}
		} catch (SQLException e) {
		e.printStackTrace();
	}
	return bL;
			
	}
}

	




