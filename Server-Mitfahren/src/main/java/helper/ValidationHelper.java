package helper;

import entities.MitfahrenUser;
import entities.MitfahrenUserService;

public class ValidationHelper {

	public static boolean validateUser(MitfahrenUserService userService, String username, String password, String userId) {
		try {
			MitfahrenUser validationUser = userService.find(Integer.parseInt(userId));
			System.out.println("Username: " + validationUser.getUsername().equals(username));
			System.out.println(validationUser.getUsername());
			System.out.println(username);
			return validationUser.getUsername().equals(username) 
					&& validationUser.getHashPassword().equals(password);
						
		} catch(NumberFormatException ex) {
				return false;
			}
	}
}
