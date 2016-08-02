package apiv1.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import apiv1.models.SearchDrive;
import entities.City;
import entities.Drive;
import entities.DriveService;
import helper.JsonHelper;

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
	@Produces(MediaType.APPLICATION_JSON)
	public SearchDrive postPossibleDrives(String input){
		JsonElement jElement = new JsonParser().parse(input);
		SearchDrive drive = JsonHelper.convertJElementToSearchDrive(jElement);
		return drive;
	}
	
}
