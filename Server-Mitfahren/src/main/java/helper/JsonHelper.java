package helper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import apiv1.models.SearchDrive;

/**
 * Helper class for Json Objects
 * @author Leon Johann Brettin
 *
 */
public class JsonHelper {
	
	/**
	 * Converts a proper JsonElement into a SearchDrive Model
	 * @param jElement proper JsonElement with the Parameters: destination, arrival, date.
	 * @return SearchDrive Object with the stored data in it.
	 */
	public static SearchDrive convertJElementToSearchDrive(JsonElement jElement) {
		JsonObject jObject = jElement.getAsJsonObject();
		
		String destination = jObject.get("destination").getAsString();
		String arrival = jObject.get("arrival").getAsString();
		String date = jObject.get("date").getAsString();
		SearchDrive search = new SearchDrive(destination, arrival, date);
		
		return search;
	}
}
