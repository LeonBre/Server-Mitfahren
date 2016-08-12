package apiv1.models;

import java.util.LinkedList;
import java.util.List;

/**
 * Model for the drive.html page.
 * The data of this type will be shown on the drive.html page.
 * @author Leon Johann Brettin
 *
 */
public class DriveDetail {

	public String username;
	public String destination;
	public String destinationPictureUrl;
	public String arrival;
	public String arrivalPictureUrl;
	public String date;
	public String time;
	
	public String userRating; 
	public String seats;
	public List<Passenger> passengers;
	public List<Comment> userComments;
	

	
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
		
		this.passengers = new LinkedList<>();
		this.userComments = new LinkedList<>();
	}

	public void addPassenger(String username, int userId, String userPictureUrl) {
		passengers.add(new Passenger(username, userId, userPictureUrl));
	}
	
	public void addComment(String comment, float commentRating, String username, int userId) {
		userComments.add(new Comment(comment, commentRating, username, userId));
	}
}

class Passenger{
	public String username;
	public int userId;
	public String userPictureUrl;
	
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