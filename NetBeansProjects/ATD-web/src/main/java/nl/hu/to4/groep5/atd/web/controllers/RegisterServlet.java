package nl.hu.to4.groep5.atd.web.controllers;
import nl.hu.to4.groep5.atd.web.domain.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    

    public RegisterServlet() { super(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        boolean registerSucces = false;
        
        String name = request.getParameter("username");
        String realname = request.getParameter("rname");
        String pass = request.getParameter("password");
        String pass2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String email2 = request.getParameter("email2");
        String telnr = request.getParameter("telnr");
        String postcode = request.getParameter("postcode");
        String plaats = request.getParameter("plaats");
        String herinnering = request.getParameter("wiltHer");
        Boolean wiltHer = false;
        if(herinnering == null){
            wiltHer = false;
        }
        else if(herinnering.equals("on")){
            wiltHer = true;
        }

        Object hetBedrijf = getServletContext().getAttribute("hetBedrijf");
        if(hetBedrijf != null){
            Bedrijf b = (Bedrijf)hetBedrijf;
            
            if (!name.equals("") && !realname.equals("") && !pass.equals("") && !pass2.equals("") && !email.equals("")&& !email2.equals("")&& !telnr.equals("")&& !postcode.equals("")&& !plaats.equals(""))  {
                if (email.equals(email2))
                {
                    if ((pass.equals(pass2))) 
                    {
                       if(!b.heeftMedewerker(name) && !b.heeftKlant(name)){
                                registerSucces = true;
                            } else {
                               request.setAttribute("msgs", "Username is al in gebruik"); 
                            }
                    }
                    else
                    {
                       request.setAttribute("msgs", "Password information does not match"); 
                    }
                }
                else
                {
                    request.setAttribute("msgs", "Email information does not match");
                }
            }
            else
            {
                request.setAttribute("msgs", "Please fill in all information");
            }
        
            RequestDispatcher rd = null;

            if (registerSucces) {
                System.out.println("Succes, Started Registering");

                Klant k = new Klant(name,realname,pass,telnr,postcode,plaats,email,wiltHer);
                b.voegKlantToe(k);
                getServletContext().setAttribute("hetBedrijf",b);
                System.out.println("Done Registering");



                rd = request.getRequestDispatcher("index.jsp");
            }
            else {
            rd = request.getRequestDispatcher("registratie.jsp");
            }
            rd.forward(request, response);
        }
    }
}