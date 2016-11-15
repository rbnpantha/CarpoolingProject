<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Post</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="js/delete.js"></script>
<link rel="stylesheet" href="css/delete.css">
</head>
<body>
<div>

</div>
<div id="dicdelete">
<h1><a href="home.jsp">HOME</a></h1><br>
<h1>Hello user <%=session.getAttribute("reg") %>. Please press delete button to delete post:</h1><br><br>
</div>
</body>
</html>