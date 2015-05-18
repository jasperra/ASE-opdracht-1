package nl.hu.to4.groep5.atd.web.controllers;
import nl.hu.to4.groep5.atd.web.domain.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/ProfileDeleteServlet")
public class ProfileDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ProfileDeleteServlet() { super(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        boolean deleteSucces = false;
        String username = request.getParameter("username");
        Klant deUser = null;
        Object hetBedrijf = getServletContext().getAttribute("hetBedrijf");
        Bedrijf b = null;
        RequestDispatcher rd = null;
        
        if(hetBedrijf != null){
            b = (Bedrijf)hetBedrijf;
            
            for(Klant k : b.getAlleKlanten()){
                System.out.println("doorzoeken van de klanten");
                if(k.getUsername().equals(username)){
                    System.out.println("Klant gevonden");
                    deUser = k;
                }
            }
        }
        if(deUser != null){
            /*
                Check of deUser openstaande facturen etc heeft.
            */
            deleteSucces = true;
            /*if(true){
                deleteSucces = true;
            } else{
                
                request.setAttribute("msgs", "Done");
                rd = request.getRequestDispatcher("profiel.jsp");
            }*/
        }
        if(deleteSucces = true && deUser != null && b != null){
            b.verwijderKlant(deUser);
            getServletContext().setAttribute("hetBedrijf",b);
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}