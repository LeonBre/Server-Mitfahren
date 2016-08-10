package apiv1.converters;

import apiv1.models.DriveDetail;
import entities.Drive;
import entities.DriveService;

/**
 * Class to convert the id of a drive into a DriveDetail Model.
 * @author Leon Johann Brettin
 *
 */
public class DriveDetailConverter {
	
	DriveService driveService;
	
	public DriveDetailConverter (DriveService driveService) {
		this.driveService = driveService;
	}
	
	/**
	 * Gets the matching drive out of the database and converts it in a DriveDetail model.
	 * @param driveId Id of the searched drive.
	 * @return Model for the Webpage.
	 */
	public DriveDetail convertDriveIdtoAnswerDrive(int driveId) {
		Drive currentDrive = driveService.find(driveId);
		
		if(currentDrive == null) {
			return null;
		}
		
		String username = currentDrive.getDriver().getUsername();
		//String destination = currentDrive.getDestination();
		
		
		//DriveDetail driveModel = new DriveDetail(username, destination, arrival, date, time, userRating, seats)
		return null;
	}
}
