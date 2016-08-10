package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Object wich represents a city.
 * It has a name and picture URL wich is shown on the autocomplete text.
 * @author Leon Johann Brettin
 *
 */
@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;
	
	String name;
	String pictureUrl;
	
	public City(){}
	
	public City(String name){
		this.name = name;
		this.pictureUrl = null;
	}
	
	public City(String name, String pictureUrl){
		this.name = name;
		this.pictureUrl = pictureUrl;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}
