<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--<link rel="stylesheet" type="text/css" href="css/abc.css" media="screen" />
--><link rel="stylesheet" type="text/css" href="css/button.css" media="screen" />
<script type="text/javascript">
function a(){

var fag=document.getElementById("j_id_jsp_370532372_1:flag").value;
if(fag==1)
		top.location.href ='http://localhost:5555/ProjectDay1/faces/LoginPage.jsp';
	
}
</script>


</head>
<body onload="a()"  background="../images/abc.jpg">

<f:view>

<h:form>
<center><br>
<br>
<br>
<a href="http://localhost:5555/ProjectDay1/faces/ComposeMail.jsp" target="action"  class="btn btn-1 btn-1a" >Compose Mail
</a><br><br><br>
<a href="http://localhost:5555/ProjectDay1/faces/load.html" target="action" onclick='document.getElementById("j_id_jsp_370532372_1:bt").click();' class="btn btn-1 btn-1a">Inbox
</a><br><br><br>
<a href="http://localhost:5555/ProjectDay1/faces/load1.html" target="action" onclick='document.getElementById("j_id_jsp_370532372_1:bt1").click();' class="btn btn-1 btn-1a">Sent Items
</a>
<br>
<br>
<br>
<br>
<h:commandButton value="Logout" action="#{logoutMB.logoutFunction}" styleClass="btn btn-2 btn-2b"></h:commandButton>
<h:inputHidden id="flag" value="#{logoutMB.flag}"> </h:inputHidden><br><br>
<div style="display:none;"><h:commandButton id="bt" value="Inbox" action="#{inboxMB.inboxView}"></h:commandButton></div>
<div style="display:none;"><h:commandButton id="bt1" value="Sent Items" action="#{sentMB.sentItemsView}" > </h:commandButton></div>
</center>
</h:form>

</f:view>

</body>
</html>