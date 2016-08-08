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
	 * @param userService
	 * @param driveService
	 */
	public DatabaseHelper(MitfahrenUserService userService, DriveService driveService) {
		super();
		this.userService = userService;
		this.driveService = driveService;
	}



	public void storeTestData() {
		MitfahrenUser testUser = new MitfahrenUser("Max Mustermann", "1234", "5678");
		userService.persists(testUser);
		Calendar nowCalendar = Calendar.getInstance();
		Drive drive = new Drive("Braunschweig", "Hannover", 
				nowCalendar,testUser);
		driveService.persists(drive);
	}
}
