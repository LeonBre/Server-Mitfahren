package helper;

import java.util.Calendar;

import javax.inject.Inject;

import entities.City;
import entities.CityService;
import entities.Drive;
import entities.DriveService;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;

public class DatabaseHelper {
	
	MitfahrenUserService userService;
	DriveService driveService;
	CityService cityService;
	
	/**
	 * @param userService Service to interact with the Database on MitfahrenUser objects.
	 * @param driveService Service to interact with the Database on Drive objects.
	 */
	public DatabaseHelper(MitfahrenUserService userService, DriveService driveService, CityService cityService) {
		super();
		this.userService = userService;
		this.driveService = driveService;
		this.cityService = cityService;
	}


	/**
	 * Stores test data in the database.
	 */
	public void storeTestData() {
		City braunschweig = new City("Braunschweig");
		City berlin = new City("Berlin");
		City hannover = new City("Hannover");
		
		cityService.persists(braunschweig);
		cityService.persists(berlin);
		cityService.persists(hannover);
		
		MitfahrenUser testUser1 = new MitfahrenUser("Max Mustermann", "1234", "046334567");
		MitfahrenUser testUser2 = new MitfahrenUser("Netter Fahrer", "5678", "017011223344");
		MitfahrenUser testUser3 = new MitfahrenUser("Klaus Kleber", "91011", "0160123456");
		MitfahrenUser testUser4 = new MitfahrenUser("Karla Kolumna", "1357", "18027235");
		testUser1.addComment("Fahrt war supi", 5f, testUser2.getUserId());
		testUser1.addComment("Ich fand die fahrt gewöhnungsbedürftig...", 2f, testUser4.getUserId());
		userService.persists(testUser1);
		userService.persists(testUser2);
		userService.persists(testUser3);
		userService.persists(testUser4);
		Calendar nowCalendar = Calendar.getInstance();
		Drive drive1 = new Drive(new City("Braunschweig"), "Hannover", 
				nowCalendar,testUser1, 4);
		Drive drive2 = new Drive(braunschweig, "Lübeck", 
				nowCalendar,testUser1, 4);
		Drive drive3 = new Drive(berlin, "München", 
				nowCalendar,testUser1, 4);
		Drive drive4 = new Drive(braunschweig, "Hannover", 
				nowCalendar,testUser1, 3);
		Drive drive5 = new Drive(hannover, "Braunschweig", 
				nowCalendar,testUser1, 2);
		driveService.persists(drive1);
		driveService.persists(drive2);
		driveService.persists(drive3);
		driveService.persists(drive4);
		driveService.persists(drive5);
		
		
	}
}
