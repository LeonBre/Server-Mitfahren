package apiv1.converters;

import java.util.LinkedList;
import java.util.List;

import apiv1.models.request.UserPageInfoRequest;
import apiv1.models.response.UserPageInfoResponse;
import apiv1.models.response.helpermodel.UserPageInfoDrive;
import apiv1.validator.AuthenticationValidator;
import entities.Drive;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;

public class UserPageInfoConverter {

	MitfahrenUserService userService;
	
	public UserPageInfoConverter(MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	public UserPageInfoResponse convert (UserPageInfoRequest request) {
		UserPageInfoResponse response = new UserPageInfoResponse();
		MitfahrenUser user = userService.find(request.userId);
		
		if (user == null || !AuthenticationValidator.authenticateUser(user, request.username, request.password)) {
			response.success = false;
			return response;
		}
		response.success = true;
		response.username = user.getUsername();
		response.rating = user.getUserRating() + "";
		response.phoneNumber = user.getTelephoneNumber();
		response.mail = user.getUserMail();
		
		List<UserPageInfoDrive> infoList = new LinkedList<>();
		for (Drive drive:user.getAsDriverList()) {
			UserPageInfoDrive entry = new UserPageInfoDrive();
			entry.arrival = drive.getArrival().getName();
			entry.destination = drive.getDestination().getName();
			entry.driverCount = drive.getPassengers().size() + "";
			entry.price = drive.getPrice() + "";
			infoList.add(entry);
		}
		response.drives = infoList;
		return response;
	}
}
