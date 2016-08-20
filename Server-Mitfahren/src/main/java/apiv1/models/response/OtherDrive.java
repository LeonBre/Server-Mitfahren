package apiv1.models.response;

public class OtherDrive {
	public String driveId;
	public String destination;
	public String arrival;
	public String date;
	public String time;
	
	public OtherDrive(String driveId, String destination, String arrival, String date, String time) {
		this.driveId = driveId;
		this.destination = destination;
		this.arrival = arrival;
		this.date = date;
		this.time = time;
	}
	
	
}