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
                    if(k.getUsername().equals(username)){
                        k.setNaam(name);
                        k.setEmailadres(email);
                        k.setPostcode(postcd);
                        k.setPlaats(plaats);
                        k.setTelefoonnummer(telnr);
                        
                        if(!o_pass.equals("") && !n_pass_1.equals("") && !n_pass_2.equals("") && n_pass_1.equals(n_pass_2)){
                            if(k.login(o_pass)){
                                k.setWachtwoord(n_pass_1);
                            }
                            else{
                                request.setAttribute("msgs", "Wrong password");
                            }
                        }   
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