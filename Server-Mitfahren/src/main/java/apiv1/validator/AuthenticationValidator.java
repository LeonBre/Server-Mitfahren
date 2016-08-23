package apiv1.validator;

import apiv1.models.request.AuthenticateUserModel;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;

public class AuthenticationValidator {

	public static boolean authenticateUser(MitfahrenUser user, AuthenticateUserModel userModel) {
		if(user == null)
			return false;
		if(user.getUsername().equals(userModel.username) 
				&& user.getHashPassword().equals(userModel.password))
			return true;
		
		return false;
	}
}
