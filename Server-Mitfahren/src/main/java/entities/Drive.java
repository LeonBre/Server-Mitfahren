package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/*TODO:
 * add a max passenger int
 * make the driver not nullable
 * implement the passengers
 */


/**
 * Object wich represents a drive.
 * It has a destination city, an arrival city,
 * a date, when the drive starts,
 * a user, who is the driver of the drive and
 * a List of passengers.
 * @author Leon Johann Brettin
 *
 */
@Entity
public class Drive {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driveId;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
	private City destinationId;
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
	private City arrivalId;
	@NotNull
	@Column(name = "DATE")
	private Date date;
	//@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
	private User driver;
	
	/* This works !!!!!!
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
	private City testCity;
	*/
	
	//private List<User> passengers;
	
	/**
	 * Need this for the Persistence API.
	 */
	public Drive(){}

	
}
