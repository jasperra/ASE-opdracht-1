<%-- 
    Document   : voorraadbeheer
    Created on : 1-mei-2015, 13:36:47
    Author     : Roger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "VoorraadbeheerServlet.java" method = "post">
            <table border=1 cellpadding=5>
                <tr>
                  <th>Code</th>
                  <th>Type</th>
                  <th>Aantal</th>
                </tr>
                
                <tr>
                    <%-- Hier komen de requests van de lijsten --%>
                    <td>Moer</td>
                    <td>A1</td>
                    <td>333</td>
                </tr>
            </table>
               
        </form>
    </body>
</html>
