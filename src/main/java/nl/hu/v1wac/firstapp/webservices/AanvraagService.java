package nl.hu.v1wac.firstapp.webservices;

import java.util.List;

import nl.hu.v1wac.firstapp.entiteiten.Evenement;
import nl.hu.v1wac.firstapp.persistence.EvenementDao;

public class AanvraagService {
	
	private EvenementDao CDAO = new EvenementDao();
	
	public List<Evenement> getAllAanvragen() {
		return CDAO.findAll();
		
	}
	
	public List<Evenement> getAanvraagByGeaccepteerd() {
		return CDAO.findByGeaccepteerd();
	}


	public Evenement getAanvraagByAanvraagnummer(int evenementnummer) {
		return CDAO.findByAanvraagnummer(evenementnummer);
		
	}
	
	public Evenement deleteAaanvraag(Evenement evenement) {
		return CDAO.deleteEvenement(evenement);
	}
	
	public Evenement createAanvraag(Evenement evenement) {
		return CDAO.createEvenement(evenement);
	}
	
	public Evenement addEvenement(Evenement evenement) {
		return CDAO.addEvenement(evenement);
	}
	
	public Evenement addOpmerking(Evenement evenement) {
		return CDAO.addOpmerking(evenement);
	}

}
