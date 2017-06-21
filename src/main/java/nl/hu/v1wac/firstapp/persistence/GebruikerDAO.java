package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1wac.firstapp.entiteiten.Gebruiker;


public class GebruikerDAO extends BaseDAO {

	  private List<Gebruiker> selectGebruiker(String query) {
	    List<Gebruiker> results = new ArrayList<Gebruiker>();
	    try (Connection con = super.getConnection()){
	      Statement stmt = con.createStatement();
	      ResultSet dbResultSet = stmt.executeQuery(query);

	      while (dbResultSet.next()) {
	        String gebruikersnaam = dbResultSet.getString("gebruikersnaam");
	        String naam = dbResultSet.getString("naam");
	        String wachtwoord = dbResultSet.getString("wachtwoord");
	        String emailadres = dbResultSet.getString("emailadres");
	 
	        Gebruiker newGebruiker = new Gebruiker(gebruikersnaam, naam, wachtwoord, emailadres);
	        
	        
	        results.add(newGebruiker);
	      }
	    } catch (SQLException sqle) { sqle.printStackTrace(); }
	    
	    return results;
	  }
	  

	  // alle gebruikers weergeven
	public List<Gebruiker> findAll() { 
	    return selectGebruiker("SELECT * from geregistreerdewebsitebezoeker"); 
	  }
	  
	  // nieuwe gebruiker aanmaken
	public Gebruiker save(Gebruiker gebruiker) {
		try (Connection con = getConnection()) {
			
			Statement stmt = con.createStatement();
			String query = "INSERT INTO geregistreerdewebsitebezoeker(gebruikersnaam, naam, wachtwoord, emailadres) VALUES('" + gebruiker.getGebruikersnaam() + "', '" + gebruiker.getNaam() + "', '" + gebruiker.getWachtwoord() + "', '" + gebruiker.getEmailadres() + "')";
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			System.out.println("Gebruiker toegevoegd");

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return gebruiker;
		
	}

}
