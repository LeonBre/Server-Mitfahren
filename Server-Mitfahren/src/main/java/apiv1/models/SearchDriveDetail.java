package apiv1.models;

public class SearchDriveDetail {

	private int driveId;
	
	public SearchDriveDetail(int driveId) {
		this.driveId = driveId;
	}
	
	public SearchDriveDetail(){}

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
	
	
}
