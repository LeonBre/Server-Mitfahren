package apiv1.models;

import java.util.List;

public class MitfahrenUserDetail {

	public String userId;
	public String userName;
	public String pictureUrl;
	
	public String userRating;
	public List<Comment> commentList;
	public List<OtherDrive> asDriverList;
	
}

class OtherDrive {
	String driveId;
	String destination;
	String arrival;
	String date;
}