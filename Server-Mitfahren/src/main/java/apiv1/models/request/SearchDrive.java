package apiv1.models.request;

import apiv1.models.DataBody;

/**
 * Model for the search input to search a drive.
 * @author Leon Johann Brettin
 *
 */
public class SearchDrive extends DataBody{

	public String destination;
	public String arrival;
	public String date;
	
	public SearchDrive(){}
	
	public SearchDrive(String destination, String arrival, String date) {
		this.destination = destination;
		this.arrival = arrival;
		this.date = date;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
