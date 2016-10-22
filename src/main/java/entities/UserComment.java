package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserComment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	
	private String comment;
	private float commentRating;
	private String commenterUserName;
	private int commenterId;
	
	public UserComment(){}
	
	public UserComment(String comment, String commenterUserName, float commentRating, int commenterId) {
		super();
		this.comment = comment;
		this.commentRating = commentRating;
		this.commenterUserName = commenterUserName;
		this.commenterId = commenterId;
	}



	/**
	 * @return the commentId
	 */
	public int getCommentId() {
		return commentId;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the commentRating
	 */
	public float getCommentRating() {
		return commentRating;
	}
	/**
	 * @param commentRating the commentRating to set
	 */
	public void setCommentRating(float commentRating) {
		this.commentRating = commentRating;
	}
	/**
	 * @return the commenterId
	 */
	public int getCommenterId() {
		return commenterId;
	}
	/**
	 * @param commenterId the commenterId to set
	 */
	public void setCommenterId(int commenterId) {
		this.commenterId = commenterId;
	}

	/**
	 * @return the commenterUserName
	 */
	public String getCommenterUserName() {
		return commenterUserName;
	}

	/**
	 * @param commenterUserName the commenterUserName to set
	 */
	public void setCommenterUserName(String commenterUserName) {
		this.commenterUserName = commenterUserName;
	}
	
	
}
