<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/CustomTag/customtag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="js/load.js"></script>
<link rel="stylesheet" href="css/home.css">

</head>
<body>
<%
String sessr=(String) session.getAttribute("reg");
if(sessr.equals("")||sessr==null){
	response.sendRedirect("index.jsp");
}

%>
<%-- <%ArrayList<String> ar=(ArrayList<String>)request.getAttribute("data"); %> --%>
<div id="postcontainer">

<div id="postmenu">
<a href="home.jsp"> <c:custom textColor='yellow' text='CARPOOLING'/></a> <br>
 <ul id="ulmenu">
 
 <li><a href="updateProfile.jsp">Update Profile</a></li>
 <li><a href="weathermap.html">Weather</a></li>
 <li><a href="DeletePost.jsp">Delete Post</a></li>
 </ul>
 <div id="sessiondiv">
 <%=session.getAttribute("reg") %><br>
 <button id="aask">Ask Ride</button><button id="btnLogout">Logout</button>
 </div>
</div>
<div id="postdiv">
<form action="InsertPost" method="post">
<textarea rows="4" cols="80" name="txtPost" placeholder="What's on your mind..."></textarea><br><br>
<label>Type :</label><input type="radio" name="rdType" value="offerride"> Offer Ride  <input type="radio" name="rdType">Take Ride<br><br>
<input type="submit" value="         Post        ">
</form>
</div>
</div>
<div id="ajdiv">
<%String s=(String)request.getAttribute("msg"); %>
<%
if(s!=null){
out.println(request.getAttribute("msg"));

}
%>
<%-- <%for(int i=0;i<ar.size()-1;i++){
	out.println("<div class='post'><p>"+ar.get(i)+"</p>"+
"<a href='#' class='posta'>  Like   </a><a href='#' class='posta'>  Comment   </a></div>");
} %> --%>
<%-- <%=request.getAttribute("msg") %>--%>
</div>
<div id="piddiv"></div>
</body>
</html>