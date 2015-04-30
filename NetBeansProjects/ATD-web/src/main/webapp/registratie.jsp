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
                    öUsername:<input  class = "ltf" type = "text" name = "username" /><br />
                    Real name:<input class = "ltf" type = "text" name = "rname" /><br />
                    Password:<input class = "ltf" type = "password" name = "password" /><br />
                    Retype Password:<input class = "ltf" type = "password" name = "password2" /><br />
                    Email:<input class = "ltf" type = "text" name = "email" /><br />
                    Retype Email:<input class = "ltf" type = "text" name = "email2" /><br />
                    Adres:<input class = "ltf" type = "text" name = "adres" /><br />
                    Country:<select name ="country">
                        <option value ="" selected>Please select Country</option>
                        <option value ="Nederland">Nederland</option>
                        <option value ="Belgie">Belgie</option>
                    </select><br/>
                    <input id = "submit" type = "submit" name = "knop" value = "Register!" />
                </div>
            </form>
        </div>
    </body>
</html>
