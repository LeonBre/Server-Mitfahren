package entities;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private List<Drive> asPassengerDrives;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn
	private List<Drive> driverList;
	
	 
	@Column
    @ElementCollection(targetClass=Integer.class, fetch=FetchType.EAGER)
	private Collection<Integer> asDriverList;
	
	public MitfahrenUser(){}

	public MitfahrenUser(String username, String hashPassword, String telephoneNumber) {
		this.username = username;
		this.hashPassword = hashPassword;
		this.telephoneNumber = telephoneNumber;
		this.asDriverList = new LinkedList<>();
		this.userComments = new LinkedList<>();
	}
	
	public MitfahrenUser(String username, String hashPassword, String telephoneNumber, String pictureUrl) {
		this.username = username;
		this.hashPassword = hashPassword;
		this.telephoneNumber = telephoneNumber;
		this.asDriverList = new LinkedList<>();
		this.pictureUrl = pictureUrl;
		this.userComments = new LinkedList<>();
	}

	/**
	 * Adds a comment to this user.
	 * The rating of the user is updated.
	 * @param comment Comment on the user.
	 * @param rating Rating of the Ride/on the User.
	 * @param userId UserId of the author of the comments.
	 */
	public void addComment(String comment, float rating, int userId) {
		UserComment newComment = new UserComment(comment, rating, userId);
		userComments.add(newComment);
		//refresh User Rating
		float newRating = 0;
		for(int i = 0; i < userComments.size(); i++) {
			newRating += userComments.get(i).getCommentRating();
		}
		userRating = (float)newRating/(float)userComments.size();
	}
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Collection<Integer> getAsDriverList() {
		return asDriverList;
	}

	public void setAsDriverList(Collection<Integer> asDriverList) {
		this.asDriverList = asDriverList;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	
}

