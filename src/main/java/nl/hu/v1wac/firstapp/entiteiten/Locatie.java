package nl.hu.v1wac.firstapp.entiteiten;

public class Locatie {
	private int locatienummer;
	private String naam;
	private String plaats;
	private String straat;
	private String lokaal;
	public Locatie(int locatienummer, String naam, String plaats, String straat, String lokaal) {
		this.locatienummer = locatienummer;
		this.naam = naam;
		this.plaats = plaats;
		this.straat = straat;
		this.lokaal = lokaal;
	};
	public int getLocatienummer() {
		return locatienummer;
	}
	public void setLocatienummer(int locatienummer) {
		this.locatienummer = locatienummer;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getPlaats() {
		return plaats;
	}
	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}
	public String getStraat() {
		return straat;
	}
	public void setStraat(String straat) {
		this.straat = straat;
	}
	public String getLokaal() {
		return lokaal;
	}
	public void setLokaal(String lokaal) {
		this.lokaal = lokaal;
	}
	
	
	

}
