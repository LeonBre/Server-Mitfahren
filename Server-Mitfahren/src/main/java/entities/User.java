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
public class User {
	
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
	
	public User(){
		
	}
}
