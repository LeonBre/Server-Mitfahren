package apiv1.converters;

import apiv1.models.request.AuthenticateUserModel;
import apiv1.models.response.AuthenticateUserResponse;
import apiv1.validator.AuthenticationValidator;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;

public class AuthenticationConverter {

	MitfahrenUserService userService;
	
	public AuthenticationConverter(MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	public AuthenticateUserResponse convertModelToResponse(AuthenticateUserModel userModel) {
		MitfahrenUser user = userService.find(userModel.username);
		AuthenticateUserResponse response = new AuthenticateUserResponse();
		
		response.isAuthenticated = AuthenticationValidator.authenticateUser(user, userModel);
		response.userId = user.getUserId();
		
		return response;
	}
}
