package apiv1.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import apiv1.models.City;
import apiv1.models.Drive;
import apiv1.models.DriveService;

@Path("/")
public class RestApi {
	
	@Inject
	DriveService driveService;
	
	@GET
	@Path("/possibleCities")
	@Produces(MediaType.APPLICATION_JSON)
	public List<City> getPossibleCities(){
		List<City> possibleCities = new LinkedList<>();
		possibleCities.add(new City("Braunschweig", "http://file2.npage.de/012910/36/bilder/loewe.jpg"));
		possibleCities.add(new City("Gießen"));
		possibleCities.add(new City("Hannover"));
		return possibleCities;
	}
	
	@POST
	@Path("/possibleDrives")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Drive> postPossibleDrives(){
		City dest = new City("Braunschweig");
		City arr = new City("Hannover");
		Date date = new Date();
		
		Drive drive = new Drive(dest, arr, date, null);
		
		driveService.persists(drive);
		return null; //driveService.findByDestinationArrival("Braunschweig", "Hannover");
	}
	
}
