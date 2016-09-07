package entities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class MitfahrenUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotNull
	@Column(unique=true)
	private String username;
	@NotNull
	private String hashPassword;
	private int activationNumber;
	private String telephoneNumber;
	private boolean isActivated;
	private String pictureUrl;
	
	private String userMail;
	
	private float userRating;
	
	@OneToMany(cascade=CascadeType.ALL,
				fetch=FetchType.EAGER)
	@JoinColumn(name="AUTHORID")
	private Set<UserComment> userComments;

	
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
	
	@OneToMany(cascade=CascadeType.ALL,
				fetch=FetchType.EAGER)
	@JoinColumn
	private Set<Drive> asDriverList;
	
	public MitfahrenUser(){}

	public MitfahrenUser(String username, String hashPassword, String telephoneNumber, String userMail, int activationNumber) {
		this.username = username;
		this.hashPassword = hashPassword;
		this.telephoneNumber = telephoneNumber;
		this.userRating = 0;
		this.userMail = userMail;
		this.activationNumber = activationNumber;
		this.userComments = new HashSet<>();
		this.asPassengerList = new LinkedList<>();
		this.asDriverList = new HashSet<>();
		this.isActivated = false;
	}
	
	public MitfahrenUser(String username, String hashPassword, String telephoneNumber, String pictureUrl, String userMail, int activationNumber) {
		this.username = username;
		this.hashPassword = hashPassword;
		this.telephoneNumber = telephoneNumber;
		this.pictureUrl = pictureUrl;
		this.userRating = 0;
		this.userMail = userMail;
		this.activationNumber = activationNumber;
		this.userComments = new HashSet<>();
		this.asPassengerList = new LinkedList<>();
		this.asDriverList = new HashSet<>();
		this.isActivated = false;
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
		Iterator<UserComment> userCommentIterator = userComments.iterator();
		while (userCommentIterator.hasNext()){
			newRating += userCommentIterator.next().getCommentRating();
		}
		userRating = (float)newRating/(float)userComments.size();
	}
	
	public void addDrive(Drive drive) {
		asDriverList.add(drive);
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	public void activateUser() {
		this.isActivated = true;
	}
	
	public boolean isActivated(){
		return this.isActivated;
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
	
	public Set<UserComment> getUserComments() {
		return userComments;
	}

	/**
	 * @return the asDriverList
	 */
	public Set<Drive> getAsDriverList() {
		return asDriverList;
	}

	/**
	 * @param asDriverList the asDriverList to set
	 */
	public void setAsDriverList(Set<Drive> asDriverList) {
		this.asDriverList = asDriverList;
	}

	/**
	 * @return the hashPassword
	 */
	public String getHashPassword() {
		return hashPassword;
	}

	/**
	 * @param hashPassword the hashPassword to set
	 */
	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	/**
	 * @return the userMail
	 */
	public String getUserMail() {
		return userMail;
	}

	/**
	 * @param userMail the userMail to set
	 */
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	/**
	 * @return the activationNumber
	 */
	public int getActivationNumber() {
		return activationNumber;
	}

	/**
	 * @param activationNumber the activationNumber to set
	 */
	public void setActivationNumber(int activationNumber) {
		this.activationNumber = activationNumber;
	}
	
	
}

