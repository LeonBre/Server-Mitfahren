package apiv1.models.request;

public class SearchDriveDetail {

	public String driveId;
	
	public SearchDriveDetail(String driveId) {
		this.driveId = driveId;
	}
	
	public SearchDriveDetail(){}

	/**
	 * @return the driveId
	 */
	public String getDriveId() {
		return driveId;
	}

	/**
	 * @param driveId the driveId to set
	 */
	public void setDriveId(String driveId) {
		this.driveId = driveId;
	}
	
	
}
