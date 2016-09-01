package apiv1.converters;

import apiv1.models.request.RegisterUserModel;
import apiv1.models.response.RegisterUserResponse;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;

public class RegistrationConverter {

	private MitfahrenUserService userService;
	
	public RegistrationConverter(MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	public RegisterUserResponse convert(RegisterUserModel userModel) {
		RegisterUserResponse response = new RegisterUserResponse();
		
		boolean usernameIsValid = userService.find(userModel.username) == null;
		boolean mailIsValid = userService.findMail(userModel.mail) == null 
				&& userModel.mail.contains("@") 
				&& userModel.mail.contains(".");
		boolean phoneIsValid = userModel.phone != "110" 
				&& userModel.phone != "112" 
				&& userService.findPhoneNumber(userModel.phone) == null;
		
		System.out.println("username is valid: " + usernameIsValid);
		System.out.println("mail is valid: " + mailIsValid);
		System.out.println("phone is valid: " + phoneIsValid);
		
		boolean registrationIsPossible = usernameIsValid && phoneIsValid && mailIsValid;
		
		if(registrationIsPossible) 
		{
			MitfahrenUser newUser = new MitfahrenUser(userModel.username, 
					userModel.password, userModel.phone, userModel.mail);
			userService.persists(newUser);
			
			response.isRegistered = true;
			response.userId = newUser.getUserId();
		} else 
		{
			response.isRegistered = false;
			response.userId = 0;
		}
		
		return response;
	}
}
