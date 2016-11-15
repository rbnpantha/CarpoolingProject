<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" import="com.car.dto.DBconnection" import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class="randompad">
<div id="formcenter">
<div class="formholderr">
<%
String name="";
String state="";
String city="";
String street="";
String zipCode="";
String dob="";
String email2=(String) session.getAttribute("reg");
String query="select * from users where email='"+email2+"';";
java.sql.PreparedStatement ps;
try {
	ps = DBconnection.getConnection().prepareStatement(query);
	ResultSet rs=ps.executeQuery();
	while (rs.next()){
		 name=rs.getString("fullname");
		 state=rs.getString("state");
		 city=rs.getString("city");
		 street= rs.getString("street");
		 zipCode=rs.getString("zipCode");
		 dob=rs.getString("birthYear");
	}
}
	catch(Exception ex){
		}
	
 %>
<h1 id="h1reg">Update Profile</h1>
<form action="Update" method="post" id="formreg">
<label>Full Name:</label><input type="text" name="txtFullName" required="required" value=<%=name %>><br>
<label>State: </label> <input type="text" name="txtState" required="required" value=<%=state %>><br>
<label>City: </label><input type="text" name="txtCity" required="required" value=<%=city %>><br>
<label>Street: </label><input type="text" name="txtStreet" required="required" value=<%=street %>><br>
<label>Zip Code: </label><input type="text" name="txtZipCode" required="required"  pattern="[\d]{5}" title="five digit number only" placeholder="eg. 52557" value=<%=zipCode %>><br>
<label>Birth Year: </label><input type="text" name="txtBirthYear" required="required"  pattern="[1][\d][0-8][\d]|[1][\d][9][0-8]" title="Invalid year four digit number or less than 18 years" placeholder="eg. 1990" value=<%=dob %>><br>
<input type="submit" value="Submit & Save" id="btnRegister">
</form>
</div>
</div>
</div>
</body>
</html>