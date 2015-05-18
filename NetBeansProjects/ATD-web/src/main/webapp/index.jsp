            <jsp:include page="header.jsp" />
            <h1>ATD webservice</h1>
            <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sollicitudin felis quis mi tincidunt egestas. Aliquam hendrerit gravida convallis. Sed vel laoreet ex. Sed rutrum ultrices nunc. Integer elit justo, consectetur vel metus ut, hendrerit malesuada dui. Fusce urna orci, pretium sed euismod sed, mollis et purus. Pellentesque egestas ligula sit amet mi lacinia pharetra. Vivamus vel ipsum ultrices, pharetra nisl quis, accumsan dui. Sed imperdiet lorem quis ex venenatis, et malesuada nisi volutpat. Praesent posuere augue sit amet sodales dignissim. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum libero nulla, bibendum vel auctor non, posuere sit amet metus. Fusce vitae finibus velit. Cras ultrices ipsum sed pellentesque laoreet. In scelerisque varius eros at semper.</span>
            <h3>Klanten</h3>
            <%@page import="nl.hu.to4.groep5.atd.web.domain.*" %>
        <%
            Object hetBedrijf = getServletContext().getAttribute("hetBedrijf");
            if(hetBedrijf != null){
                Bedrijf b = (Bedrijf)hetBedrijf;
                for(Klant k : b.getAlleKlanten()){
                    out.println("<p>" + k.getUsername() + "-");
                    out.println(k.getNaam() + "</p>");
                    System.out.println(k.getUsername());
                }
            } else{out.println("<p>Er is geen bedrijf??</p>");
                    System.out.println("Geen bedrijf");}
        %>
            <h3>aanmelden</h3>
            <span>heb jij je nog niet aangemeld voor deze awesome site dan moet je dat zeker 
                hieronder op aanmelden klikken! meld je vandaag nog aan of betaal morgen nog minder.</span>
            <form action='registratie.jsp' method='post'><input id="button" type='submit' name='register' value='aanmelden' /></form>
            </div>
        </div>
    </body>
</html>
