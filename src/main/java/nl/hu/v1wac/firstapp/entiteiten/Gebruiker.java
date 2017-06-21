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
	
	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public String getWachtwoord() {
		return wachtwoord;
	}
	
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	
	public String getEmailadres() {
		return emailadres;
	}
	
	public void setEmailadres(String emailadres) {
		this.emailadres = emailadres;
	}
	

}
