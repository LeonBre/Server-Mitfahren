package apiv1.validator;

import apiv1.models.request.AuthenticateUserModel;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;

/**
 * Validation helper class for the Authentication process.
 * @author Leon Johann Brettin
 *
 */
public class AuthenticationValidator {

	/**
	 * Checks if the given input is right, so that the user can log in successfully.
	 * It checks a Mitfahren user of the database against an AuthencticationUserModel request.
	 * The validator checks:
	 * - if the username is the same as in the usermodel.
	 * - if the hashed password is the same as in the usermodel.
	 * - if the user is already activated.
	 * @param user Mitfahrenuser of the database.
	 * @param userModel Usermodel of the request.
	 * @return True, when the authentication is succesfull, false if not.
	 */
	public static boolean authenticateUser(MitfahrenUser user, AuthenticateUserModel userModel) {
		if(user == null)
			return false;
		if(user.getUsername().equals(userModel.username) 
				&& user.getHashPassword().equals(userModel.password)
				&& user.isActivated())
			return true;
		
		return false;
	}
}
