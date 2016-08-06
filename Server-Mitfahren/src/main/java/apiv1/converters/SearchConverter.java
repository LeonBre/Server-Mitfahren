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
			Calendar timeCalender = drive.getCalendar();
//			if(compareCalenderDates(timeCalendar, cal2)){
//				
//			}
		}
		Calendar testcalendar = Calendar.getInstance();
		testcalendar.set(2016, 8, 6);
		System.out.println(CalendarHelper.compareCalenderDates(testcalendar, searchTime));
		System.out.println("TestCalendar :" + testcalendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("SearchTime :" + searchTime.get(Calendar.DAY_OF_YEAR));
		System.out.println("Date :" + searchedDrive.getDate());
		return null;
	}
	
	
}
