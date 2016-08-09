package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class UserComment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	
	private String comment;
	private int commentRating;
	private int commenterId;
	
	public UserComment(){}
	
	public UserComment(String comment, int commentRating, int commenterId) {
		super();
		this.comment = comment;
		this.commentRating = commentRating;
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
	public int getCommentRating() {
		return commentRating;
	}
	/**
	 * @param commentRating the commentRating to set
	 */
	public void setCommentRating(int commentRating) {
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
	
	
}
