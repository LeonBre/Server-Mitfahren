package helper;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import entities.DriveService;
import entities.MitfahrenUserService;

@Singleton
@Startup
public class StartupHelper {

	@Inject
	MitfahrenUserService userService;
	@Inject
	DriveService driveService;
	@PostConstruct
	public void startup() {
		DatabaseHelper dbHelper = new DatabaseHelper(userService, driveService);
		dbHelper.storeTestData();
	}
}
