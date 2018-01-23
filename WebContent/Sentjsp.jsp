<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SentItems</title>
</head>
<%
if(session.getAttribute("userName")==null){
	response.sendRedirect("http://localhost:5555/ProjectDay1/faces/LoginPage.jsp");
}
%>
<body  background="../images/header.jpg" >
<f:view>
<h:form>
<center>
<br><br>
<div style="background-color: #aed5fc; width: 300px;height:100px;">
<br><br>
<center>
<h:outputText value="The Receiver is: #{sentMB.name}" style="font-size:25px; font-family:verdana; color: green;"></h:outputText><br>
<br>
<br>
</center></div>
<center>
<br>
<br><br><br><br>
<h:graphicImage url="../ImagesSent/#{sentMB.imageNameInbox}" width="200" height="170"> </h:graphicImage><br>
</center>
</h:form>
</f:view>
</body>
</html>