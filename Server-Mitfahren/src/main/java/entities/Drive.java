package entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
 * a calendar, when the drive starts,
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
	@Column(name = "calendar")
	private Calendar calendar;
	//@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
	private MitfahrenUser driver;
	
	@ManyToMany(
	        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
	        mappedBy = "asPassengerDrives",
	        targetEntity = MitfahrenUser.class
	    )
	private List<MitfahrenUser> passengers;
	
	/* This works !!!!!!
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
	private City testCity;
	*/
	
	
	/**
	 * Need this for the Persistence API.
	 */
	public Drive(){}

	public Drive(String destination, String arrival, Calendar calendar, MitfahrenUser driver) {
		this.destination = destination;
		this.arrival = arrival;
		this.calendar = calendar;
		this.driver = driver;
	}
	
	
	/**
	 * @return the driveId
	 */
	public int getDriveId() {
		return driveId;
	}

	/**
	 * @param driveId the driveId to set
	 */
	public void setDriveId(int driveId) {
		this.driveId = driveId;
	}

	/**
	 * @param calendar the calendar to set
	 */
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destinationId the destination to set
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
	 * @return the calendar
	 */
	public Calendar getCalendar() {
		return calendar;
	}

	/**
	 * @param calendar the calendar to set
	 */
	public void setcalendar(Calendar calendar) {
		this.calendar = calendar;
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
