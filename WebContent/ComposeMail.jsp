<%@page import="java.io.FileFilter"%>

<%@page import="java.io.FilenameFilter"%>

<%@page import="java.io.File"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="x"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>

    <html>

        <head>
			<link rel="stylesheet" type="text/css" href="css/abc.css" />
			<link rel="stylesheet" type="text/css" href="css/button.css" media="screen" />
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
            <script type="text/javascript">
            function b()
            {
            	var flag12=document.getElementById("form:flag").value;
            	var message=document.getElementById("form:message").value;
            	if(flag12=="%%%"){
                	alert(message);
            	}
            }

            function z(){
            var siz=document.getElementById("form:size").value;
            if(siz==0){
            	document.getElementById("countdown").style.display="none";
            }
            else{
            	document.getElementById("countdown").style.display="true";
            }
            }
            </script>

        </head>
		<%
if(session.getAttribute("userName")==null){
	response.sendRedirect("http://localhost:5555/ProjectDay1/faces/LoginPage.jsp");
}
%>
        <body background="../images/header.jpg" onload="z()">  
			
            <h:form enctype="multipart/form-data" id="form">
			 <center>
			 <h:outputText value="#{uploadMB.message}" rendered="#{not empty uploadMB.message}" styleClass="message" style="font-size:30px;"></h:outputText><br>
			 <h:outputText value="#{uploadMB.message2}" rendered="#{not empty uploadMB.message2}" styleClass="message" style="font-size:30px;"></h:outputText><br>
			 <h:outputText value="Enter the UserName:" rendered="#{empty uploadMB.put}" style="font-family : verdana; size : 60px; color : white; "></h:outputText>
			 <h:inputText value="#{uploadMB.toUserName}" rendered="#{empty uploadMB.put}" valueChangeListener="#{uploadMB.sendtoo}" onchange="submit()"  styleClass="roundBox"></h:inputText>
			 <h:outputText value="To:" rendered="#{not empty uploadMB.put}"  style="font-family : verdana; size : 60px"></h:outputText>
			 <h:outputText value="#{uploadMB.toUserName}" rendered="#{not empty uploadMB.put}" ></h:outputText>
			 <br>
			 <br>
			 <h:inputHidden value="#{loginMB.username}" id="user1" > </h:inputHidden>
                <h:panelGrid border="0" columns="1">
	
                    <x:inputFileUpload id="file" value="#{uploadMB.upload}" required="false" size="40" rendered="#{uploadMB.imageName eq null}"  styleClass="btn btn-4 btn-4a icon-arrow-right"/>
                 <br>
					<div id="button"> <h:commandButton onclick="a()" action = "#{uploadMB.uploadFile}" value="Add Files"  styleClass="btn btn-6 btn-6a" rendered="#{uploadMB.imageName eq null}"></h:commandButton>   </div>
					
					
               </h:panelGrid>
               </center>
               <br>  
               <br>
                <center>
                <div id="img">
                <img id="img2"  style="display: none;" src="gif/loading.gif" >
                <div id="img1"><h:graphicImage url="../UploadedImages/#{uploadMB.imageName}" width="450" height="200" rendered="#{uploadMB.imageName ne null}" > </h:graphicImage></div>
                </div>
                </center>
                <br>
                <br>
                <center>
                 <h:outputText value="Enter the text to be encrypted: " rendered="#{uploadMB.imageName ne null}" style="font-family : verdana; size : 60px; color:white;"></h:outputText><br>
               <h:inputTextarea value="#{uploadMB.data}" onkeyup="limitTextArea(this,#{uploadMB.size},this.form.countdown);" onkeydown="limitTextArea(this,#{uploadMB.size},this.form.countdown);" cols="30" rows="6" style="width: 229px" rendered="#{uploadMB.imageName ne null}" styleClass="styled"/><br><br>
               <h:outputText value="(MaximumCharacters: #{uploadMB.size} )" rendered="#{uploadMB.imageName ne null}" ></h:outputText><br>
            <div id="countdown">
            <font size="1">You have
            <input readonly type="text"  name="countdown" size="3" value="" > characters left</font>
            </div>
            <br/>
            <br> <h:commandButton value="Encrypt" action="#{uploadMB.Encrypted}" rendered="#{uploadMB.imageName ne null}" styleClass="btn btn-6 btn-6a"></h:commandButton><br>
               
 			<script> 
 				function limitTextArea(element, limit , limitNum) { 

 				if (element.value.length > limit) { 
 					element.value = element.value.substring(0, limit); 
 				} 
 				else
 				{
 	 				limitNum.value = limit - element.value.length; 
 				}
 			} 
 		</script>
               </center>
                <br>
                <br>
                <center>
                <h:commandButton value="Send" rendered="#{not empty uploadMB.data1 and not empty uploadMB.toUserName}" action="#{uploadMB.sendMessage}" onclick="b()" styleClass="btn btn-6 btn-6a"></h:commandButton>
                <h:commandButton value="CANCEL" action="#{logoutMB.cancleButtonss}" styleClass="btn btn-2 btn-2b"></h:commandButton>
                </center>
                <h:inputHidden id="message" value="#{uploadMB.message1}">   </h:inputHidden>
                <h:inputHidden id="flag" value="#{uploadMB.flag}">   </h:inputHidden>
				<h:inputHidden id="size" value="#{uploadMB.view}"></h:inputHidden>
            </h:form> 
            <script src="jquery.js"></script> 
        <script>
        function a()
        {
        	$('#img #img2').css('display','block');
        }
       
        </script>  
           
                 </body>
                 
     
    </html>
    

</f:view>
