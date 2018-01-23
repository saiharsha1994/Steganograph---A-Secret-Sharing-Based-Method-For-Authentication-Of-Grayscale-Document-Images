<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INDEX</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" />
<link rel="stylesheet" type="text/css" href="css/content.css" />
<link rel="stylesheet" type="text/css" href="css/buttons.css" />
<link rel="stylesheet" type="text/css" href="css/abc.css" />
<link rel="shortcut icon" href="../favicon.ico">

<link rel="stylesheet" type="text/css" href="css/normalize1.css" />
<link rel="stylesheet" type="text/css" href="css/demo1.css" />
<link rel="stylesheet" type="text/css" href="css/component1.css" />
<link href='http://fonts.googleapis.com/css?family=Raleway:200,400,800'
	rel='stylesheet' type='text/css'>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>

<script src="js/modernizr.custom.js"></script>
<script type="text/javascript">
	function a() {
		var count = document.getElementById("counter").value;
		if (count == 1)
			document.getElementById("pop").click();
	}
</script>
</head>
<body onload="a()">
<f:view>
	<h:inputHidden id="counter" value="#{loginMB.counter}"></h:inputHidden>
	<br>
	<br>
	<div class="container demo-1" style="position: absolute;left: 0px;top: 0px;right: 0px;bottom: 0px;">

	<div class="content">
	<div id="large-header" class="large-header">
	<canvas	id="demo-canvas"> </canvas>
	<H1 class="main-title">STEGANOGRAPHY</H1>
	<br>
	<h2 class="main-title2">A Secret-Sharing-Based Method for Authentication of Color Images</h2>

	<div class="main-title1">


	<div class="mockup-content">
	<div
		class="morph-button morph-button-modal morph-button-modal-2 morph-button-fixed">
	<button id="pop" type="button">Click Here to get started !!</button>
	<div class="morph-content">
	<div>
	<div class="content-style-form content-style-form-1" id="popup">
	<span class="icon icon-close">X</span>
	<h3>Login Or SignUp</h3>
	<h:form>
		<p><label> <h:outputText>UserName:</h:outputText></label><h:inputText
			value="#{loginMB.username}" id="login"></h:inputText></p>
		<p><label><h:outputText>Password:</h:outputText></label><h:inputSecret
			value="#{loginMB.password}" id="password"></h:inputSecret></p>
		<p>
		<h:commandButton value="Login"
			action="#{loginMB.validateLogin}"
			styleClass="button button--size-s button--winona button--border-thin button--round-s"></h:commandButton></p>
		<p><h:commandButton value="Register"
			action="#{loginMB.registerUsers}"
			styleClass="button button--size-s button--winona button--border-thin button--round-s"></h:commandButton></p>
		<center>
		<div><h:outputText
			value="you are registered #{loginMB.username}"
			rendered="#{not empty loginMB.username and empty loginMB.message}"></h:outputText>
		<h:outputText value="#{loginMB.message}"
			rendered="#{not empty loginMB.message}"></h:outputText></div>
		</center>
	</h:form></div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	<center></center>
	<br>
	<br>

	<script src="js/classie.js"></script>
	<script src="js/uiMorphingButton_fixed.js"></script>
	<script>
	( function() {
		var docElem = window.document.documentElement, didScroll, scrollPosition;

		// trick to prevent scrolling when opening/closing button
		function noScrollFn() {
			window.scrollTo(scrollPosition ? scrollPosition.x : 0,
					scrollPosition ? scrollPosition.y : 0);
		}

		function noScroll() {
			window.removeEventListener('scroll', scrollHandler);
			window.addEventListener('scroll', noScrollFn);
		}

		function scrollFn() {
			window.addEventListener('scroll', scrollHandler);
		}

		function canScroll() {
			window.removeEventListener('scroll', noScrollFn);
			scrollFn();
		}

		function scrollHandler() {
			if (!didScroll) {
				didScroll = true;
				setTimeout( function() {
					scrollPage();
				}, 60);
			}
		}
		;

		function scrollPage() {
			scrollPosition = {
				x : window.pageXOffset || docElem.scrollLeft,
				y : window.pageYOffset || docElem.scrollTop
			};
			didScroll = false;
		}
		;

		scrollFn();

		[].slice.call(document.querySelectorAll('.morph-button')).forEach(
				function(bttn) {
					new UIMorphingButton(bttn, {
						closeEl : '.icon-close',
						onBeforeOpen : function() {
							// don't allow to scroll
						noScroll();
					},
					onAfterOpen : function() {
						// can scroll again
						canScroll();
					},
					onBeforeClose : function() {
						// don't allow to scroll
						noScroll();
					},
					onAfterClose : function() {
						// can scroll again
						canScroll();
					}
					});
				});

		// for demo purposes only
		[].slice.call(document.querySelectorAll('form button')).forEach(
				function(bttn) {
					bttn.addEventListener('click', function(ev) {
						ev.preventDefault();
					});
				});
	})();
</script>
	<script src="js/TweenLite.min.js"></script>
	<script src="js/EasePack.min.js"></script>
	<script src="js/rAF.js"></script>
	<script src="js/demo-1.js"></script>

</f:view>
</body>
</html>