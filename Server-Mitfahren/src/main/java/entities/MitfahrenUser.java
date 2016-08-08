package entities;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column
    @ElementCollection(targetClass=Integer.class, fetch=FetchType.EAGER)
	private Collection<Integer> asDriverList;
	
	@Column
    @ElementCollection(targetClass=Integer.class, fetch=FetchType.EAGER)
	private Collection<Integer> asPassengerList;
	
	public MitfahrenUser(){}

	public MitfahrenUser(String username, String hashPassword, String telephoneNumber) {
		this.username = username;
		this.hashPassword = hashPassword;
		this.telephoneNumber = telephoneNumber;
		this.asDriverList = new LinkedList<>();
		this.asPassengerList = new LinkedList<>();
	}
	
	public MitfahrenUser(String username, String hashPassword, String telephoneNumber, String pictureUrl) {
		this.username = username;
		this.hashPassword = hashPassword;
		this.telephoneNumber = telephoneNumber;
		this.asDriverList = new LinkedList<>();
		this.asPassengerList = new LinkedList<>();
		this.pictureUrl = pictureUrl;
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

	public Collection<Integer> getAsPassengerList() {
		return asPassengerList;
	}

	public void setAsPassengerList(Collection<Integer> asPassengerList) {
		this.asPassengerList = asPassengerList;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	
}
