package car.business;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import car.dto.DBconnection;

public class UserProcessing  {
	public boolean insertUser(String name,String gender,String state,String city,String street,int zip,int birthyear,String mail,String Password) throws Exception{
		String emailmd="";
		try{
			
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(Password.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			emailmd=sb.toString();
			int m=0;
			if(gender.equals("Male")){
				m=1;
			}
			else if(gender==""||gender==null||gender.isEmpty()){
				m=1;
			}
			else{
				m=0;
			}
			//System.out.println(name+gender+state);
			Connection con=DBconnection.getConnection();
			System.out.println("after");
			String insert="insert into users(fullname,gender,state,city,street,zipcode,birthyear,email,password) "
					+ "values ('"+name+"',"+m+",'"+state+"','"+city+"','"+street+"',"+zip+","+birthyear+",'"+mail+"',"+"'"+emailmd+"')";
				PreparedStatement stat=con.prepareStatement(insert);
				stat.executeUpdate();
				System.out.println(emailmd);
				return true;
		}
		catch(Exception ex){
			System.out.println(ex.toString());
			return false;
		}
	}
	public boolean checkLogin(String email, String password) throws Exception{
		String emailmd="";
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		emailmd=sb.toString();
		System.out.println(emailmd);
		Connection con=DBconnection.getConnection();
		String query="select email,password from users";
		PreparedStatement stat=con.prepareStatement(query);
		ResultSet res=stat.executeQuery();
		while(res.next()){
			String mail=res.getString("email").toString();
			String pass=res.getString("password").toString();
			if(email.equals(mail)&&pass.equals(emailmd)){
				return true;
			}
		}
		
		return false;
	}
	


	public boolean updateUser(String name,String state,String city,String street,int zip,int birthyear,String email) throws Exception{
		boolean flag=false;
		Connection con=DBconnection.getConnection();
		String query="update users set fullname='"+name+"',state='" +state+"',city='" +city+"',street='" +street+"' ,"
					  + "zipcode='" +zip+"' ,birthyear='" +birthyear+"'where email='"+email+"'";
		System.out.println(query);
		PreparedStatement stat=con.prepareStatement(query);
		stat.executeUpdate();
		flag=true;
		System.out.println(flag);
			return flag;
		
	
	}

	
}
