package helper;

import java.util.Calendar;

import javax.inject.Inject;

import entities.Drive;
import entities.DriveService;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;

public class DatabaseHelper {
	
	MitfahrenUserService userService;
	DriveService driveService;
	
	/**
	 * @param userService Service to interact with the Database on MitfahrenUser objects.
	 * @param driveService Service to interact with the Database on Drive objects.
	 */
	public DatabaseHelper(MitfahrenUserService userService, DriveService driveService) {
		super();
		this.userService = userService;
		this.driveService = driveService;
	}


	/**
	 * Stores test data in the database.
	 */
	public void storeTestData() {
		MitfahrenUser testUser1 = new MitfahrenUser("Max Mustermann", "1234", "046334567");
		MitfahrenUser testUser2 = new MitfahrenUser("Netter Fahrer", "5678", "017011223344");
		MitfahrenUser testUser3 = new MitfahrenUser("Klaus Kleber", "91011", "0160123456");
		MitfahrenUser testUser4 = new MitfahrenUser("Karla Kolumna", "1357", "18027235");
		userService.persists(testUser1);
		userService.persists(testUser2);
		userService.persists(testUser3);
		userService.persists(testUser4);
		Calendar nowCalendar = Calendar.getInstance();
		Drive drive1 = new Drive("Braunschweig", "Hannover", 
				nowCalendar,testUser1);
		Drive drive2 = new Drive("Gießen", "Lübeck", 
				nowCalendar,testUser1);
		Drive drive3 = new Drive("Berlin", "München", 
				nowCalendar,testUser1);
		Drive drive4 = new Drive("Braunschweig", "Hannover", 
				nowCalendar,testUser1);
		Drive drive5 = new Drive("Hannover", "Braunschweig", 
				nowCalendar,testUser1);
		driveService.persists(drive1);
		driveService.persists(drive2);
		driveService.persists(drive3);
		driveService.persists(drive4);
		driveService.persists(drive5);
	}
}
