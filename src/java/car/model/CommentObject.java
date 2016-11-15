package car.model;

import java.sql.PreparedStatement;

import car.dto.DBconnection;

public class CommentObject {
private int commentid;
private int userid;
private int postid;
private String comment;
private String datecreated;
private String dateupdated;
private String fullname;

public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public int getCommentid() {
	return commentid;
}
public void setCommentid(int commentid) {
	this.commentid = commentid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getPostid() {
	return postid;
}
public void setPostid(int postid) {
	this.postid = postid;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public String getDatecreated() {
	return datecreated;
}
public void setDatecreated(String datecreated) {
	this.datecreated = datecreated;
}
public String getDateupdated() {
	return dateupdated;
}
public void setDateupdated(String dateupdated) {
	this.dateupdated = dateupdated;
}

}
