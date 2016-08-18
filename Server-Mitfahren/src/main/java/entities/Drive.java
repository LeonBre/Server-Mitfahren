package entities;

import java.util.Calendar;
import java.util.LinkedList;
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
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private City destination;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private City arrival;
	@NotNull
	@Column(name = "calendar")
	private Calendar calendar;
	//@NotNull
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
	private MitfahrenUser driver;
	
	@ManyToMany(
	        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
	        mappedBy = "asPassengerList",
	        targetEntity = MitfahrenUser.class,
	        fetch =FetchType.EAGER
	    )
	private List<MitfahrenUser> passengers;
	
	private int carSeats;
	
	
	/**
	 * Need this for the Persistence API.
	 */
	public Drive(){}

	public Drive(City destination, City arrival, Calendar calendar, MitfahrenUser driver, int carSpace) {
		this.destination = destination;
		this.arrival = arrival;
		this.calendar = calendar;
		this.driver = driver;
		this.passengers = new LinkedList<>();
		this.carSeats = carSpace;
		
		driver.addDrive(this);
	}
	
	/**
	 * Adds a new Passenger to the drive if the car has enough space.
	 * @param newPassenger User who wants to join the drive.
	 * @return true if the passenger is added succesfully
	 * false when the car is full 
	 */
	public boolean addPassenger(MitfahrenUser newPassenger) {
		if(passengers.size() + 1 > carSeats) {
			return false;
		} else {
			passengers.add(newPassenger);
			return true;
		}
	}
	
	public List<MitfahrenUser> getPassengers() {
		return passengers;
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
	public City getDestination() {
		return destination;
	}

	/**
	 * @param destinationId the destination to set
	 */
	public void setDestination(City destinationId) {
		this.destination = destinationId;
	}

	/**
	 * @return the arrivalId
	 */
	public City getArrival() {
		return arrival;
	}

	/**
	 * @param arrivalId the arrivalId to set
	 */
	public void setArrival(City arrivalId) {
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

	/**
	 * @return the carSpace
	 */
	public int getCarSeats() {
		return carSeats;
	}

	/**
	 * @param carSpace the carSpace to set
	 */
	public void setCarSpace(int carSpace) {
		this.carSeats = carSpace;
	}

	
}
