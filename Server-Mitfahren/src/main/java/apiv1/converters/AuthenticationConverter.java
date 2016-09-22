package apiv1.converters;

import apiv1.models.request.AuthenticateUserModel;
import apiv1.models.response.AuthenticateUserResponse;
import apiv1.validator.AuthenticationValidator;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;

/**
 * Converter Class for the Authentication of an user.
 * @author Leon Johann Brettin
 *
 */
public class AuthenticationConverter {

	MitfahrenUserService userService;
	
	/**
	 * Basic Constructor for the Authentication Converter.
	 * @param userService UserService, to get database access to the users.
	 */
	public AuthenticationConverter(MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	/**
	 * Convertrs a Authentication User Model request to an AuthenticationUserResponse.
	 * The authentication data will be checked against the saved data in the database.
	 * If the user is validated right, and the password and the username are correct the model will respond with a
	 * positive AuthenticationUserRespone,
	 * else it will respond with a negative respond.
	 * @param userModel Usermodel of the Authentication Request.
	 * @return AuthenticationUserRespond of the Authentication of the user.
	 */
	public AuthenticateUserResponse convertModelToResponse(AuthenticateUserModel userModel) {
		MitfahrenUser user = userService.find(userModel.username);
		AuthenticateUserResponse response = new AuthenticateUserResponse();
		
		response.isAuthenticated = AuthenticationValidator.authenticateUser(user, userModel);
		if (response.isAuthenticated) {
			response.userId = user.getUserId();
		} else {
			response.userId = 0;
		}
		
		return response;
	}
}
