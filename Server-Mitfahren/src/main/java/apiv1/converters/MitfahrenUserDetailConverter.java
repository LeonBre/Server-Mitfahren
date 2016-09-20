package apiv1.converters;

import java.util.LinkedList;
import java.util.List;

import apiv1.models.response.Comment;
import apiv1.models.response.MitfahrenUserDetail;
import apiv1.models.response.OtherDrive;
import entities.Drive;
import entities.MitfahrenUser;
import entities.MitfahrenUserService;
import entities.UserComment;
import helper.CalendarHelper;

/**
 * Class to Convert a userId in a Detail Model
 * @author Leon Johann Brettin
 *
 */
public class MitfahrenUserDetailConverter {

	MitfahrenUserService userService;
	
	/**
	 * Basic constructor.
	 * You need the userService to get the User out of the database.
	 * @param userService userService to interact with the database.
	 */
	public MitfahrenUserDetailConverter (MitfahrenUserService userService) {
		this.userService = userService;
	}
	
	/**
	 * Method to get from a given userId 
	 * a MitfahrenuserDetail Model for the user.html page.
	 * @param userId UserId of the requested user.
	 * @return MitfahrenUserDetail model for the user.html page.
	 */
	public MitfahrenUserDetail convertIdToModel(String userId) {
		MitfahrenUserDetail output = new MitfahrenUserDetail();
		MitfahrenUser currentUser = userService.find(Integer.parseInt(userId));
		if(currentUser == null)
			return null;
		output.userId = currentUser.getUserId() + "";
		output.userName = currentUser.getUsername();
		output.userRating = currentUser.getUserRating() + "";
		output.pictureUrl = currentUser.getPictureBase64();
		
		List<Comment> userComments = new LinkedList<>();
		for(UserComment comment: currentUser.getUserComments()) {
			userComments.add(new Comment(comment.getComment(),
					comment.getCommentRating(), 
					comment.getCommenterUserName(), 
					comment.getCommenterId() + ""));
		}
		
		output.commentList = userComments;
		
		
		List<OtherDrive> otherDrives = new LinkedList<>();
		System.out.println("As driverList Size:" + currentUser.getAsDriverList().size());
		for(Drive drive : currentUser.getAsDriverList()) {
			otherDrives.add(
					new OtherDrive(
							drive.getDriveId() + "", 
							drive.getDestination().getName(), 
							drive.getArrival().getName(),
							CalendarHelper.getCalendaDateAsString(drive.getCalendar()),
							CalendarHelper.getCalendarTimeAsString(drive.getCalendar())
							)
			);
		}
		output.asDriverList = otherDrives;
		
		return output;
	}
}

