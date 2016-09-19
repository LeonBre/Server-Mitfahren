package apiv1.controller;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import apiv1.converters.ActivationConverter;
import apiv1.converters.AuthenticationConverter;
import apiv1.converters.CreateDriveConverter;
import apiv1.converters.DriveDetailConverter;
import apiv1.converters.MitfahrenUserDetailConverter;
import apiv1.converters.RegistrationConverter;
import apiv1.converters.SearchConverter;
import apiv1.models.request.ActivationModel;
import apiv1.models.request.AuthenticateUserModel;
import apiv1.models.request.CreateDriveModel;
import apiv1.models.request.RegisterUserModel;
import apiv1.models.request.SearchDrive;
import apiv1.models.request.SearchDriveDetail;
import apiv1.models.request.SearchMitfahrenUserDetail;
import apiv1.models.response.ActivationResponse;
import apiv1.models.response.AnswerDrive;
import apiv1.models.response.AuthenticateUserResponse;
import apiv1.models.response.CreateDriveResponse;
import apiv1.models.response.DriveDetail;
import apiv1.models.response.MitfahrenUserDetail;
import apiv1.models.response.RegisterUserResponse;
import apiv1.validator.AuthenticationValidator;
import entities.City;
import entities.CityService;
import entities.Drive;
import entities.DriveService;
import entities.MitfahrenUserService;
import helper.DatabaseHelper;
import helper.HashHelper;

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
	@Inject
	CityService cityService;
	
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
	public List<AnswerDrive> postPossibleDrives(SearchDrive request){
		SearchConverter convert = new SearchConverter(driveService);
		return convert.getSearchedDrives(request);
	}
	
	@POST
	@Path("/driveDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DriveDetail postDriveDetails(SearchDriveDetail driveId) {
		DriveDetailConverter convert = new DriveDetailConverter(driveService);
		return convert.convertDriveIdtoAnswerDrive(driveId.getDriveId());
	}
	
	@POST
	@Path("/userDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MitfahrenUserDetail postMitfahrenUserDetails(SearchMitfahrenUserDetail userId) {
		MitfahrenUserDetailConverter convert = new MitfahrenUserDetailConverter(userService);
		return convert.convertIdToModel(userId.userId);
	}
	
	@POST
	@Path("/authenticate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AuthenticateUserResponse postAuthenticateUser(AuthenticateUserModel request) {
		AuthenticationConverter converter = new AuthenticationConverter(userService);
		return converter.convertModelToResponse(request);
	}
	
	@POST
	@Path("/registerUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RegisterUserResponse postRegisterUser(RegisterUserModel request) {
		RegistrationConverter converter = new RegistrationConverter(userService);
		return converter.convert(request);
	}
	
	@POST
	@Path("/activateUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ActivationResponse postActivateUser(ActivationModel request) {
		ActivationConverter converter = new ActivationConverter(userService);
		return converter.convert(request);
	}
	
	@POST
	@Path("/createDrive")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CreateDriveResponse postCreateDrive(CreateDriveModel request) {
		CreateDriveConverter converter = new CreateDriveConverter(driveService, userService, cityService);
		return converter.convert(request);
	}
	
	@POST
	@Path("/testAuthenticate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AuthenticateUserResponse postTestAuthenticate(AuthenticateUserModel request) {
		AuthenticateUserResponse trueResponse = new AuthenticateUserResponse();
		trueResponse.isAuthenticated = true;
		trueResponse.userId = 1;
		return trueResponse;
	}
	
	@POST
	@Path("/testHash")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String testHash(String input) {
		String ausgabe = HashHelper.get_SHA_512_SecurePassword("", "");
		System.out.println(ausgabe);
		System.out.println(input);
		return input.toString();
	}
	
	@GET
	@Path("/testDatabase")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Drive> testDatabase() {
		DatabaseHelper dbHelper = new DatabaseHelper(userService, driveService, cityService);
		dbHelper.storeTestData();
		return driveService.findByDestinationArrival("Braunschweig", "Hannover");
	}
	
	@POST
	@Path("/testFileUpload")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TestingClass testFileUpload(TestingClass input) {
		System.out.println(input.data);
		return input;
	}
}

class TestingClass{
	public String data;
	
	public TestingClass(){}
}