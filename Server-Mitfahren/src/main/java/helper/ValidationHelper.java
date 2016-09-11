package helper;

import entities.MitfahrenUser;
import entities.MitfahrenUserService;

public class ValidationHelper {

	public static boolean validateUser(MitfahrenUserService userService, String username, String password, String userId) {
		try {
			MitfahrenUser validationUser = userService.find(Integer.parseInt(userId));
			
			return validationUser.getUsername().equals(username) 
					&& validationUser.getHashPassword().equals(password);
						
		} catch(NumberFormatException ex) {
				return false;
			}
	}
}
