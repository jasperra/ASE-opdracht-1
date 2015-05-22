<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href ="css/Stylesheet.css" rel="stylesheet" type="text/css" />
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Varela+Round|Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
        <script type="text/javascript">
            <!--
                function popup(){
                    cuteLittleWindow = window.open("aanpasSchermVoorraad.html", "littleWindow", "location=no,width=320,height=200"); 
                }
                
                function toggle_visibility(id) {
                    var e = document.getElementById(id);
                    if(e.style.display == 'block')
                        e.style.display = 'none';
                    else
                        e.style.display = 'block';
                    }
            //-->
        </script>
        <title>ATD web</title>
        <%@page import="nl.hu.to4.groep5.atd.web.domain.*" %>
        <%
            Cookie cookies[] = request.getCookies();
            Cookie myCookie = null;
            if(cookies != null){
                for(int i = 0; i < cookies.length; i++){
                    if(cookies[i].getName().equals("user")){
                        myCookie = cookies[i];
                        break;
                    }
                }
            }
        %>
    </head>
<body>
    <a href="index.jsp"><div id="bannerContainer"></div></a>
    <div id="container">
        <div id="menu">
            <ul>
                <%
                    if(request.getSession().getAttribute("ingelogdeUser") instanceof Medewerker){
                        out.println("<li><div><a href='voorraadbeheer.jsp'>Voorraad beheer</a></div></li>");
                        out.println("<li><div><a>Agenda</a></div></li>");
                        out.println("<li><div><a>Facturen</a></div></li>");
                        out.println("<li><div><a>Klanten</a></div></li>");
                        out.println("<li><div><a>Parkeren</a></div></li>");
                    }
                    else{
                        out.println("");
                    }
                %>
                <!--<li><div><a href="voorraadbeheer.jsp">Voorraad beheer</a></div></li>
                <li><div><a>Agenda</a></div></li>
                <li><div><a>Facturen</a></div></li>
                <li><div><a>Klanten</a></div></li>
                <li><div><a>Parkeren</a></div></li>-->
                
                <%
                    if(request.getSession().getAttribute("ingelogdeUser") == null){
                        out.println("<li><div><a href='#' onclick='toggle_visibility(\"overlay\");'>Inloggen</a></div></li>");
                        out.println("<li><div><a href='registratie.jsp'>Registreren</a></div></li>");
                    }
                    else{
                        out.println("<li><form action='LogoutServlet' method='POST'><input class='loginButton' type='submit' name='submit' value='Afmelden' /></form></li>");
                    }
                %>
                
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
                        <input id="username" class="login" type="text" name="username" placeholder="Gebruikersnaam" value="<% 
                            if(myCookie != null){
                                out.println(myCookie.getValue());
                            }
                        %>"  REQUIRED/>
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
            
        
