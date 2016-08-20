package helper;

import apiv1.models.request.AuthenticationHeader;

public class AuthenticationHelper {
	
	public static boolean checkLogin(AuthenticationHeader header) {
		if (header == null) {
			return false;
		}
		return true;
	}
}
