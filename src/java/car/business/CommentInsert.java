package car.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import car.dto.DBconnection;

public class CommentInsert {
public boolean insertComment(String user,int postid,String comment) throws Exception{
	boolean flag=false;
	int useridn=0;
	Connection con=DBconnection.getConnection();
	PreparedStatement ps=con.prepareStatement("select userid from users where email='"+user+"'");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		useridn=Integer.parseInt(rs.getString("userid"));
	}
	String insert="insert into comments (userid,postid,comment) VALUES("+useridn+","+postid+",'"+comment+"')";
	PreparedStatement psu=con.prepareStatement(insert);
	psu.executeUpdate();
	flag=true;
	return flag;
}
}
