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
        if(herinnering.equals("on")){
            wiltHer = true;
        }

        if (!name.equals("") && !realname.equals("") && !pass.equals("") && !pass2.equals("") && !email.equals("")&& !email2.equals("")&& !telnr.equals("")&& !postcode.equals("")&& !plaats.equals("")  && !name.equals("admin"))  {
            if (email.equals(email2))
            {
                if ((pass.equals(pass2))) 
                {
                   registerSucces = true;
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
                      
            //Klant aan list toevoegen??????
            
            Klant k = new Klant(name,realname,pass,telnr,postcode,plaats,email, true);
            
            
            
            rd = request.getRequestDispatcher("index.jsp");
        }
        else {
        rd = request.getRequestDispatcher("registratie.jsp");
        }
        rd.forward(request, response);
    }
}