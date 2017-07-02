package nl.hu.v1wac.firstapp.entiteiten;


public class Evenement {
	private int evenementnummer;

	private String festivalnaam;
	private String bericht;
	private String opmerking;
	private String geaccepteerd;
	private String gebruikersnaam;
	private Locatie locatie;
	
	
	public Evenement(int evenementnummer, String festivalnaam, String bericht, String opmerking, String geaccepteerd, String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
		this.evenementnummer = evenementnummer;

		this.festivalnaam = festivalnaam;
		this.bericht = bericht;
		this.opmerking = opmerking;
		this.geaccepteerd = geaccepteerd;
	}
	
	public Evenement( String festivalnaam, String bericht, String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
		this.festivalnaam = festivalnaam;
		this.bericht = bericht;

	}
	public Evenement(int evenementnummer, String opmerking) {
		this.evenementnummer = evenementnummer;
		this.opmerking = opmerking;
	}
	
	public String getGebruikersnaam() {
		return gebruikersnaam;
	}
	
	public int getEvenementnummer() {
		return evenementnummer;
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

	public Locatie getLocatie() {
		return locatie;
	}

	public void setLocatie(Locatie locatie) {
		this.locatie = locatie;
	}
	


}
