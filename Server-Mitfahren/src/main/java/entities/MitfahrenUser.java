package entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class MitfahrenUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotNull
	private String username;
	@NotNull
	private String hashPassword;
	private String telephoneNumber;
	
	private String pictureUrl;
	
	private float userRating;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="AUTHORID")
	private List<UserComment> userComments;

	
	 @ManyToMany(
		        targetEntity=Drive.class,
		        cascade={CascadeType.PERSIST, CascadeType.MERGE}
		    )
		    @JoinTable(
		        name="MITFAHRENUSER_DRIVE",
		        joinColumns=@JoinColumn(name="DRIVEID"),
		        inverseJoinColumns=@JoinColumn(name="USERID")
		    )
	private List<Drive> asPassengerList;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn
	private List<Drive> asDriverList;
	
	public MitfahrenUser(){}

	public MitfahrenUser(String username, String hashPassword, String telephoneNumber) {
		this.username = username;
		this.hashPassword = hashPassword;
		this.telephoneNumber = telephoneNumber;
		this.userRating = 0;
		this.userComments = new LinkedList<>();
		this.asPassengerList = new LinkedList<>();
		this.asDriverList = new LinkedList<>();
	}
	
	public MitfahrenUser(String username, String hashPassword, String telephoneNumber, String pictureUrl) {
		this.username = username;
		this.hashPassword = hashPassword;
		this.telephoneNumber = telephoneNumber;
		this.pictureUrl = pictureUrl;
		this.userRating = 0;
		this.userComments = new LinkedList<>();
		this.asPassengerList = new LinkedList<>();
		this.asDriverList = new LinkedList<>();
	}

	/**
	 * Adds a comment to this user.
	 * The rating of the user is updated.
	 * @param comment Comment on the user.
	 * @param rating Rating of the Ride/on the User.
	 * @param userId UserId of the author of the comments.
	 */
	public void addComment(String comment,String userName, float rating, int userId) {
		UserComment newComment = new UserComment(comment, userName, rating, userId);
		userComments.add(newComment);
		//refresh User Rating
		float newRating = 0;
		for(int i = 0; i < userComments.size(); i++) {
			newRating += userComments.get(i).getCommentRating();
		}
		userRating = (float)newRating/(float)userComments.size();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * @return the pictureUrl
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}

	/**
	 * @param pictureUrl the pictureUrl to set
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public float getUserRating() {
		return userRating;
	}
	
	public List<UserComment> getUserComments() {
		return userComments;
	}
}

