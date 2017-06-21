package nl.hu.v1wac.firstapp.entiteiten;

public class Gebruiker {
	private String gebruikersnaam;
	private String naam;
	private String wachtwoord;
	private String emailadres;

	
	
	public Gebruiker(String gebruikersnaam, String naam, String wachtwoord, String emailadres) {
		this.gebruikersnaam = gebruikersnaam;
		this.naam = naam;
		this.wachtwoord = wachtwoord;
		this.emailadres = emailadres;
	}
	
	public String getGebruikersnaam() {
		return gebruikersnaam;
	}
	

	
	public String getNaam() {
		return naam;
	}
	
	
	public String getWachtwoord() {
		return wachtwoord;
	}
	

	
	public String getEmailadres() {
		return emailadres;
	}
	

	

}
