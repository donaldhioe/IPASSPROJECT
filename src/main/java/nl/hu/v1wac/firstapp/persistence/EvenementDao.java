package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import nl.hu.v1wac.firstapp.entiteiten.Evenement;

public class EvenementDao extends BaseDAO {
	
	private List<Evenement> selectEvenement(String query) {
	    List<Evenement> results = new ArrayList<Evenement>();
	    try (Connection con = super.getConnection()){
	      Statement stmt = con.createStatement();
	      ResultSet dbResultSet = stmt.executeQuery(query);

	      while (dbResultSet.next()) {
	    	  int evenementnummer = dbResultSet.getInt("evenementnummer");
		        String gebruikersnaam = dbResultSet.getString("gebruikersnaam");        
		        String plaats = dbResultSet.getString("plaats");
		        String festivalnaam = dbResultSet.getString("festivalnaam");
		        String bericht = dbResultSet.getString("aanvraagbericht");
		        String opmerking = dbResultSet.getString("opmerking");
		        String geaccepteerd = dbResultSet.getString("geaccepteerd");
		        String datum = dbResultSet.getString("datum");

	 
	        Evenement newEvenement = new Evenement(evenementnummer, datum, plaats, festivalnaam, bericht, opmerking, geaccepteerd, gebruikersnaam);
	        
	        results.add(newEvenement);
	      }
	    } catch (SQLException sqle) { sqle.printStackTrace(); }
	    
	    return results;
	  }
	  

	//alle informatie van de tabel evenement weergeven
	public List<Evenement> findAll() { 
	    return selectEvenement("SELECT * from evenement"); 
	  }
	//alle informatie van de tabel weergeven die geaccepteerd zijn
	public List<Evenement> findByGeaccepteerd() {
		return selectEvenement("SELECT * from evenement where geaccepteerd = 'ja'"); 
	}
	  
	// alle informatie van de tabel vinden die gelinkt zijn met de evenementnummer
	public Evenement findByAanvraagnummer(int evenementnummer) {
		return selectEvenement("SELECT * from evenement where evenementnummer = " + evenementnummer).get(0);
	}
	//een evenement verwijderen uit de database
	public Evenement deleteEvenement(Evenement evenement) {
		try (Connection con = getConnection()) {			
			Statement stmt = con.createStatement();
			String query = "DELETE FROM evenement where evenementnummer = " + evenement.getEvenementnummer();
			stmt.executeUpdate(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return evenement;
	}
	// een nieuwe evenement aanvraag aanmaken
	public Evenement createEvenement(Evenement evenement) {
		try (Connection con = getConnection()) {			
			Statement stmt = con.createStatement();
			String query = "INSERT INTO evenement (evenementnummer, plaats, festivalnaam, aanvraagbericht, opmerking, geaccepteerd, gebruikersnaam)VALUES(nextval('evenementnr'), '" + evenement.getPlaats() + "', '" + evenement.getFestivalnaam() + "', '" + evenement.getBericht() + "', '', '?', '" + evenement.getGebruikersnaam() + "')";
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return evenement;
	}
	// de aangevraagde evenement accepteren
	public Evenement addEvenement(Evenement evenement) {
		try (Connection con = getConnection()) {			
			Statement stmt = con.createStatement();
			String query = "UPDATE evenement SET geaccepteerd = 'ja' where evenementnummer =" + evenement.getEvenementnummer();
			stmt.executeUpdate(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return evenement;
	}
	// een opmerking toevoegen voor bij een geaccepteerde evenement
	public Evenement addOpmerking(Evenement evenement) {
		try (Connection con = getConnection()) {			
			Statement stmt = con.createStatement();
			String query = "UPDATE evenement SET opmerking = 'dit is een test' where evenementnummer =" + evenement.getEvenementnummer();
			stmt.executeUpdate(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return evenement;
	}

}
