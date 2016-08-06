package helper;

import java.util.Calendar;

public class CalendarHelper {

	public static boolean compareCalenderDates(Calendar cal1, Calendar cal2) {
		return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
	}
	
	/**
	 * 
	 * @param calendarString is a String with the following form:
	 * 24 August, 2016
	 * @return Calendar Object with the stored values
	 */
	public static Calendar convertCalendar(String calendarString){
		Calendar converted = Calendar.getInstance();
		
		String [] splittetDate = calendarString.split(" ");
		int day = Integer.parseInt(splittetDate[0]);
		int month = getMonthAsInt(removeLastComma(splittetDate[1]));
		int year = Integer.parseInt(splittetDate[2]);
		
		converted.set(year, month, day);
		return converted;
	}

	public static int getMonthAsInt(String month) {
		switch (month) {
		case "January":
			return 1;
		case "February":
			return 2;
		case "March":
			return 3;
		case "April":
			return 4;
		case "May":
			return 5;
		case "June":
			return 6;
		case "July":
			return 7;
		case "August":
			return 8;
		case "September":
			return 9;
		case "October":
			return 10;
		case "November":
			return 11;
		case "December":
			return 12;
		default:
			System.out.println("Something wrong in CalendarHelper :" + month);
			return 1;
		}
	}
	
	public static String theMonth(int month){
	    String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    return monthNames[month];
	}
	
	public static String removeLastComma(String str) {
	    if (str != null && str.length() > 0 && str.charAt(str.length()-1)==',') {
	      str = str.substring(0, str.length()-1);
	    }
	    return str;
	}
}
