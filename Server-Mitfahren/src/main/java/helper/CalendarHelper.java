package helper;

import java.util.Calendar;

public class CalendarHelper {

	public static boolean compareCalenderDates(Calendar cal1, Calendar cal2) {
		System.out.println("Year--Cal1:" + cal1.get(Calendar.YEAR) + "--Cal2:" + cal2.get(Calendar.YEAR) );
		System.out.println("Day--Cal1:" + cal1.get(Calendar.DAY_OF_YEAR) + "--Cal2:" + cal2.get(Calendar.DAY_OF_YEAR));
		
		return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
	}
	
	/**
	 * 
	 * @param date is a String with the following form:
	 * 24 August, 2016
	 * @return Calendar Object with the stored values
	 */
	public static Calendar convertCalendar(String date){
		Calendar converted = Calendar.getInstance();
		
		String [] splittetDate = date.split(" ");
		int day = Integer.parseInt(splittetDate[0]);
		int month = getMonthAsInt(removeLastComma(splittetDate[1]));
		int year = Integer.parseInt(splittetDate[2]);
		
		converted.set(year, month, day);
		return converted;
	}
	
	public static Calendar convertCalendar(String date, String time) {
		Calendar converted = convertCalendar(date);
		
		String [] splittetDate = date.split(" ");
		int day = Integer.parseInt(splittetDate[0]);
		int month = getMonthAsInt(removeLastComma(splittetDate[1]));
		int year = Integer.parseInt(splittetDate[2]);
		
		String [] splittedTime = time.split(" ");
		int hour = Integer.parseInt(splittedTime[0].split(":")[0]);
		int minute = Integer.parseInt(splittedTime[0].split(":")[1]);
		
		if(splittedTime[1].equals("PM")) {
			hour += 12;
		}
		
		converted.set(year, month, day, hour, minute);
		return converted;
	}

	/**
	 * Returns the number of a month.
	 * Example: When you put in "January" as a parameter you get 0.
	 * @param month Month String.
	 * @return number of that month.
	 */
	public static int getMonthAsInt(String month) {
		switch (month) {
		case "January":
			return 0;
		case "February":
			return 1;
		case "March":
			return 2;
		case "April":
			return 3;
		case "May":
			return 4;
		case "June":
			return 5;
		case "July":
			return 6;
		case "August":
			return 7;
		case "September":
			return 8;
		case "October":
			return 9;
		case "November":
			return 10;
		case "December":
			return 11;
		default:
			System.out.println("Something wrong in CalendarHelper :" + month);
			return 0;
		}
	}
	
	/**
	 * Returns the Month string for a month number.
	 * @param month Integer wich represents a month.
	 * @return String of the month.
	 */
	public static String getMonthAsString(int month){
	    String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    return monthNames[month];
	}
	
	/**
	 * Gets day, month and year out of the calendar and converts it into a String.
	 * @param calendar object, where you want the date from.
	 * @return String of the date.
	 */
	public static String getCalendaDateAsString(Calendar calendar) {
		return calendar.get(Calendar.DAY_OF_MONTH) + ". " 
						+ CalendarHelper.getMonthAsString(calendar.get(Calendar.MONTH))
						+ " " + calendar.get(Calendar.YEAR);
	}
	
	/**
	 * Gets hour and minutre out of the calendar and converts it inta a String.
	 * @param calendar object, where you want the time from.
	 * @return String of the time.
	 */
	public static String getCalendarTimeAsString(Calendar calendar) {
		String timeString = "";
		timeString += calendar.get(Calendar.HOUR_OF_DAY);
		timeString += ":";
		int minute = calendar.get(Calendar.MINUTE);
		if (minute < 10){
			timeString += "0" + minute;
		} else {
			timeString += minute;
		}
		
		return timeString;
	}
	
	/**
	 * Helper class to remove the last character of a String, 
	 * if the last character is a comma.
	 * @param str String, where you want to remove the comma from.
	 * @return String without a comma at the last position.
	 */
	private static String removeLastComma(String str) {
	    if (str != null && str.length() > 0 && str.charAt(str.length()-1)==',') {
	      str = str.substring(0, str.length()-1);
	    }
	    return str;
	}
}
