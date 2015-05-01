<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href ="css/Stylesheet.css" rel="stylesheet" type="text/css" />
        <title>ATD web</title>
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
    <div id="container">
        <div id="menu">
            <ul>
                <li><div><a>Voorraad beheer</a></div></li>
                <li><div><a>Agenda</a></div></li>
                <li><div><a>Facturen</a></div></li>
                <li><div><a>Klanten</a></div></li>
                <li><div><a>Parkeren</a></div></li></ul>
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
                        </form></div>
            
        </div>
        <div id="inhoud">
        