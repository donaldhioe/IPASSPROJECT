package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1wac.firstapp.entiteiten.Locatie;

public class LocatieDao extends BaseDAO {
	private List<Locatie> selectLocatie(String query) {
		List<Locatie> results = new ArrayList<Locatie>();
		
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			
			while (dbResultSet.next()) {
				int locatienummer = dbResultSet.getInt("locatienummer");
				String naam = dbResultSet.getString("naam");
				String plaats = dbResultSet.getString("plaats");
				String straat = dbResultSet.getString("straat");
				String lokaal = dbResultSet.getString("lokaal");
				
				results.add(new Locatie(locatienummer, naam, plaats, straat, lokaal));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return results;
		
	}
	
	public List<Locatie> findAll() {
		return selectLocatie("SELECT * FROM locatie");
	}
	
	public Locatie findByLocatienummer (int locatienummer) {
		return selectLocatie("SELECT * FROM locatie where locatienummer = " + locatienummer).get(0);
	}

}
