<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form action = "NewMedewerkerServlet" method = "post">
                <div id = "messagebox">
                    <c:if test="${msgs != null}">
                        ${msgs}
                    </c:if>
                </div>
                <div id = "inputbox">
                    <h1>Medewerker Registreren</h1>
                    <input placeholder="ID" type="number"  name="id" required/><br />
                    <input placeholder="Gebruikersnaam" type="text" name="username" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{5,20}$" required/><br />
                    <input placeholder="Naam" type="text" name="rname" required/><br />
                    <input placeholder="Wachtwoord" type="password" name="password" pattern="(?=^.{5,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" required/>
                    Het wachtwoord moet uit minimaal 5 tekens bestaan.<br />
                    Minimaal 1 kleine letter,<br />
                    Minimaal 1 Hoofdletter,<br />
                    Minimaal 1 cijfer/(lees)teken.<br />
                    <input placeholder="Retype Wachtwoord" type="password" name="password2" pattern="(?=^.{5,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" required/><br />
                    <input placeholder="Emailadres" type="text" name="email" required/><br />
                    <input placeholder="Retype Emailadres" type="text" name="email2" required/><br />
                    <input placeholder="Telefoon-nummer" type="text" name="telnr" required/><br />
                    <input placeholder="Postcode" type="text" name="postcode" required/><br />
                    <input placeholder="Plaats" type="text" name="plaats" required/><br />
                    <select name="rol" required>
                        <option value="Admin">Admin</option>
                        <option value="Monteur" selected>Monteur</option>
                        <option value="Parkeerplaatsbeheerder">Parkeerplaatsbeheerder</option>
                    </select>
                    <input id = "submit" type = "submit" name = "knop" value = "Register!" />
                </div>
            </form>
        </div>
    </body>
</html>