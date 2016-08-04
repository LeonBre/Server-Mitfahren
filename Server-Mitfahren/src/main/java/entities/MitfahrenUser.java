package entities;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@Column
    @ElementCollection(targetClass=Integer.class)
	private Collection<Integer> asDriverList;
	
	@Column
    @ElementCollection(targetClass=Integer.class)
	private Collection<Integer> asPassengerList;
	
	public MitfahrenUser(){}

	public MitfahrenUser(String username, String hashPassword, String telephoneNumber) {
		this.username = username;
		this.hashPassword = hashPassword;
		this.telephoneNumber = telephoneNumber;
		this.asDriverList = new LinkedList<>();
		this.asPassengerList = new LinkedList<>();
	}
	
	
}
