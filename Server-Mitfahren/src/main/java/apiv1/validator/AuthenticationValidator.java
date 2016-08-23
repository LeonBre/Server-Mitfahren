package apiv1.validator;

import apiv1.models.request.AuthenticateUserModel;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;

public class AuthenticationValidator {

	public MitfahrenUserService userService;
	
	
	public AuthenticationValidator (MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	public boolean authenticateUser(AuthenticateUserModel userModel) {
		MitfahrenUser user = userService.find("Max Mustermann");
		if(user == null)
			return false;
		if(user.getUsername().equals(userModel.username) 
				&& user.getHashPassword().equals(userModel.password))
			return true;
		
		return false;
	}
}
