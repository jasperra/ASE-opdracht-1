<%@page import="java.util.ArrayList"%>
<%@page import="nl.hu.to4.groep5.atd.web.domain.*"%>
<jsp:include page="header.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <% 
            Bedrijf b = (Bedrijf)getServletContext().getAttribute("hetBedrijf"); 
            ArrayList<Artikel> alleArtikelen = b.getAlleArtikelen();
        %>
        <form action = "VoorraadbeheerServlet.java" method = "post">
            <table border=1 cellpadding=5>
                <tr>
                  <th>Code</th>
                  <th>Type</th>
                  <th>Aantal</th>
                </tr>
                
                <% for(Artikel a : alleArtikelen) 
                    {
                    out.println("<tr>");
                         out.println("<td>" + a.getCode() + "</td>");
                         out.println("<td> " + a.getType()+ " </td>");
                         out.println( "<td> " + a.getAantal()+ "</td>");
                    out.println("</tr>");
                    }
                %>
                
            </table>
               
        </form>
    </body>
</html>
