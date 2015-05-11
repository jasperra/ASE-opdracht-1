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
                function close(id){
                    var e = document.getElementById(id);
                    e.style.display = 'none';
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
                <li><div><a href="voorraadbeheer.jsp">Voorraad beheer</a></div></li>
                <li><div><a>Agenda</a></div></li>
                <li><div><a>Facturen</a></div></li>
                <li><div><a>Klanten</a></div></li>
                <li><div><a>Parkeren</a></div></li>
                <li><div><a href="#" onclick="toggle_visibility('overlay');">inloggen</a></div></li>
            </ul>
            <div class="login">
                <form action="LoginServlet" method="POST">
                    <input class="login" type="text" name="username" placeholder="Gebruikersnaam" value="<% 
                        if(myCookie != null){
                            out.println(myCookie.getValue());
                        }
                    %>" REQUIRED/>
                    <input class="login" type="password" name="password" placeholder="Wachtwoord" value="" REQUIRED/>
                    <label>remember me: </label><input class="RememberMe" type="checkbox" name="remember me" value="" />
                    <input class="loginButton" type="submit" name="submit" value="inloggen" />
                </form>
            </div>
        </div>
        <div id="inhoud">
            <div id="overlay" class="overlay" style="display: none;">
                <div class="login-wrapper">
                    <div class="login-content">
                        <a class="close" href="#" onclick="toggle_visibility('overlay');">x</a>
                        <h3>Sign in</h3>
                        <form action="LoginServlet" method="POST">
                            <label for="username">
                            Username:
                            <input id="username" class="login" type="text" name="username" placeholder="Gebruikersnaam" value="<% 
                                if(myCookie != null){
                                    out.println(myCookie.getValue());
                                }
                            %>" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{5,20}$" REQUIRED/>
                           </label>
                        <label for="password">
                            Password:
                            <input id="password" class="login" type="password" name="password" placeholder="Wachtwoord" value="" pattern="(?=^.{5,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" REQUIRED/>
                        </label>
                        <label>remember me: </label><input class="RememberMe" type="checkbox" name="remember me" value="" />
                        
                        <input class="loginButton" type="submit" name="submit" value="inloggen" />
                        </form>
                    </div>
                </div>
            </div>
        
