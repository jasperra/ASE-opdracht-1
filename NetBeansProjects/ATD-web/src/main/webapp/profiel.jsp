        <%@page import="nl.hu.to4.groep5.atd.web.domain.*" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="header.jsp" />
        <link href ="css/ProfileStylesheet.css" rel="stylesheet" type="text/css" />
        
        <h1>Je Profiel:</h1>
        <form id="profileForm" action="ProfileEditServlet" method="POST">
            <div id = "messagebox">
                <c:if test="${msgs != null}">
                    ${msgs}
                </c:if>
            </div>
            <table style="width: 100%;">
                <tbody>
                    <c:if test="${ingelogdeUser.getClass().name == 'nl.hu.to4.groep5.atd.web.domain.Medewerker'}">
                        <tr>
                            <td>ID</td>
                            <td style="width: 75%;">
                                <input type="text" value="${ingelogdeUser.ID}" name="ID" readonly/>
                            </td>
                        </tr>
                        <tr>
                            <td>Rol</td>
                            <td style="width: 75%;">
                                <input type="text" value="${ingelogdeUser.rol}" name="Rol" readonly/>
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>Gebruikersnaam:</td>
                        <td style="width: 75%;">
                            <input type="text" value="${ingelogdeUser.username}" name="username" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td>E-mail adres:</td>
                        <td>
                            <input type="text" value="${ingelogdeUser.emailadres}" name="email" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Naam:</td>
                        <td>
                            <input type="text" value="${ingelogdeUser.naam}" name="name" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Postcode:</td>
                        <td>
                            <input type="text" value="${ingelogdeUser.postcode}" name="postcode" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Plaats:</td>
                        <td>
                            <input type="text" value="${ingelogdeUser.plaats}" name="plaats" required/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Telefoon:</td>
                        <td>
                            <input type="text" value="${ingelogdeUser.telefoonnummer}" name="telnr" required/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <c:if test="${ingelogdeUser.getClass().name == 'Klant'}">
                        <tr>
                            <td>Wilt Herinnering?</td>
                            <td>
                                <c:if test="${ingelogdeUser.WiltHerinnering == false}">
                                    <input type='checkbox' name='wiltHer' />
                                </c:if>
                                <c:otherwise>
                                    <input type='checkbox' name='wiltHer' checked/>
                                </c:otherwise><!-- Werkt nog niet -->
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br/>
                                <br/>
                            </td>
                        </tr>
                    </c:if>
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
                <c:if test="${deletemessage != null}">
                    ${deletemessage}
                </c:if>
            </div>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td>Account verwijderen</td>
                        <td style="width: 75%;">
                            <input style="position:absolute;visibility: hidden; width: 0px; height: 0px;" type="text" value="" name="username">
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
