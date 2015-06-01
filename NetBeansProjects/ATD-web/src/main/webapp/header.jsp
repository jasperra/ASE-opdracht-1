<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href ="css/Stylesheet.css" rel="stylesheet" type="text/css" />
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        
        <link href='http://fonts.googleapis.com/css?family=Varela+Round|Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
        <script src="javascript/script.js" ></script>
        <title>ATD web</title>
       

    </head>
<body>
    <a href="index.jsp"><div id="bannerContainer"></div></a>
    <div id="container">
        <div id="menu">
            <ul>
                <c:if test="${ingelogdeUser.getClass().name == 'nl.hu.to4.groep5.atd.web.domain.Medewerker'}">
                    <li><div><a href="voorraadbeheer.jsp">Voorraad beheer</a></div></li>
                    <li><div><a>Agenda</a></div></li>
                    <li><div><a>Facturen</a></div></li>
                    <li><div><a href="klantenOverzicht.jsp">Klanten</a></div></li>
                    <li><div><a href="medewerkerOverzicht.jsp">Medewerkers</a></div></li>
                    <li><div><a href="newMedewerker.jsp">Medewerker Registreren</a></div></li>
                    <li><div><a>Parkeren</a></div></li>
                </c:if>
                
                <c:if test="${ingelogdeUser == null}">
                    <li><div><a href="#" onclick="toggle_visibility('overlay')">Inloggen</a></div></li>
                    <li><div><a href='registratie.jsp'>Registreren</a></div></li>
                </c:if>
                
                <c:if test="${ingelogdeUser != null}">
                    <li><form action='LogoutServlet' method='POST'><input class='loginButton' type='submit' name='submit' value='Afmelden' /></form></li>
                </c:if>
                
            </ul>
        </div>
        <div id="overlay" class="overlay" style="display: none;">
            <div class="login-wrapper">
                <div class="login-content">
                    <a class="close" href="#" onclick="toggle_visibility('overlay');">x</a>
                    <h3>Inloggen</h3>
                    <form action="LoginServlet" method="POST">
                        <label for="username">
                        Gebruikersnaam:
                        <input id="username" class="login" type="text" name="username" placeholder="Gebruikersnaam" value="<c:forEach items="${cookie}" var="currentCookie"><c:if test="${currentCookie.value.name == 'user'}" ><c:out value="${currentCookie.value.value}"/></c:if></c:forEach>"  REQUIRED/>
                        </label>
                        <label for="password">
                        Wachtwoord: 
                        <input id="password" class="login" type="password" name="password" placeholder="Wachtwoord" value="" REQUIRED/>
                        </label>
                        <label for="rememberMe">Remember me: <input id="rememberMe" class="RememberMe" type="checkbox" name="remember me" value="" /></label>
                        <input class="loginButton" type="submit" name="submit" value="inloggen" />
                    </form>
                </div>
            </div>
        </div>
        <div id="inhoud">
            
        
