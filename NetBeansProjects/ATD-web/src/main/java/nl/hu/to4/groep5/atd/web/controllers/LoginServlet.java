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

        RequestDispatcher requestDispatcher;
        Bedrijf bedrijf = getBedrijfFromServletContext();
        Account user = bedrijf.getAccountByName(username);
        if(logUserIn(username, password, bedrijf)){
            setCookie(rememberMe, user, response);
            request.getSession().setAttribute("ingelogdeUser", user);
            requestDispatcher = request.getRequestDispatcher("profiel.jsp");
        }
        else{
            requestDispatcher = request.getRequestDispatcher("index.jsp");
        }

        if(requestDispatcher != null && request != null && response != null){
            requestDispatcher.forward(request, response);
        }
    }

    private boolean logUserIn(String username, String password, Bedrijf bedrijf){
        Account user = bedrijf.getAccountByName(username);
        if(user.login(password)){
            return true;
        }
        return false;
    }

    private Bedrijf getBedrijfFromServletContext(){
        return (Bedrijf) getServletContext().getAttribute("hetBedrijf");
    }

    private void setCookie(String rememberMe, Account account, HttpServletResponse response){
        if(rememberMe == null) return;
        Cookie c = new Cookie("user", account.getUsername());
        c.setMaxAge(365 * 24 * 60 * 60);
        response.addCookie(c);
    }
}
