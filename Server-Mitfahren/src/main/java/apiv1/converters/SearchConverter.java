package apiv1.converters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import apiv1.models.AnswerDrive;
import apiv1.models.SearchDrive;
import entities.Drive;
import entities.DriveService;

public class SearchConverter {

	DriveService driveService;
	
	public SearchConverter(DriveService driveService) {
		this.driveService = driveService;
	}
	
	public List<AnswerDrive> getSearchedDrives(SearchDrive searchedDrive){
		String searchDestination = searchedDrive.getDestination();
		String searchArrival = searchedDrive.getArrival();
		
		List<Drive> databaseResults = driveService
				.findByDestinationArrival(searchDestination, searchArrival);
		
		ArrayList<Drive> matchingTimeResults = new ArrayList<>();
		for(Drive drive:databaseResults) {
			Calendar timeCalender = drive.getCalendar();
//			if(compareCalenderDates(timeCalendar, cal2)){
//				
//			}
		}
		
		System.out.println("Date :" + searchedDrive.getDate());
		return null;
	}
	
	private boolean compareCalenderDates(Calendar cal1, Calendar cal2) {
		return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
	}
}
