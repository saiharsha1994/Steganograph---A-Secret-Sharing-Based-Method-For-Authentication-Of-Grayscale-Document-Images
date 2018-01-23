<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserHome</title>
</head>
<div >

<frameset rows="10%,*" border="0" style="background-color: red;">
    <frame src="http://localhost:5555/ProjectDay1/faces/Welcome.jsp">
    <frameset cols="25%,*" border="0">
    	<frame name="button" src="http://localhost:5555/ProjectDay1/faces/Button.jsp">
		<frame name="action" src="http://localhost:5555/ProjectDay1/faces/UserWelcome.jsp" >
    </frameset> 
</frameset>
</div>
<%
if(session.getAttribute("userName")==null){
	response.sendRedirect("http://localhost:5555/ProjectDay1/faces/LoginPage.jsp");
}
%>
<body>
<f:view>

</f:view>
</body>
</html>