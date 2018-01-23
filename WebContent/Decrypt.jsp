<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/button.css"  media="screen"/>
<title>Insert title here</title>
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
<h:outputText value="From  : #{inboxMB.name}" style="font-size:25px; font-family:verdana; color: green;"></h:outputText><br>
<br>
<br>
</center>
</div>
</center>
<br><br>
<center>
<div >
<h:graphicImage url="../ImagesRetrived/#{inboxMB.imageNameInbox}" width="200" height="170"> </h:graphicImage><br><br><br>
<h:commandButton value="decrypt" action="#{inboxMB.decrypted}" styleClass="btn btn-6 btn-6a"></h:commandButton><br>
</div><br><br><br>
<br>
<h:outputText value="#{inboxMB.s}" rendered="#{not empty inboxMB.s}" style="color:white;font-size:20px;"></h:outputText>
</center>
</h:form>
</f:view>
</body>
</html>