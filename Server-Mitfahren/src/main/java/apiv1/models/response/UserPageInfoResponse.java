package apiv1.models.response;

import java.util.List;

import apiv1.models.response.helpermodel.UserPageInfoDrive;

public class UserPageInfoResponse {

	public boolean success;
	
	public String username;
	public String rating;
	public String phoneNumber;
	public String mail;
	public List <UserPageInfoDrive> drives;
}

