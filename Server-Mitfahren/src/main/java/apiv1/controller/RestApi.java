package apiv1.controller;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Produces; 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import apiv1.models.PossibleCity;

@Path("/")
public class RestApi {

	@GET
	@Path("/possibleCities")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PossibleCity> getPossibleCities(){
		List<PossibleCity> possibleCities = new LinkedList<>();
		possibleCities.add(new PossibleCity("Braunschweig", "http://file2.npage.de/012910/36/bilder/loewe.jpg"));
		possibleCities.add(new PossibleCity("Gießen"));
		possibleCities.add(new PossibleCity("Hannover"));
		return possibleCities;
	}
}
