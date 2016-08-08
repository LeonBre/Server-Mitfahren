package apiv1.models;

import java.util.List;

public class DriveDetail {

	private String username;
	private String destination;
	private String arrival;
	private String date;
	private String time;
	
	private int userRating; //implement this
	private int seats;		//implement this
	private List<Passenger> passengers;
	private List<Comment> userComments; //implement this
}

class Passenger{
	public String username;
	public int userId;
}

class Comment{
	public String comment;
	public int commentRating;
	public String username;
}