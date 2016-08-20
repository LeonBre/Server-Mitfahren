package apiv1.models.request;

import apiv1.models.DataBody;

public class SearchDriveDetail extends DataBody{

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
