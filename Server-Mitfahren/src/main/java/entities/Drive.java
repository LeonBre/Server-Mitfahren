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
	@ManyToOne
	@JoinColumn(name = "cityId", insertable = false, updatable = false)
	private City destination;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cityId", insertable = false, updatable = false)
	private City arrival;
	@NotNull
	@Column(name = "DATE")
	private Date date;
	//@NotNull
	@ManyToOne
	@JoinColumn(name = "driverId", insertable = false, updatable = false)
	private User driver;
	
	//private List<User> passengers;
	
	public Drive (City destination, City arrival, Date date, User driver){
		this.destination = destination;
		this.arrival = arrival;
		this.date = date;
		this.driver = driver;
	}
	
	/**
	 * Need this for the Persistence API.
	 */
	public Drive(){}
	
	public City getDestination() {
		return destination;
	}
	public void setDestination(City destination) {
		this.destination = destination;
	}
	public City getArrival() {
		return arrival;
	}
	public void setArrival(City arrival) {
		this.arrival = arrival;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getDriver() {
		return driver;
	}
	public void setDriver(User driver) {
		this.driver = driver;
	}
//	public List<User> getPassengers() {
//		return passengers;
//	}
//	public void setPassengers(List<User> passengers) {
//		this.passengers = passengers;
//	}

	
}
