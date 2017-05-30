package it.polito.tdp.rivers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.River;

public class RiverDAO {
	
	public List<River> getRivers(){
		List<River> lista=new ArrayList<River>();
		String sql="SELECT * FROM river";
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				River r=new River(rs.getInt("id"),rs.getString("name"));
				lista.add(r);
			}
			st.close();
			conn.close();
			return lista;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	public List<Flow> getMisurazioni(River r) {
		List<Flow> lista=new ArrayList<Flow>();
		String sql="SELECT * FROM flow WHERE river=? ORDER BY day";
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, r.getId());
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				Flow f=new Flow(rs.getInt("id"),rs.getDate("day").toLocalDate(),rs.getFloat("flow"),r);
				lista.add(f);
			}
			st.close();
			conn.close();
			return lista;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	
}
