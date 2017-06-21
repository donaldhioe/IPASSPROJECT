package nl.hu.v1wac.firstapp.webservices;

public class ServiceProvider {
	private static GebruikerService gebruikerService = new GebruikerService();
	private static AanvraagService aanvraagService = new AanvraagService();

	public static GebruikerService getGebruikerService() {
		return gebruikerService;
	}
	
	public static AanvraagService getAanvraagService() {
		return aanvraagService;
	}
	
}
