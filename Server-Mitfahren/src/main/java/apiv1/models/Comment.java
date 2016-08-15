package apiv1.models;

public class Comment{
	public String comment;
	public float commentRating;
	public String username;
	public int userId;
	
	public Comment(String comment, float commentRating, String username, int userId) {
		super();
		this.comment = comment;
		this.commentRating = commentRating;
		this.username = username;
		this.userId = userId;
	}
}