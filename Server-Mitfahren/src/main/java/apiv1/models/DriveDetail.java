package apiv1.models;

import java.util.List;

/**
 * Model for the drive.html page.
 * The data of this type will be shown on the drive.html page.
 * @author Leon Johann Brettin
 *
 */
public class DriveDetail {

	private String username;
	private String destination;
	private String arrival;
	private String date;
	private String time;
	
	private int userRating; 
	private int seats;		//implement this
	private List<Passenger> passengers;
	private List<Comment> userComments; 
}

class Passenger{
	public String username;
	public int userId;
}

class Comment{
	public String comment;
	public float commentRating;
	public String username;
}