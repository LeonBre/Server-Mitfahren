package apiv1.converters;

import apiv1.models.request.ActivationModel;
import apiv1.models.response.ActivationResponse;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;

/**
 * Converter Clas for the Activation of an registered user.
 * @author Leon Johann Brettin
 *
 */
public class ActivationConverter {

	private MitfahrenUserService userService;
	
	/**
	 * Basic Constructor for the Activation Class.
	 * @param userService Service to get a Mitfahrenuser out of the database.
	 */
	public ActivationConverter(MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	/**
	 * Converts an ActivationModel request to an ActivationResponse.
	 * The activationnumber will be checked with the actual activation nuber of the user.
	 * It will be checked if the user is already activated.
	 * The password of the user will be checked.
	 * @param request Activationmodel, the request model of the rest api.
	 * @return ActivationResponse for the rest api.
	 */
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
