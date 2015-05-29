package nl.hu.to4.groep5.atd.web.controllers;
import nl.hu.to4.groep5.atd.web.domain.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/NewMedewerkerServlet")
public class NewMedewerkerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    

    public NewMedewerkerServlet() { super(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        boolean registerSucces = false;
        
        String ID = request.getParameter("id");
        int id = Integer.parseInt(ID);
        String name = request.getParameter("username");
        String realname = request.getParameter("rname");
        String pass = request.getParameter("password");
        String pass2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String email2 = request.getParameter("email2");
        String telnr = request.getParameter("telnr");
        String postcode = request.getParameter("postcode");
        String plaats = request.getParameter("plaats");
        String rol = request.getParameter("rol");

        Object hetBedrijf = getServletContext().getAttribute("hetBedrijf");
        Bedrijf b = null;
        if(hetBedrijf != null){
            b = (Bedrijf)hetBedrijf;

            if (!name.equals("") && !realname.equals("") && !pass.equals("") && !pass2.equals("") && !email.equals("")&& !email2.equals("")&& !telnr.equals("")&& !postcode.equals("")&& !plaats.equals("") && !rol.equals(""))  {
                if (email.equals(email2))
                {
                    if ((pass.equals(pass2))) 
                    {
                        if(!b.heeftMedewerker(name) && !b.heeftKlant(name)){
                            if(id > 0 && !b.heeftMedewerkerId(id)){
                               registerSucces = true;
                            } else {
                                request.setAttribute("msgs", "ID wordt al gebruikt"); 
                            }
                        } else {
                           request.setAttribute("msgs", "Username is al in gebruik"); 
                        }
                    } else {
                       request.setAttribute("msgs", "Password information does not match"); 
                    }
                } else {
                    request.setAttribute("msgs", "Email information does not match");
                }
            } else {
                request.setAttribute("msgs", "Please fill in all information");
            }
        }
        
        
        
        RequestDispatcher rd = null;
        if (registerSucces) {
            System.out.println("Succes, Started Registering");
            
            Medewerker m = new Medewerker(id,rol,name,realname,pass,telnr,postcode,plaats,email);
            if(b != null){
                b.voegMedewerkerToe(m);
                getServletContext().setAttribute("hetBedrijf",b);
                System.out.println("Done Registering");
            }
            rd = request.getRequestDispatcher("index.jsp");
        } else {
            rd = request.getRequestDispatcher("newMedewerker.jsp");
        }
        rd.forward(request, response);
    }
}