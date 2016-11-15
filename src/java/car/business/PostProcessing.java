package car.business;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.dto.DBconnection;
import car.model.PostObject;


public class PostProcessing {
	/*public String InsertMessage(Connection connection, HttpServletRequest request, HttpServletResponse response){
		return null;
		
	}*/
	public ArrayList<String> GetMessage(){
		ArrayList postData=new ArrayList();
		try{
			PreparedStatement ps=DBconnection.getConnection().prepareStatement("select * from users u inner join posts p on u.userid=p.userid where p.posttype=1 order by  p.dateupdated desc;");
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
	/*int count=0;
	
	public  ArrayList<String> show() throws Exception{
		try{
			
			Connection con=DBconnection.getConnection();
			PreparedStatement statement=con.prepareStatement("Select post from posts");
			ResultSet result=statement.executeQuery();
			ArrayList<String> str=new ArrayList<String>();
			FileWriter writer=fileWriter();
			while(result.next()){
				System.out.print(result.getString("post"));
				System.out.println();
				str.add(result.getString("post"));
				JSONObject obj=new JSONObject();
				//JSONArray arr=new JSONArray();
				//arr.add(result.getString("post"));
				obj.put("post", result.getString("post"));
				try{
					writer.write(obj.toString());
					
				}
				catch(IOException ex){
					System.out.println(ex.toString());
				}
				
			}
			writer.flush();
			writer.close();
			return str;
		}
		catch(Exception ex){
			System.out.println(ex.toString());
			
		}
		return null;
	}
	public static FileWriter fileWriter() throws IOException{
		File file=new File("z:\\test.json");
		file.createNewFile();
		FileWriter writer=new FileWriter("z:\\test.json");
		return writer;
	}*/
}
