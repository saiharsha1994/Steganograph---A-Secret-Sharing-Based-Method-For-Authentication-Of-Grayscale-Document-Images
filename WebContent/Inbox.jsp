<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inbox</title>
<link rel="stylesheet" type="text/css" href="css/button.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/abc.css"/>
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
<br><br><br>
<h:dataTable value="#{inboxMB.list}" var="van" border="0" binding="#{inboxMB.table}" rendered="#{empty inboxMB.there}" rowClasses="odd,even">
<h:column>
<f:facet name="header">
  <h:outputText value="Sender" style="color : #000080; font-family:verdana; font-size :30px;"></h:outputText>
</f:facet>


<h:commandButton value="Click here to view message from #{van.sender}" action="#{inboxMB.click}" rendered="#{van.flag eq 0}" styleClass="btn btn-11 btn-11a"></h:commandButton>
<h:commandButton value="NEW! Click here to view message from #{van.sender} " action="#{inboxMB.click}" rendered="#{van.flag eq 1}" styleClass="btn btn-1 btn-1a"></h:commandButton>
</h:column>

<h:column>
<f:facet name="header">
  <h:outputText value="Date" style="color :#000080; font-family:verdana; font-size :30px;"></h:outputText>
</f:facet>
<h:outputText value="#{van.date1}"></h:outputText>
</h:column>
</h:dataTable>
<h:outputText value="#{inboxMB.there}" rendered="#{not empty inboxMB.there}" styleClass="message" > </h:outputText>
</center>
</h:form>
</f:view>
</body>
</html>