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
	private int seats;
	private List<Passenger> passengers;
	private List<Comment> userComments;
	
	public DriveDetail(String username, String destination, String arrival, String date, String time, int userRating,
			int seats) {
		this.username = username;
		this.destination = destination;
		this.arrival = arrival;
		this.date = date;
		this.time = time;
		this.userRating = userRating;
		this.seats = seats;
	} 
	
	public void addPassenger(String username, int userId) {
		Passenger newPassenger = new Passenger();
		newPassenger.username = username;
		newPassenger.userId = userId;
		
		passengers.add(newPassenger);
	}
	
	public void addComment(String comment, float commentRating, String username, int userId) {
		userComments.add(new Comment(comment, commentRating, username, userId));
	}
}

class Passenger{
	public String username;
	public int userId;
}

class Comment{
	public String comment;
	public float commentRating;
	public String username;
	public int userId;
	
	public Comment(String comment, float commentRating, String username, int userId) {
		super();
		this.comment = comment;
		this.commentRating = commentRating;
		this.username = username;
		this.userId = userId;
	}
	
	
}