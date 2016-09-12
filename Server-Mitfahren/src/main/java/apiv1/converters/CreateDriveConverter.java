package apiv1.converters;

import java.util.Calendar;

import apiv1.models.request.CreateDriveModel;
import apiv1.models.response.CreateDriveResponse;
import entities.City;
import entities.CityService;
import entities.Drive;
import entities.DriveService;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;
import helper.CalendarHelper;
import helper.ValidationHelper;

public class CreateDriveConverter {

	private DriveService driveSerive;
	private MitfahrenUserService userService;
	private CityService cityService;
	
	public CreateDriveConverter(DriveService driveService, MitfahrenUserService userService, CityService cityService) {
		this.driveSerive = driveService;
		this.userService = userService;
		this.cityService = cityService;
	}
	
	public CreateDriveResponse convert(CreateDriveModel request) {
		
		if(ValidationHelper.validateUser(userService, request.username, request.password, request.userId)) {
			//Drive newDrive = new Drive(destination, arrival, calendar, driver, carSpace);
			City destination = cityService.find(request.destination);
			City arrival = cityService.find(request.arrival);
			//Calendar time = CalendarHelper.convertCalenderDayAndTime(calendarString);
		} else {
			return creationFailed();
		}
		
		return null;
	}
	
	
	private CreateDriveResponse creationFailed() {
		CreateDriveResponse creationFailed = new CreateDriveResponse();
		creationFailed.isCreated = false;
		creationFailed.driveId = 0;
		return creationFailed;
	}
}
