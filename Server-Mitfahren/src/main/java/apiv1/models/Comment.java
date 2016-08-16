package apiv1.models;

public class Comment{
	public String comment;
	public float commentRating;
	public String username;
	public String userId;
	
	public Comment(String comment, float commentRating, String username, String userId) {
		super();
		this.comment = comment;
		this.commentRating = commentRating;
		this.username = username;
		this.userId = userId;
	}
}