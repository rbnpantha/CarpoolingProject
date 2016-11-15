package car.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Group 1
 * @28 Aug 2016 
 */
public class DBconnection {
	public static Connection getConnection()throws Exception{
		Connection con;
		try{
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/carpooling";
			String username="root";
			String password="";
			Class.forName(driver);
			con=DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return con;
		}
		catch(Exception e){
			System.out.println(e.toString());
			
		}
		return null;
		
	}
	public static void createTable() throws Exception{

		try{
			Connection con=getConnection();
			PreparedStatement create=con.prepareStatement("CREATE TABLE IF NOT EXISTS tablename(id int NOT NULL AUTO_INCREMENT,first varchar(255),last varchar(255),PRIMARY KEY(ID));");
			create.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e.toString());
			
		}
		finally{System.out.println("IN FINAL BLOCK");}
	}
	public static void post()throws Exception{
		final String var1="Deependra";
		final String var2="Pathak";
		try{
			Connection con=getConnection();
			PreparedStatement posted=con.prepareStatement("insert into tablename(first,last) values('"+var1+"','"+var2+"')");
			posted.executeUpdate();
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		finally{System.out.println("Finally in final of insert");}
	}
	public static ArrayList<String> show() throws Exception{
		try{
			Connection con=getConnection();
			PreparedStatement statement=con.prepareStatement("Select first,last from tablename limit 2");
			ResultSet result=statement.executeQuery();
			ArrayList<String> str=new ArrayList<String>();
			while(result.next()){
				System.out.print(result.getString("first")+"   ");
				System.out.print(result.getString("last"));
				System.out.println();
				str.add(result.getString("last"));
				
			}
			return str;
		}
		catch(Exception ex){
			System.out.println(ex.toString());
			
		}
		return null;
	}

}
