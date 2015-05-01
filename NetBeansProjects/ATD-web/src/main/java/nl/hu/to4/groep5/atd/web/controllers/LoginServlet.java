package nl.hu.to4.groep5.atd.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.hu.to4.groep5.atd.web.domain.Klant;

public class LoginServlet extends HttpServlet {
    
    public LoginServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("remember me");
        boolean remember = false;
        ArrayList<Klant> alleUsers = null;
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        
        if(rememberMe != null){
            remember = true;
        }
        
        if(username != null && password != null){
            Object obj = getServletContext().getAttribute("hetBedrijf");
            
            if(obj != null){
                alleUsers = (ArrayList<Klant>) obj;
                
                for(Klant k: alleUsers){
                    if(k.getUsername().equals(username)){
                        
                        if(k.login(password)){

                            if(remember){
                                Cookie c = new Cookie("user", k.getUsername());
                                c.setMaxAge(365 * 24 * 60 * 60);
                                response.addCookie(c);
                            }
                            
                            request.getSession().setAttribute("ingelogdeUser", k);
                        }
                    }
                }
            }
            
        }
        rd.forward(request, response);
    }
}
