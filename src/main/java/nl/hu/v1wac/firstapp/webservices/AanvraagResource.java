package nl.hu.v1wac.firstapp.webservices;

import java.io.IOException;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.hu.v1wac.firstapp.entiteiten.Evenement;
import nl.hu.v1wac.firstapp.entiteiten.Locatie;

@Path("/aanvraag")

public class AanvraagResource {
	AanvraagService service = ServiceProvider.getAanvraagService();
	@GET
	@Produces("application/json")
	public String getAllAanvragen() {
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for ( Evenement a : service.getAllAanvragen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("evenementnummer", a.getEvenementnummer());
			job.add("gebruikersnaam", a.getGebruikersnaam());
			job.add("festivalnaam", a.getFestivalnaam());
			job.add("bericht", a.getBericht());
			job.add("geaccepteerd", a.getGeaccepteerd());
			job.add("opmerking", a.getOpmerking());
			job.add("naam", a.getLocatie().getNaam());
			job.add("plaats", a.getLocatie().getPlaats());
			job.add("naam", a.getLocatie().getNaam());
			job.add("straat", a.getLocatie().getStraat());
			job.add("lokaal", a.getLocatie().getLokaal());
			
			
			jab.add(job);
			
		}
		
		JsonArray array = jab.build();

		return array.toString();
		
	}
	
	@GET
	@Path("/geaccepteerd")
	@Produces("application/json")
	public String getAanvragenByGeaccepteerd() {
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for ( Evenement a : service.getAanvraagByGeaccepteerd()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("evenementnummer", a.getEvenementnummer());
			job.add("gebruikersnaam", a.getGebruikersnaam());
			job.add("festivalnaam", a.getFestivalnaam());
			job.add("bericht", a.getBericht());
			job.add("geaccepteerd", a.getGeaccepteerd());
			job.add("opmerking", a.getOpmerking());
			job.add("naam", a.getLocatie().getNaam());
			job.add("plaats", a.getLocatie().getPlaats());
			job.add("naam", a.getLocatie().getNaam());
			job.add("straat", a.getLocatie().getStraat());
			job.add("lokaal", a.getLocatie().getLokaal());
			
			jab.add(job);
			
		}
		
		JsonArray array = jab.build();

		return array.toString();
		
	}
	
	@GET
	@Path("/nognietgeaccepteerd")
	@Produces("application/json")
	public String getAanvragenByNogNietGeaccepteerd() {
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for ( Evenement a : service.getAanvraagByNogNietGeaccepteerd()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("evenementnummer", a.getEvenementnummer());
			job.add("gebruikersnaam", a.getGebruikersnaam());
			job.add("festivalnaam", a.getFestivalnaam());
			job.add("bericht", a.getBericht());
			job.add("geaccepteerd", a.getGeaccepteerd());
			job.add("opmerking", a.getOpmerking());
			job.add("naam", a.getLocatie().getNaam());
			job.add("plaats", a.getLocatie().getPlaats());
			job.add("naam", a.getLocatie().getNaam());
			job.add("straat", a.getLocatie().getStraat());
			job.add("lokaal", a.getLocatie().getLokaal());
			
			jab.add(job);
			
		}
		
		JsonArray array = jab.build();

		return array.toString();
		
	}
	
	@GET
	@Path("/geweigerd")
	@Produces("application/json")
	public String getAanvragenByGeweigerd() {
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for ( Evenement a : service.getAanvraagByGeweigerd()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("evenementnummer", a.getEvenementnummer());
			job.add("gebruikersnaam", a.getGebruikersnaam());
			job.add("festivalnaam", a.getFestivalnaam());
			job.add("bericht", a.getBericht());
			job.add("geaccepteerd", a.getGeaccepteerd());
			job.add("opmerking", a.getOpmerking());
			job.add("naam", a.getLocatie().getNaam());
			job.add("plaats", a.getLocatie().getPlaats());
			job.add("naam", a.getLocatie().getNaam());
			job.add("straat", a.getLocatie().getStraat());
			job.add("lokaal", a.getLocatie().getLokaal());
			
			jab.add(job);
			
		}
		
		JsonArray array = jab.build();

		return array.toString();
		
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public String createAanvraag(@FormParam("gebruikersnaam") String gebruikersnaam,
								 @FormParam("festivalnaam") String festivalnaam,
								 @FormParam("bericht") String bericht,
								 @Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("aanvraag verwerken");
		Evenement newAanvraag = new Evenement( gebruikersnaam, festivalnaam, bericht);
		service.createAanvraag(newAanvraag);
		System.out.println("aanvraag geadded");
		return aanvraagToJson(newAanvraag).build().toString();
	}
	
	
	
	@DELETE
	@Path("{evenementnummer}")
	public Response deleteEvenement(@PathParam("evenementnummer") int evenementnummer) {
		System.out.println("Deleting aanvraag");
		AanvraagService service = ServiceProvider.getAanvraagService();

		
		Evenement found = null;
		for (Evenement e : service.getAllAanvragen()) {
			if (e.getEvenementnummer() == evenementnummer) {
				found = e; 
				break;
			}
		}
		if (found == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
			} else {
				service.deleteAaanvraag(found);
				System.out.println("aanvraag verwijderd");
				return Response.ok().build();
			}
	}

	
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("{evenementnummer}") 
	@Produces("application/json") 
	public Response updateAanvraag(@PathParam("evenementnummer") int evenementnummer) {
		System.out.println("update aanvraag");
		Evenement found = null;
		for (Evenement e : service.getAllAanvragen()) {
			if(e.getEvenementnummer() == evenementnummer) {
				found = e;
				break;
			}
		}
		if (found == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
			} else {
				service.addEvenement(found);
				System.out.println("aanvraag geupdated");
				return Response.ok().build();
			}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/weigeren/{evenementnummer}") 
	@Produces("application/json") 
	public Response weigerAanvraag(@PathParam("evenementnummer") int evenementnummer) {
		System.out.println("update aanvraag weigeren");
		Evenement found = null;
		for (Evenement e : service.getAllAanvragen()) {
			if(e.getEvenementnummer() == evenementnummer) {
				found = e;
				break;
			}
		}
		if (found == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
			} else {
				service.weigerEvenement(found);
				System.out.println("aanvraag geweigerd");
				return Response.ok().build();
			}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/opmerking/{evenementnummer}") 
	@Produces("application/json") 
	public String updateOpmerking(@PathParam("evenementnummer") int evenementnummer,
									@FormParam("opmerking") String opmerking) {
		System.out.println("update opmerking");
		Evenement evenement = service.getAanvraagByAanvraagnummer(evenementnummer);
		Evenement updateOpmerking = new Evenement(evenement.getEvenementnummer(), opmerking);
		service.addOpmerking(updateOpmerking);
		return "succes";
		
	}
	private JsonObjectBuilder aanvraagToJson(Evenement e) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("gebruikersnaam", e.getGebruikersnaam());
		job.add("festivalnaam", e.getFestivalnaam());
		job.add("bericht", e.getBericht());

		return job;
	}
}
