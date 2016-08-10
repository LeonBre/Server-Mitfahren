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
	private String destinationPictureUrl;
	private String arrival;
	private String arrivalPictureUrl;
	private String date;
	private String time;
	
	private String userRating; 
	private String seats;
	private List<Passenger> passengers;
	private List<Comment> userComments;
	

	
	public DriveDetail(String username, String destination, String destinationPictureUrl, String arrival,
			String arrivalPictureUrl, String date, String time, String userRating, String seats) {
		this.username = username;
		this.destination = destination;
		this.destinationPictureUrl = destinationPictureUrl;
		this.arrival = arrival;
		this.arrivalPictureUrl = arrivalPictureUrl;
		this.date = date;
		this.time = time;
		this.userRating = userRating;
		this.seats = seats;
	}

	public void addPassenger(String username, int userId, String userPictureUrl) {
		passengers.add(new Passenger(username, userId, userPictureUrl));
	}
	
	public void addComment(String comment, float commentRating, String username, int userId) {
		userComments.add(new Comment(comment, commentRating, username, userId));
	}
}

class Passenger{
	private String username;
	private int userId;
	private String userPictureUrl;
	
	public Passenger(String username, int userId, String userPictureUrl) {
		super();
		this.username = username;
		this.userId = userId;
		this.userPictureUrl = userPictureUrl;
	}
	
	
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