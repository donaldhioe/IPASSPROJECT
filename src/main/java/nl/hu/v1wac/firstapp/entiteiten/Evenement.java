package nl.hu.v1wac.firstapp.entiteiten;


public class Evenement {
	private int evenementnummer;
	private String datum;
	private String plaats;
	private String festivalnaam;
	private String bericht;
	private String opmerking;
	private String geaccepteerd;
	private String gebruikersnaam;
	private Gebruiker emailadres;
	
	
	public Evenement(int evenementnummer, String datum, String plaats, String festivalnaam, String bericht, String opmerking, String geaccepteerd, String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
		this.evenementnummer = evenementnummer;
		this.datum = datum;
		this.plaats = plaats;
		this.festivalnaam = festivalnaam;
		this.bericht = bericht;
		this.opmerking = opmerking;
		this.geaccepteerd = geaccepteerd;
		//this.emailadres = emailadres;
	}
	
	public Evenement( String plaats, String festivalnaam, String bericht, String gebruikersnaam, String datum) {
		this.gebruikersnaam = gebruikersnaam;
		this.plaats = plaats;
		this.festivalnaam = festivalnaam;
		this.bericht = bericht;
		this.datum = datum;
	}
	
	public String getGebruikersnaam() {
		return gebruikersnaam;
	}
	
	public int getEvenementnummer() {
		return evenementnummer;
	}
	
	public String getDatum() {
		return datum;
	}
	
	public String getPlaats() {
		return plaats;
	}
	
	public String getFestivalnaam() {
		return festivalnaam;
	}
	
	public String getBericht() {
		return bericht;
	}
	
	public String getOpmerking() {
		return opmerking;
	}
	
	public String getGeaccepteerd() {
		return geaccepteerd;
	}
	
	public Gebruiker getEmailadres() {
		return emailadres;
	}

}
