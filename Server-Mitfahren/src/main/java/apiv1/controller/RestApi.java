package apiv1.controller;

import java.util.Calendar;
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

import apiv1.converters.SearchConverter;
import apiv1.models.AnswerDrive;
import apiv1.models.DriveDetail;
import apiv1.models.SearchDrive;
import entities.City;
import entities.Drive;
import entities.DriveService;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;
import helper.DatabaseHelper;
import helper.JsonHelper;

/**
 * Rest Api from the Server.
 * It serves as an interface for the client.
 * @author Leon Johann Brettin
 *
 */
@Path("/")
public class RestApi {
	
	@Inject
	DriveService driveService;
	@Inject
	MitfahrenUserService userService;
	
	/**
	 * First Method to send all cities for the Autocomplete Code.
	 * The client gets all possible cities and when existing, a picture for that city.
	 * It will be loaded on the client, when the webpage is opened.
	 * @return List of all cities for the Autocomplete.
	 */
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
	
	/**
	 * Method to send a List of results from a given search input.
	 * When the Users presses the search button and the input is valid this method is called.
	 * It searches for all possible drives that matches to the input.
	 * @param input Json with destination, arrival, date.
	 * @return List of possible results.
	 */
	@POST
	@Path("/possibleDrives")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<AnswerDrive> postPossibleDrives(SearchDrive searchInput){
		//JsonElement jElement = new JsonParser().parse(input);
		//SearchDrive drive = JsonHelper.convertJElementToSearchDrive(jElement);
		SearchConverter convert = new SearchConverter(driveService);
		return convert.getSearchedDrives(searchInput);
	}
	
	@POST
	@Path("/driveDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DriveDetail postDriveDetails(int DriveId) {
		
		return null;
	}
	
	@GET
	@Path("/testDatabase")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Drive> testDatabase() {
		DatabaseHelper dbHelper = new DatabaseHelper(userService, driveService);
		dbHelper.storeTestData();
		return driveService.findByDestinationArrival("Braunschweig", "Hannover");
	}
}
