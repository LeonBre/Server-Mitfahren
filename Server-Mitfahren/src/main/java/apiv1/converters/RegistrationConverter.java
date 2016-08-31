package apiv1.converters;

import apiv1.models.request.RegisterUserModel;
import apiv1.models.response.RegisterUserResponse;
import entities.MitfahrenUserService;

public class RegistrationConverter {

	private MitfahrenUserService userService;
	
	public RegistrationConverter(MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	public RegisterUserResponse convert(RegisterUserModel userModel) {
		boolean phoneIsValid = userService.findPhoneNumber(userModel.phone) == null;
		
		if(userService.find(userModel.username) == null 
				&& userService.findMail(userModel.mail) == null 
				&& phoneIsValid) {
			
		}
		
		return null;
	}
}
