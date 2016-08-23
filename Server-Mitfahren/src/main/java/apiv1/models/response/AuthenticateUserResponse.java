package apiv1.models.response;

public class AuthenticateUserResponse {

	public boolean isAuthenticated;
	
	public AuthenticateUserResponse(){}
	
	public AuthenticateUserResponse(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
}
