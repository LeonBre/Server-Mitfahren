package apiv1.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Drive {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driveId;
	
	@NotNull
	private City destination;
	@NotNull
	private City arrival;
	@NotNull
	private Date date;
	@NotNull
	private User driver;
	
	private List<User> passengers;
	
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
	public List<User> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<User> passengers) {
		this.passengers = passengers;
	}

	
}
