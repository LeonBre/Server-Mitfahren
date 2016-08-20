package apiv1.models.response;

public class AnswerDrive {

	private String username;
	private String userPictureUrl;
	
	private int driveId;
	private String destination;
	private String arrival;
	private String date;
	private String time;
	
	public AnswerDrive(String username, String userPictureUrl, int driveId, String destination, String arrival,
			String date, String time) {
		this.username = username;
		this.userPictureUrl = userPictureUrl;
		this.driveId = driveId;
		this.destination = destination;
		this.arrival = arrival;
		this.date = date;
		this.time = time;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the userPictureUrl
	 */
	public String getUserPictureUrl() {
		return userPictureUrl;
	}

	/**
	 * @param userPictureUrl the userPictureUrl to set
	 */
	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
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
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival;
	}

	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
