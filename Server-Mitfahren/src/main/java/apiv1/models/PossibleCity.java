package apiv1.models;

public class PossibleCity {
	String name;
	String pictureUrl;
	
	public PossibleCity(String name){
		this.name = name;
		this.pictureUrl = null;
	}
	
	public PossibleCity(String name, String pictureUrl){
		this.name = name;
		this.pictureUrl = pictureUrl;
	}
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}
