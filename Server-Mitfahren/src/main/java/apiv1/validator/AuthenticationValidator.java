package apiv1.validator;

import apiv1.models.request.AuthenticateUserModel;
import entities.MitfahrenUserService;

public class AuthenticationValidator {

	public MitfahrenUserService userService;
	
	
	public AuthenticationValidator (MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	public boolean authenticateUser(AuthenticateUserModel userModel) {
		
		return true;
	}
}
