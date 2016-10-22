package helper;

import entities.MitfahrenUser;
import entities.MitfahrenUserService;

/**
 * Helper class to validate a succesfull login of an user.
 * 
 * @author Leon Johann Brettin
 *
 */
public class ValidationHelper {

	/**
	 * Validates an user against an already saved user of the Database.
	 * 
	 * @param userService Userservice to get an user out of the database.
	 * @param username Input username of the client.
	 * @param password Input hashed password of the client.
	 * @param userId Input userId of the client.
	 * @return True, when the user is successfully validated.
	 */
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
