<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="favicon.ico">
    <title>UserHome</title>
    <meta name="description" content="A free responsive HTML 5 template with a clean style.">
    <meta name="keywords" content="free template, html 5, responsive, clean, scss">
   
    <meta property="og:title" content="">
    <meta property="og:description" content="">
    <meta property="og:url" content="">
    <meta property="og:image" content="">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="address=no">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/image.css">
	<script src="../js/image.js"></script>
	
<title>UserHome</title>


</head>
<%
if(session.getAttribute("userName")==null){
	response.sendRedirect("http://localhost:5555/ProjectDay1/faces/LoginPage.jsp");
}
%>
<body >
<div id="bg">
<img src="../images/Untitled.jpg" alt="">


<f:view>
	<div class="main">
        
            <div class="wrap">
                
                <div class="header-wrapper">
                    
                    
              
                    <div class="main-title">
                       <h:outputText value="About Steganography" style="color:blue;"></h:outputText>
                       <br><br>
                       
                    </div>
                    <div class="main-title2">
                    <p style="color:white;">Steganography is the art of hiding the fact that communication is taking place, by hiding information in
other information. Many different carrier file formats can be used, but digital images are the most
popular because of their frequency on the Internet. An image is chosen which acts as the carrier called Stego Image. The least 
significant bit of every pixel is chosen and the data is stored in this bit position. Since it is the least significant
bit is modified the change in the image is so minute that it cannot be observed with naked eye.
<br><br>
</p>
                    
                    
                    </div>
                    

                </div>
                <!-- /.header-wrapper -->
            </div>
            <!-- /.wrap -->
     
	</div>
</f:view>

<script src="js/jquery.js"></script>
    <script src="js/library.js"></script>
    <script src="js/script.js"></script>
    <script src="js/retina.js"></script>
    <script src="js/image.js"></script>
</div>
</body>

</html>