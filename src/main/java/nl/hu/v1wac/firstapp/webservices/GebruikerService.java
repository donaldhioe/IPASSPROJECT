package nl.hu.v1wac.firstapp.webservices;

import java.util.List;

import nl.hu.v1wac.firstapp.entiteiten.Gebruiker;
import nl.hu.v1wac.firstapp.persistence.GebruikerDAO;

public class GebruikerService {
	
	private GebruikerDAO CDAO = new GebruikerDAO();
	
	public List<Gebruiker> getAllGebruikers() {
		return CDAO.findAll();
		
	}
	
	public Gebruiker createGebruiker(Gebruiker gebruiker) {
		return CDAO.save(gebruiker);
	}
	
	
	
}

