        <%@page import="nl.hu.to4.groep5.atd.web.domain.*" %>
        <jsp:include page="header.jsp" />
        <link href ="css/ProfileStylesheet.css" rel="stylesheet" type="text/css" />
        <%
            String username = "";
            String name = "";
            String email = "";
            String telnr = "";
            String postcd = "";
            String plaats = "";
            boolean wiltHer = false;
            boolean klant = true;
            
            
            Object hetBedrijf = getServletContext().getAttribute("hetBedrijf");
            Object deUser = request.getSession().getAttribute("ingelogdeUser");
            if(hetBedrijf != null && deUser != null){
                Bedrijf b = (Bedrijf)hetBedrijf;
                try{
                    Klant u = (Klant)deUser;
                    for(Klant k : b.getAlleKlanten()){
                        if(k.getUsername().equals(u.getUsername())){
                            username = k.getUsername();
                            name = k.getNaam();
                            email = k.getEmailadres();
                            telnr = k.getTelefoonnummer();
                            postcd = k.getPostcode();
                            plaats = k.getPlaats();
                            wiltHer = k.getWiltHerinnering();
                        }
                    }
                    klant = true;
                }catch(ClassCastException cce){
                    Medewerker mw = (Medewerker)deUser;
                    for(Medewerker m : b.getAlleMedewerkers()){
                        if(m.getUsername().equals(mw.getUsername())){
                            username = m.getUsername();
                            name = m.getNaam();
                            email = m.getEmailadres();
                            telnr = m.getTelefoonnummer();
                            postcd = m.getPostcode();
                            plaats = m.getPlaats();
                        }
                    }
                    klant = false;
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
                        <td>Gebruikersnaam:</td>
                        <td style="width: 75%;">
                            <input type="text" value="<%=username%>" name="username" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td>E-mail adres:</td>
                        <td>
                            <input type="text" value="<%=email%>" name="email" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Naam:</td>
                        <td>
                            <input type="text" value="<%=name%>" name="name" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Postcode:</td>
                        <td>
                            <input type="text" value="<%=postcd%>" name="postcode" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Plaats:</td>
                        <td>
                            <input type="text" value="<%=plaats%>" name="plaats" required/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Telefoon:</td>
                        <td>
                            <input type="text" name="telnr" value="<%=telnr%>" required/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <% if(klant == true){ %>
                        <tr>
                            <td>Wilt Herinnering?</td>
                            <td>
                                <% if(wiltHer == false){ System.out.println("wiltHer = false");
                                    out.println("<input type='checkbox' name='wiltHer' />");
                                } else if(wiltHer == true) { System.out.println("wiltHer = true");
                                    out.println("<input type='checkbox' name='wiltHer' checked/>");
                                } 
                                //Dit werkt nog niet helemaal, hij update de checkbox niet nadat op opslaan geklikt is
                                %> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br/>
                                <br/>
                            </td>
                        </tr>
                    <% } %>
                    <tr>
                        <td>
                            <b>Beveiliging:</b>
                        </td>
                        <td>(Alleen invullen als je het wilt wijzigen.)</td>
                    </tr>
                    <tr>
                        <td style="width: 25%;">Oud wachtwoord:</td>
                        <td style="width: 75%;">
                            <input type="password" name="o_pass" />
                        </td>
                    </tr>
                    <tr>
                        <td>Wachtwoord:</td>
                        <td>
                            <input type="password" name="n_pass_1" />
                        </td>
                    </tr>
                    <tr>
                        <td>Herhaal wachtwoord:</td>
                        <td>
                            <input type="password" name="n_pass_2" />
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
        <form id="deleteForm" action="ProfileDeleteServlet" method="POST">
            <div id = "messagebox">
                    <%
                        Object o = request.getAttribute("deletemessage");
                        if (obj != null) {
                            out.println(o);
                        }
                    %>
            </div>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td>Account verwijderen</td>
                        <td style="width: 75%;">
                            <input style="position:absolute;visibility: hidden; width: 0px; height: 0px;" type="text" value="<%=username%>" name="username">
                            Ja ik wil mijn account verwijderen<input type="checkbox" required/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" style="width:100%;" value="Verwijderen" name="submit_register" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
