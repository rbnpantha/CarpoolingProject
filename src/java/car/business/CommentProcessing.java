package car.business;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import car.dto.DBconnection;
import car.model.CommentObject;

public class CommentProcessing {
public ArrayList<String> getMessage() throws SQLException, Exception{
	ArrayList comObject=new ArrayList();
	PreparedStatement ps=DBconnection.getConnection().prepareStatement("select u.fullname,c.userid,c.commentid,c.postid,c.datecreated,c.dateupdated,c.comment from users u INNER JOIN comments c inner join posts p on p.postid=c.postid and u.userid=c.userid");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		CommentObject com=new CommentObject();
		com.setCommentid(Integer.parseInt(rs.getString("commentid")));
		com.setUserid(Integer.parseInt(rs.getString("userid")));
		com.setPostid(Integer.parseInt(rs.getString("postid")));
		com.setComment(rs.getString("comment"));
		com.setDatecreated(rs.getString("datecreated"));
		com.setDateupdated(rs.getString("dateupdated"));
		com.setFullname(rs.getString("fullname"));
		comObject.add(com);
	}
	
	System.out.println(comObject.toString());
	return comObject;
} 
}
