package apiv1.models.response;

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
	public String commentary;
	
	public String userRating; 
	public String seats;
	public List<Passenger> passengers;
	public List<Comment> userComments;
	

	/**
	 * Basic Constructor.
	 * @param username Username of the driver.
	 * @param destination Destination of the drive.
	 * @param destinationPictureUrl PictureUrl of the Destination.
	 * @param arrival Arrival of the Drive.
	 * @param arrivalPictureUrl PictureUrl of the Arrival.
	 * @param date Date when the drive begins.
	 * @param time Time when the drive begins.
	 * @param userRating Rating of the Driver
	 * @param seats Number of free seats.
	 */
	public DriveDetail(String username, String destination, String destinationPictureUrl, String arrival,
			String arrivalPictureUrl, String date, String time, String userRating, String seats, String commentary) {
		this.username = username;
		this.destination = destination;
		this.destinationPictureUrl = destinationPictureUrl;
		this.arrival = arrival;
		this.arrivalPictureUrl = arrivalPictureUrl;
		this.date = date;
		this.time = time;
		this.userRating = userRating;
		this.seats = seats;
		this.commentary = commentary;
		
		this.passengers = new LinkedList<>();
		this.userComments = new LinkedList<>();
	}

	/**
	 * Adds a new Passenger to the PassengerList.
	 * @param username Username of the passenger.
	 * @param userId UserId of the passenger.
	 * @param userPictureUrl PictureUrl of the passenger.
	 */
	public void addPassenger(String username, int userId, String userPictureUrl) {
		passengers.add(new Passenger(username, userId, userPictureUrl));
	}
	
	/**
	 * Adds a new Comment to the Commentlist
	 * @param comment Text of the Comment
	 * @param commentRating Rating which was given for the drive.
	 * @param username Username of the commenter.
	 * @param userId Id of the commenter.
	 */
	public void addComment(String comment, float commentRating, String username, String userId) {
		userComments.add(new Comment(comment, commentRating, username, userId));
	}
}

/**
 * Helper class for the DriveDetail Class
 * @author Leon Johann Brettin
 *
 */
class Passenger{
	public String username;
	public int userId;
	public String userPictureUrl;
	
	/**
	 * Basic Constructor.
	 * @param username Username of the Passenger.
	 * @param userId UserId of the Passenger.
	 * @param userPictureUrl PictureUrl of the Passenger.
	 */
	public Passenger(String username, int userId, String userPictureUrl) {
		super();
		this.username = username;
		this.userId = userId;
		this.userPictureUrl = userPictureUrl;
	}
	
	
}
