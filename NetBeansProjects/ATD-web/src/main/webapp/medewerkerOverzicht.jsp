<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="nl.hu.to4.groep5.atd.web.domain.*"%>
<jsp:include page="header.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <form action = "" method = "post">
            <table border=1 cellpadding=1>
                <tr>
                    <th>ID</th>
                    <th>Rol</th>
                    <th>Username</th>
                    <th>Naam</th>
                    <th>Wachtwoord</th>
                    <th>Telefoonnummer</th>
                    <th>Postcode</th>
                    <th>Plaats</th>   
                    <th>Emailadres</th>
                </tr>
                
                <c:forEach var="m" items="${hetBedrijf.alleMedewerkers}">                                            
                    <tr>
                        <td>${m.ID}</td>
                        <td>${m.rol}</td>
                        <td>${m.username}</td>
                        <td>${m.naam}</td>
                        <td>${m.wachtwoord}</td>
                        <td>${m.telefoonnummer}</td>
                        <td>${m.postcode}</td>
                        <td>${m.plaats}</td>
                        <td>${m.emailadres}</td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
