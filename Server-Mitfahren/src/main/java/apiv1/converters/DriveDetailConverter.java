package apiv1.converters;

import apiv1.models.response.DriveDetail;
import entities.Drive;
import entities.DriveService;
import entities.MitfahrenUser;
import entities.UserComment;
import helper.CalendarHelper;

/**
 * Class to convert the id of a drive into a DriveDetail Model.
 * @author Leon Johann Brettin
 *
 */
public class DriveDetailConverter {
	
	DriveService driveService;
	
	public DriveDetailConverter(DriveService driveService) {
		this.driveService = driveService;
	}
	
	/**
	 * Gets the matching drive out of the database and converts it in a DriveDetail model.
	 * @param driveId Id of the searched drive.
	 * @return Model for the Webpage.
	 */
	public DriveDetail convertDriveIdtoAnswerDrive(String driveId) {
		int driveIdInteger = Integer.parseInt(driveId);
		Drive currentDrive = driveService.find(driveIdInteger);
		
		if(currentDrive == null) {
			return null;
		}
		
		String username = currentDrive.getDriver().getUsername();
		String destination = currentDrive.getDestination().getName();
		String destinationPictureUrl = currentDrive.getDestination().getPictureUrl();
		String arrival = currentDrive.getArrival().getName();
		String arrivalPictureUrl = currentDrive.getArrival().getPictureUrl();
		String date = CalendarHelper.getCalendaDateAsString(currentDrive.getCalendar());
		String time = CalendarHelper.getCalendarTimeAsString(currentDrive.getCalendar());
		String userRating = currentDrive.getDriver().getUserRating() + "";
		String seats = currentDrive.getCarSeats() + "";
		
		DriveDetail driveModel = new DriveDetail(username, destination, destinationPictureUrl, 
				arrival, arrivalPictureUrl, date, time, userRating, seats);
		
		for(MitfahrenUser passenger: currentDrive.getPassengers()) {
			driveModel.addPassenger(passenger.getUsername(), passenger.getUserId(), passenger.getPictureUrl());
		}
		for(UserComment comment: currentDrive.getDriver().getUserComments()) {
			driveModel.addComment(comment.getComment(), comment.getCommentRating(), 
					comment.getCommenterUserName(), comment.getCommenterId() + "");
		}
		
		return driveModel;
	}
}
