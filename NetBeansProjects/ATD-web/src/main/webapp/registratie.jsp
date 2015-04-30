<%-- 
    Document   : registratie
    Created on : 30-apr-2015, 13:25:25
    Author     : Tristan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registreren</title>
        <style>
            input{
                display: block;
                margin-left: 30px;
            }
            #submit{
                display: inline;
                margin-left: 0px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div id = "account">
            <form action = "RegisterServlet" method = "post">
                <div id = "messagebox">
                    <%
                        Object obj = request.getAttribute("msgs");
                        if (obj != null) {
                            out.println(obj);
                        }
                    %>
                </div>
                <div id = "inputbox">
                    <h1>Registreren</h1>
                    <input placeholder="Gebruikersnaam" type="text" name="username" required/><br />
                    <input placeholder="Naam" type="text" name="rname" required/><br />
                    <input placeholder="Wachtwoord" type="password" name="password" required/><br />
                    <input placeholder="Retype Wachtwoord" type="password" name="password2" required/><br />
                    <input placeholder="Emailadres" type="text" name="email" required/><br />
                    <input placeholder="Retype Emailadres" type="text" name="email2" required/><br />
                    <input placeholder="Telefoon-nummer" type="text" name="telnr" required/><br />
                    <input placeholder="Postcode" type="text" name="postcode" required/><br />
                    <input placeholder="Plaats" type="text" name="plaats" required/><br />
                    <input type="checkbox" name="wiltHer" required/><br />
                    <input id = "submit" type = "submit" name = "knop" value = "Register!" />
                </div>
            </form>
        </div>
    </body>
</html>