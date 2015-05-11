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
        boolean registerSucces = false;
        
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String postcd = request.getParameter("postcode");
        String plaats = request.getParameter("plaats");
        String telnr = request.getParameter("telnr");
        
        String o_pass = request.getParameter("o_pass");
        String n_pass_1 = request.getParameter("n_pass_1");
        String n_pass_2 = request.getParameter("n_pass_2");

        if (!name.equals("") && !name.equals("admin")) {
            if ((n_pass_1.equals(n_pass_2))) {
               registerSucces = true;
            }
            else {
               request.setAttribute("msgs", "Password information does not match"); 
            }
        }
        else {
            request.setAttribute("msgs", "Please fill in all information");
        }
        RequestDispatcher rd = null;

        if (registerSucces) {
            System.out.println("Succes, Started Registering");
            
            
            Object hetBedrijf = getServletContext().getAttribute("hetBedrijf");
            if(hetBedrijf != null){
                Bedrijf b = (Bedrijf)hetBedrijf;
                
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