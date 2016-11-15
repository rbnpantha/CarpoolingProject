package car.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import car.dto.DBconnection;

public class LikeProcessing {
public boolean inserLike(String email,int postid) throws Exception{
	boolean flag=false;
	int useridn=0;
	Connection con=DBconnection.getConnection();
	PreparedStatement ps=con.prepareStatement("select userid from users where email='"+email+"'");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		useridn=Integer.parseInt(rs.getString("userid"));
	}
	String insert="insert into likes(postid,userid) values('"+postid+"','"+useridn+"')";
	con.prepareStatement(insert).executeUpdate();
	flag=true;
	return flag;
}
}
