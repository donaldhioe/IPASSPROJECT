package nl.hu.v1wac.firstapp.webservices;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;

import javax.ws.rs.Produces;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import nl.hu.v1wac.firstapp.entiteiten.Gebruiker;

@Path("/gebruiker")
public class GebruikerResource {
	GebruikerService service = ServiceProvider.getGebruikerService();
	
	
	@GET
	@Produces("application/json")
	public String getAllGebruikers() {
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for ( Gebruiker g : service.getAllGebruikers()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("gebruikersnaam", g.getGebruikersnaam());
			job.add("naam", g.getNaam());
			job.add("wachtwoord", g.getWachtwoord());
			job.add("emailadres", g.getEmailadres());

			jab.add(job);			
		}
		
		JsonArray array = jab.build();

		return array.toString();		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public String createGebruiker(@FormParam("gebruikersnaam") String gebruikersnaam,
								  @FormParam("naam") String naam,
								  @FormParam("wachtwoord") String wachtwoord,
								  @FormParam("emailadres") String emailadres,
								  @Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("verwerken gebruiker");
		Gebruiker newGebruiker = new Gebruiker(gebruikersnaam, naam, wachtwoord, emailadres);
		service.createGebruiker(newGebruiker);
		System.out.println("gebruiker geadd");
		return gebruikerToJson(newGebruiker).build().toString();
	
		
	}
	
	private JsonObjectBuilder gebruikerToJson( Gebruiker g) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("gebruikersnaam", g.getGebruikersnaam());
		job.add("naam", g.getNaam());
		job.add("wachtwoord", g.getWachtwoord());
		job.add("emailadres", g.getEmailadres());
		return job;
		
	}

}
