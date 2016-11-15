package car.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import car.dto.DBconnection;

public class PostInsert {
public boolean insertPost(String userid,String post,String posttype) throws Exception{
	boolean flag=false;
	int useridn=0;
	int type=0;
	Connection con=DBconnection.getConnection();
	PreparedStatement ps=con.prepareStatement("select userid from users where email='"+userid+"'");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		useridn=Integer.parseInt(rs.getString("userid"));
	}
	if(posttype.equals("offerride")){
		type=1;
	}
	String insert="insert into posts(userid,post,posttype) values ("+useridn+",'"+post+"',"+type+")";
	PreparedStatement psu=con.prepareStatement(insert);
	psu.executeUpdate();
	flag=true;
	return flag;
}
}
