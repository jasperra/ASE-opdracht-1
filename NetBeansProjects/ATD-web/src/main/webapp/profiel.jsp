        <%@page import="nl.hu.to4.groep5.atd.web.domain.*" %>
        <jsp:include page="header.jsp" />
        <link href ="css/ProfileStylesheet.css" rel="stylesheet" type="text/css" />
        <%
            if(request.getSession().getAttribute("ingelogdeUser") != null){
                Klant u = (Klant)request.getSession().getAttribute("ingelogdeUser");
            }
            String username = "";
            String name = "";
            String email = "";
            String telnr = "";
            String postcd = "";
            String plaats = "";
            
            Object hetBedrijf = getServletContext().getAttribute("hetBedrijf");
            Object deUser = request.getSession().getAttribute("ingelogdeUser");
            if(hetBedrijf != null && deUser != null){
                Bedrijf b = (Bedrijf)hetBedrijf;
                Klant u = (Klant)deUser;
                for(Klant k : b.getAlleKlanten()){
                    if(k.getUsername().equals(u.getUsername())){
                        username = k.getUsername();
                        name = k.getNaam();
                        email = k.getEmailadres();
                        telnr = k.getTelefoonnummer();
                        postcd = k.getPostcode();
                        plaats = k.getPlaats();
                    }
                }
            }
            else{
                response.sendRedirect("index.jsp");
            }
        %>
        <h1>Je Profiel:</h1>
        <form id="profileForm" action="ProfileEditServlet" method="POST">
            <div id = "messagebox">
                    <%
                        Object obj = request.getAttribute("msgs");
                        if (obj != null) {
                            out.println(obj);
                        }
                    %>
            </div>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="width: 25%;">Gebruikersnaam:</td>
                        <td style="width: 75%;">
                            <input type="text" style="width:100%;" value="<%=username%>" name="username" disabled="" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>E-mail adres:</td>
                        <td>
                            <input type="text" style="width:100%;" value="<%=email%>" name="email" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Naam:</td>
                        <td>
                            <input type="text" style="width:100%;" value="<%=name%>" name="name" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Postcode:</td>
                        <td>
                            <input type="text" style="width:100%;" value="<%=postcd%>" name="postcode" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Plaats:</td>
                        <td>
                            <input type="text" style="width:100%;" value="<%=plaats%>" name="plaats" required/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Telefoon:</td>
                        <td>
                            <input type="text" style="width:100%;" name="telnr" value="<%=telnr%>" required/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            <b>Beveiliging:</b>
                        </td>
                        <td>(Alleen invullen als je het wilt wijzigen.)</td>
                    </tr>
                    <tr>
                        <td>Oud wachtwoord:</td>
                        <td>
                            <input type="password" style="width:100%;" name="o_pass" />
                        </td>
                    </tr>
                    <tr>
                        <td>Wachtwoord:</td>
                        <td>
                            <input type="password" style="width:100%;" name="n_pass_1" />
                        </td>
                    </tr>
                    <tr>
                        <td>Herhaal wachtwoord:</td>
                        <td>
                            <input type="password" style="width:100%;" name="n_pass_2" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" style="width:100%;" value="Opslaan" name="submit_register" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
