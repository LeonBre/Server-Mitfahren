package apiv1.converters;

import apiv1.models.request.ActivationModel;
import apiv1.models.response.ActivationResponse;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;

public class ActivationConverter {

	private MitfahrenUserService userService;
	
	public ActivationConverter(MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	public ActivationResponse convert(ActivationModel request){
		MitfahrenUser user = userService.find(request.username);
		try {
			if(user != null
					&& user.getActivationNumber() == Integer.parseInt(request.number)
					&& user.isActivated() == false
					&& user.getHashPassword().equals(request.password)) 
			{
				//Succes
				user.activateUser();
				ActivationResponse succesfullActivation = new ActivationResponse();
				succesfullActivation.isActivated = true;
				userService.refresh(user);
				succesfullActivation.userId = user.getUserId();
				return succesfullActivation;
			}
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		//Something was wrong
		ActivationResponse error = new ActivationResponse();
		error.isActivated = false;
		error.userId = 0;
		return error;
	}
}
