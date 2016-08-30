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
		return null;
	}
}
