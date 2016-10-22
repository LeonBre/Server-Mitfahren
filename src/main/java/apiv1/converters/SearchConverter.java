package apiv1.converters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import apiv1.models.request.SearchDrive;
import apiv1.models.response.AnswerDrive;
import entities.Drive;
import entities.DriveService;
import helper.CalendarHelper;

public class SearchConverter {

	DriveService driveService;
	
	public SearchConverter(DriveService driveService) {
		this.driveService = driveService;
	}
	
	/**
	 * Method to get from a searched Input, given through a Searchdrive, 
	 * a List of found Drives from the Database, with matches to the Search.
	 * @param searchedDrive Input Values for the Search.
	 * @return A List of matching Drives in the right Format.
	 */
	public List<AnswerDrive> getSearchedDrives(SearchDrive searchedDrive){
		String searchDestination = searchedDrive.getDestination();
		String searchArrival = searchedDrive.getArrival();
		Calendar searchTime = CalendarHelper.convertCalendar(searchedDrive.getDate());
		
		List<Drive> databaseResults = driveService
				.findByDestinationArrival(searchDestination, searchArrival);
		//Search for Matching Results
		ArrayList<Drive> matchingTimeResults = new ArrayList<>();
		for(Drive drive:databaseResults) {
			Calendar resultCalender = drive.getCalendar();
			if(CalendarHelper.compareCalenderDates(searchTime, resultCalender)){
				matchingTimeResults.add(drive);
			}
		}
		
		if(matchingTimeResults.isEmpty())
			return null;
		System.out.println("Matching Results:" + matchingTimeResults.size());
		//convert List
		ArrayList<AnswerDrive> answerDrives = new ArrayList<>();
		for(Drive drive:matchingTimeResults) {
			String driverName = drive.getDriver().getUsername();
			String driverPicture = drive.getDriver().getPictureBase64();
			int driveId = drive.getDriveId();
			
			String date = CalendarHelper.getCalendaDateAsString(drive.getCalendar());
			
			String time = CalendarHelper.getCalendarTimeAsString(drive.getCalendar());
			
			AnswerDrive matchingDrive = new AnswerDrive(driverName,
					driverPicture, 
					driveId, 
					searchDestination,
					searchArrival,
					date,
					time);
			
			answerDrives.add(matchingDrive);
		}
		return answerDrives;
	}
}
