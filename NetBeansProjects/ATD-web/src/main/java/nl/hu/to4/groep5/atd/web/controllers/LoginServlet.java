package nl.hu.to4.groep5.atd.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import nl.hu.to4.groep5.atd.web.domain.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    public LoginServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("remember me");
        boolean remember = false;
        ArrayList<Klant> alleKlanten = null;
        ArrayList<Medewerker> alleMedewerkers = null;
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        
        if(rememberMe != null){
            remember = true;
        }
        
        if(username != null && password != null){
            Object obj = getServletContext().getAttribute("hetBedrijf");
            
            if(obj != null){
                Bedrijf b = (Bedrijf) obj;
                System.out.println("bedrijf != null");
                alleKlanten = b.getAlleKlanten();
                alleMedewerkers = b.getAlleMedewerkers();
                
                for(Klant k: alleKlanten){
                    System.out.println("Klanten doorzoeken");
                    if(k.getUsername().equals(username)){
                        if(k.login(password)){
                            if(remember){
                                Cookie c = new Cookie("user", k.getUsername());
                                c.setMaxAge(365 * 24 * 60 * 60);
                                response.addCookie(c);
                            }
                            request.getSession().setAttribute("ingelogdeUser", k);
                            rd = request.getRequestDispatcher("profiel.jsp");
                        }
                        else{
                            rd = request.getRequestDispatcher("index.jsp");
                        }
                    }
                }
                for(Medewerker m: alleMedewerkers){
                    System.out.println("Medewerkers doorzoeken");
                    if(m.getUsername().equals(username)){
                        System.out.println(username);
                        System.out.println(m.getUsername());
                        System.out.println(password);
                        System.out.println(m.getWachtwoord());
                        if(m.login(password)){
                            System.out.println("Login succes");
                            if(remember){
                                Cookie c = new Cookie("user", m.getUsername());
                                c.setMaxAge(365 * 24 * 60 * 60);
                                response.addCookie(c);
                            }
                            request.getSession().setAttribute("ingelogdeUser", m);
                            rd = request.getRequestDispatcher("profiel.jsp");
                        }
                        else{
                            rd = request.getRequestDispatcher("index.jsp");
                        }
                    }
                }
            }
            else{
                rd = request.getRequestDispatcher("index.jsp");
            }
        }
        if(rd != null && request != null && response != null){
            System.out.println("geen nullpointers");
            rd.forward(request, response);
        }
    }
}
