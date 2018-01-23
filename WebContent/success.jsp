<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<%
if(session.getAttribute("userName")==null){
	response.sendRedirect("http://localhost:5555/ProjectDay1/faces/LoginPage.jsp");
}
%>
<body  background="../images/header.jpg" >
<f:view><h:form>
<center>
<br><br><br>
<p style="font-family : sansserif; font-size : 30px; color : #228b22;">Message has been sent successfully!!</p> <br>
<br>
<p style="font-family : sansserif; font-size : 30px; color : grey;"><a href="http://localhost:5555/ProjectDay1/faces/UserWelcome.jsp" target="action"  class="button" >Click here to go back to Home</a></p>

</center>
</h:form>
</f:view>
</body>
</html>