package nl.hu.to4.groep5.atd.web.controllers;
import nl.hu.to4.groep5.atd.web.domain.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/ProfileEditServlet")
public class ProfileEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ProfileEditServlet() { super(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        boolean editSucces = false;
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String postcd = request.getParameter("postcode");
        String plaats = request.getParameter("plaats");
        String telnr = request.getParameter("telnr");
        
        String o_pass = request.getParameter("o_pass");
        String n_pass_1 = request.getParameter("n_pass_1");
        String n_pass_2 = request.getParameter("n_pass_2");
        String herinnering = request.getParameter("wiltHer");
        Boolean wiltHer = false;
        if(herinnering == null){
            wiltHer = false;
            System.out.println("her = false");
        }
        else if(herinnering.equals("on")){
            wiltHer = true;
            System.out.println("her = true");
        }
        
        
        RequestDispatcher rd = null;
        
        if (!name.equals("") && !name.equals(".admin.sort.of.") && !email.equals("") && !postcd.equals("") && !plaats.equals("") && !telnr.equals("") ) {
            if ((n_pass_1.equals(n_pass_2))) {
               editSucces = true;
               System.out.println("editSucces = true");
            }
            else {
               request.setAttribute("msgs", "Passwords do not match");
               System.out.println("Passwords dont match");
            }
        }
        else {
            request.setAttribute("msgs", "Please fill in all information");
            System.out.println("niet alles ingevuld");
        }

        if (editSucces) {
            Object hetBedrijf = getServletContext().getAttribute("hetBedrijf");
            if(hetBedrijf != null){
                Bedrijf b = (Bedrijf)hetBedrijf;
                for(Klant k : b.getAlleKlanten()){
                    System.out.println("doorzoeken van de klanten");
                    if(k.getUsername().equals(username)){
                        System.out.println("Klant gevonden");
                        k.setNaam(name);
                            System.out.println(k.getNaam());
                        k.setEmailadres(email);
                            System.out.println(k.getEmailadres());
                        k.setPostcode(postcd);
                            System.out.println(k.getPostcode());
                        k.setPlaats(plaats);
                            System.out.println(k.getPlaats());
                        k.setTelefoonnummer(telnr);
                            System.out.println(k.getTelefoonnummer());
                        k.setWiltHerinnering(true);
                            System.out.println("" + k.getWiltHerinnering());
                        if(!o_pass.equals("") && !n_pass_1.equals("") && !n_pass_2.equals("")){
                            if(n_pass_2.equals(n_pass_1)){
                                if(k.login(o_pass)){
                                    k.setWachtwoord(n_pass_1);
                                    System.out.println(k.getWachtwoord());
                                }
                                else{
                                    request.setAttribute("msgs", "Wrong password");
                                }
                            }else{
                                request.setAttribute("msgs", "New Passwords do not match");
                            }
                        }
                        break;
                    }
                }
                for(Medewerker m : b.getAlleMedewerkers()){
                    System.out.println("doorzoeken van de medewerkers");
                    if(m.getUsername().equals(username)){
                        System.out.println("medewerkers gevonden");
                        m.setNaam(name);
                            System.out.println(m.getNaam());
                        m.setEmailadres(email);
                            System.out.println(m.getEmailadres());
                        m.setPostcode(postcd);
                            System.out.println(m.getPostcode());
                        m.setPlaats(plaats);
                            System.out.println(m.getPlaats());
                        m.setTelefoonnummer(telnr);
                            System.out.println(m.getTelefoonnummer());

                        if(!o_pass.equals("") && !n_pass_1.equals("") && !n_pass_2.equals("")){
                            if(n_pass_2.equals(n_pass_1)){
                                if(m.login(o_pass)){
                                    m.setWachtwoord(n_pass_1);
                                    System.out.println(m.getWachtwoord());
                                }
                                else{
                                    request.setAttribute("msgs", "Wrong password");
                                }
                            }else{
                                request.setAttribute("msgs", "New Passwords do not match");
                            }
                        }
                        break;
                    }
                }
                getServletContext().setAttribute("hetBedrijf",b);
                request.setAttribute("msgs", "Done");
            }
            
            
            rd = request.getRequestDispatcher("profiel.jsp");
        }
        else {
        rd = request.getRequestDispatcher("profiel.jsp");
        }
        rd.forward(request, response);
    }
}