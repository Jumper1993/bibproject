<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Startseite</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/homepage.css">
<link rel="stylesheet" href="css/footer.css">
<script type="text/javascript" src="javascript/cookie.js"></script>
<script type="text/javascript" src="javascript/timer.js"></script>

</head>

<body onpageshow="cookieFunktion();timer()">

	<header >
		<div class="center">
			
			<div id="loginfeld">
				<c:choose>
				<c:when test="${empty lb.username}">
					<a href="jsp/login.jsp">Anmelden</a>
				</c:when>
				<c:otherwise>
								
				<ul>
					<li><a>${lb.username}</a>
						<ul>
							<li><a href="jsp/profileEditForm.jsp">Profil bearbeiten</a></li>
							<li><a href="/bibproject/logoutservlet">Logout</a></li>
						</ul>
					</li>
				</ul>	
				<img id="profilbild" src="img/keinBild.jpg" alt="Profilbild">
				
				</c:otherwise>
				</c:choose>
			</div>

			<a href="index.jsp">
				<img id="logo" src="img/logo.jpg" alt="Logo">
			</a>
			
			<hr>
			
			<nav>			
				<ul>
				<li><a href="index.jsp">Startseite</a></li>
				<li><a href="jsp/reserve.jsp">Reservieren</a></li>
				<li><a href="pdf/events.pdf">Termine</a></li>
				<li><a>Quicklinks</a>
					<ul>
						<li><a href="https://www3.primuss.de/stpl/login.php?FH=fhin&Lang=de">Stundenplan</a></li>
						<li><a href="https://www.thi.de/">Technische Hochschule</a></li>
						<li><a href="https://moodle.thi.de/moodle/">Moodle</a></li>
						<li><a href="https://print.thi.de">Drucken</a></li>
						<li><a href="https://exchange.thi.de">Webmail</a></li>
						<li><a href="https://idp1.thi.de/idp/profile/SAML2/Redirect/SSO;jsessionid=935F04F10D206BDCB915E1C9D954D28E?execution=e1s1">Primuss (Studierenden Portal)</a></li>
					</ul>
				</li>		
				</ul>			
			</nav>			
		</div>
	</header>	
	
	<div id="cookiebox">
		<p id="cookie">Aktivieren Sie ihre Cookies 
			<button type="button" id="cookiebutton" onclick="cookieButton()">Ok!</button>
		</p>
	</div>
	
	<main> 
		<img id="bild" src="img/startseite.jpg" alt="Bild">
		
		<h1>Herzlich Willkommen in unserer Bibliothek </h1>
		
		<section class="felder">
			<h2>Freie Plätze: ##</h2> 
		</section>
		<hr>

		<section class="felder">

			<h2 id="timer">Pr&uuml;fungszeitraum fängt in ### Tagen an!</h2>
			
		</section>
		<hr>
		<section class="felder">
			<h2>Aktuelle Termine</h2> 
			<p>
			<b>Pr&uuml;fungsanmeldung:</b> 07.11.2017 - 17.11.2017<br>
			<b>Vorlesungsfrei:</b> 23.12.2017 - 06.01.2018<br>
			<b>R&uuml;ckmeldung zum SS 2018:</b> 15.01.2018 - 25.01.2018 
		</p>
		</section>
				
	</main>
	
	
	<footer class="foot">
	<p>
		<a href="jsp/openingHours.jsp"> &Ouml;ffnungszeiten</a> |
		<a href="jsp/contact.jsp">Kontakt</a>	|
		<a href="jsp/legalNotice.jsp">Impressum</a>
	</p>
	</footer>


</body>
</html>