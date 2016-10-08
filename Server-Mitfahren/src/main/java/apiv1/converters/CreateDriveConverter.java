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
		try {
		if(ValidationHelper.validateUser(userService, request.username, request.password, request.userId)) {
			
			City destination = cityService.find(request.destination);
			City arrival = cityService.find(request.arrival);
			Calendar dateTime = CalendarHelper.convertCalendar(request.date, request.time);
			int carSpace = Integer.parseInt(request.passengerCount);
			MitfahrenUser driver = userService.find(Integer.parseInt(request.userId));
			int price = Integer.parseInt(request.price);
			
			Drive newDrive = new Drive(destination, arrival, dateTime, driver, carSpace, request.commentary, price);
			newDrive = driveSerive.merge(newDrive);
			
			return creationSucess(newDrive.getDriveId());
		} else {
			return creationFailed();
		}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return creationFailed();
		}
	}
	
	private CreateDriveResponse creationFailed() {
		CreateDriveResponse creationFailed = new CreateDriveResponse();
		creationFailed.isCreated = false;
		creationFailed.driveId = 0;
		return creationFailed;
	}
	
	private CreateDriveResponse creationSucess(int driveId) {
		CreateDriveResponse creationSucess = new CreateDriveResponse();
		creationSucess.isCreated = true;
		creationSucess.driveId = driveId;
		return creationSucess;
	}
}
