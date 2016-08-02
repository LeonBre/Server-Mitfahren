package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserId;
	
	@NotNull
	private String username;
	@NotNull
	private String hashPassword;
	private String telephoneNumber;
	
	public User(){
		
	}
}
