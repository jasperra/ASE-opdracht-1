<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="nl.hu.to4.groep5.atd.web.domain.*"%>
<jsp:include page="header.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <form action = "" method = "post">
            <table border=1 cellpadding=1>
                <tr>
                  <th>Username</th>
                  <th>Naam</th>
                  <th>Wachtwoord</th>
                  <th>Telefoonnummer</th>
                  <th>Postcode</th>
                  <th>Plaats</th>   
                  <th>Emailadres</th>
                </tr>
                
                <c:forEach var="k" items="${hetBedrijf.alleKlanten}">                                            
                    <tr>
                        <td>${k.username}</td>
                        <td>${k.naam}</td>
                        <td>${k.wachtwoord}</td>
                        <td>${k.telefoonnummer}</td>
                        <td>${k.postcode}</td>
                        <td>${k.plaats}</td>
                        <td>${k.emailadres}</td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
