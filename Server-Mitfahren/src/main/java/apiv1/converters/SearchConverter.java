package apiv1.converters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import apiv1.models.AnswerDrive;
import apiv1.models.SearchDrive;
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
			String driverPictureUrl = drive.getDriver().getPictureUrl();
			int driveId = drive.getDriveId();
			
			Calendar driveCalender = drive.getCalendar();
			String date = driveCalender.get(Calendar.DAY_OF_MONTH) + ", " 
							+ CalendarHelper.getMonthAsString(driveCalender.get(Calendar.MONTH))
							+ " " + driveCalender.get(Calendar.YEAR);
			
			String time = driveCalender.get(Calendar.HOUR_OF_DAY) + ":" 
							+ driveCalender.get(Calendar.MINUTE); 
			
			AnswerDrive matchingDrive = new AnswerDrive(driverName,
					driverPictureUrl, 
					driveId, 
					searchDestination,
					searchArrival,
					date,
					time);
			
			answerDrives.add(matchingDrive);
		}
		System.out.println("AnswerDrives" + answerDrives.size());
		return answerDrives;
	}
}
