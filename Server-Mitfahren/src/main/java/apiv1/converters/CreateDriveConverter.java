package apiv1.converters;

import apiv1.models.request.CreateDriveModel;
import apiv1.models.response.CreateDriveResponse;
import entities.DriveService;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;
import helper.ValidationHelper;

public class CreateDriveConverter {

	private DriveService driveSerive;
	private MitfahrenUserService userService;
	
	public CreateDriveConverter(DriveService driveService, MitfahrenUserService userService) {
		this.driveSerive = driveService;
		this.userService = userService;
	}
	
	public CreateDriveResponse convert(CreateDriveModel request) {
		
		if(ValidationHelper.validateUser(userService, request.username, request.password, request.userId)) {
			//Convert
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
