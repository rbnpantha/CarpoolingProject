package car.business;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import car.dto.DBconnection;
import car.model.PostObject;

public class PostTakeRide {
	public ArrayList<String> GetMessage(){
		ArrayList postData=new ArrayList();
		try{
			PreparedStatement ps=DBconnection.getConnection().prepareStatement("select * from users u inner join posts p on u.userid=p.userid where p.posttype=0 order by  p.dateupdated desc;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				PostObject postobject=new PostObject();
				postobject.setPostid(Integer.parseInt(rs.getString("postid")));
				postobject.setUserid(Integer.parseInt(rs.getString("userid")));
				postobject.setPosttype(Integer.parseInt(rs.getString("posttype")));
				postobject.setPost(rs.getString("post"));
				postobject.setDatecreated(rs.getString("datecreated"));
				postobject.setDatecreated(rs.getString("dateupdated"));
				postobject.setName(rs.getString("fullname"));
				postData.add(postobject);
			}
			return postData;
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		
		return null;
		
	}

}
