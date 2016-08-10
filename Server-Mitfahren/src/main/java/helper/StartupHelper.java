package helper;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import entities.CityService;
import entities.DriveService;
import entities.MitfahrenUserService;

/**
 * Helper class to do methods on startup.
 * @author Leon Johann Brettin
 *
 */
@Singleton
@Startup
public class StartupHelper {

	@Inject
	MitfahrenUserService userService;
	@Inject
	DriveService driveService;
	@Inject
	CityService cityService;
	/**
	 * Startup Method
	 * In this method the database helper persists some testing data.
	 */
	@PostConstruct
	public void startup() {
		DatabaseHelper dbHelper = new DatabaseHelper(userService, driveService, cityService);
		dbHelper.storeTestData();
	}
}
