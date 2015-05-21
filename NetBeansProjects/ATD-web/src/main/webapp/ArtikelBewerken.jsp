<<%@page import="java.util.ArrayList"%>
<%@page import="nl.hu.to4.groep5.atd.web.domain.*"%>
<jsp:include page="header.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <% 
            Bedrijf b = (Bedrijf)getServletContext().getAttribute("hetBedrijf"); 
            ArrayList<Artikel> alleArtikelen = b.getAlleArtikelen();
            String artikelNaam = request.getParameter("Artikel");
            String msg = request.getParameter("msg");
            Artikel art = null;
            
            if(artikelNaam != null){
                for(Artikel a: alleArtikelen){
                    if(a.getCode().equals(artikelNaam)){
                        art = a;
                        break;
                    }
                }
            }else{
                request.getRequestDispatcher("voorraadbeheer.jsp").forward(request, response);
            }
            if(art == null){
                request.getRequestDispatcher("voorraadbeheer.jsp").forward(request, response);
            }
            
            if(msg != null){
                out.println("<h2>" + msg + "</h2>");
            }
        %>
        <form method="POST" action="ArtikelBewerken">
            <table>
                <tr>
                    <td>Code</td>
                    <td>Artikel type</td>
                    <td>Prijs</td>
                    <td>Aantal</td>
                </tr>
                <tr>
                    <td><input type="text" name="code" value="<% out.println(art.getCode()); %>" readonly /></td>
                    <td><input type="text" name="type" value="<% out.println(art.getType()); %>" readonly /></td>
                    <td><input type="text" name="prijs" value="<% out.println(art.getPrijs()); %>" readonly /></td>
                    <td><input type="text" name="aantal" value="<% out.println(art.getAantal()); %>" pattern="\d*" /></td>
                </tr>
            </table>
            <input type="submit" name="Aanpassen" value="Aanpassen" />
        </form>
    </body>
</html>
