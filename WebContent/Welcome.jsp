<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="css/abc.css" />
</head>
<%
if(session.getAttribute("userName")==null){
	response.sendRedirect("http://localhost:5555/ProjectDay1/faces/LoginPage.jsp");
}
%>
<body background="../images/header.jpg" style="position:absloute; left:0px;right:0px;top:0px;bottom:0px backgroung-repeat:repeat-none;">
<f:view>
<h:form>
<center>
 <MARQUEE><h:outputText value="Welcome #{loginMB.username}" style="font-family:verdana; font-size:41px;color:red;font-style:italic;" ></h:outputText></MARQUEE>
</center>
</h:form>
</f:view>
</body>
</html>