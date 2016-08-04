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
/**
 * I removed the JPA Validation under Window -> Preferences -> Validation -> JPA Validation
 * I removed one Validation Error under Properties -> Error/Warnings -> Type
 */


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
	private String destination;
	@NotNull
	private String arrival;
	@NotNull
	@Column(name = "DATE")
	private Date date;
	//@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
	private MitfahrenUser driver;
	
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

	public Drive(String destination, String arrival, Date date, MitfahrenUser driver) {
		this.destination = destination;
		this.arrival = arrival;
		this.date = date;
		this.driver = driver;
	}

	/**
	 * @return the destinationId
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destinationId the destinationId to set
	 */
	public void setDestination(String destinationId) {
		this.destination = destinationId;
	}

	/**
	 * @return the arrivalId
	 */
	public String getArrival() {
		return arrival;
	}

	/**
	 * @param arrivalId the arrivalId to set
	 */
	public void setArrival(String arrivalId) {
		this.arrival = arrivalId;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the driver
	 */
	public MitfahrenUser getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(MitfahrenUser driver) {
		this.driver = driver;
	}

	
}
