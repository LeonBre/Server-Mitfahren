package helper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import apiv1.models.SearchDrive;

public class JsonHelper {

	public static SearchDrive convertJElementToSearchDrive(JsonElement jElement) {
		JsonObject jObject = jElement.getAsJsonObject();
		
		String destination = jObject.get("destination").getAsString();
		String arrival = jObject.get("arrival").getAsString();
		String date = jObject.get("date").getAsString();
		SearchDrive search = new SearchDrive(destination, arrival, date);
		
		return search;
	}
}
