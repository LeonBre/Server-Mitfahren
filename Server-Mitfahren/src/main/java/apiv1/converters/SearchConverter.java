package apiv1.converters;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

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
	
	public List<AnswerDrive> getSearchedDrives(SearchDrive searchedDrive){
		String searchDestination = searchedDrive.getDestination();
		String searchArrival = searchedDrive.getArrival();
		Calendar searchTime = CalendarHelper.convertCalendar(searchedDrive.getDate());
		
		List<Drive> databaseResults = driveService
				.findByDestinationArrival(searchDestination, searchArrival);
		
		ArrayList<Drive> matchingTimeResults = new ArrayList<>();
		for(Drive drive:databaseResults) {
			Calendar resultCalender = drive.getCalendar();
			if(CalendarHelper.compareCalenderDates(searchTime, resultCalender)){
				matchingTimeResults.add(drive);
			}
		}
		
		//Matching Time Results must be made to a list of answerDrives
		return null;
	}
}
