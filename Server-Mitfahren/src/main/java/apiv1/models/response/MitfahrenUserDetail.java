package apiv1.models.response;

import java.util.List;

/**
 * Model for the user.html page.
 * @author Leon Johann Brettin
 *
 */
public class MitfahrenUserDetail {

	public String userId;
	public String userName;
	public String pictureUrl;
	
	public String userRating;
	public List<Comment> commentList;
	public List<OtherDrive> asDriverList;
	
}