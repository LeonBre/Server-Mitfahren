package apiv1.converters;

import apiv1.models.MitfahrenUserDetail;
import entities.MitfahrenUserService;

public class MitfahrenUserDetailConverter {

	MitfahrenUserService userService;
	
	public MitfahrenUserDetailConverter (MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	public MitfahrenUserDetail convertIdToModel(String userId) {
		return null;
	}
}
