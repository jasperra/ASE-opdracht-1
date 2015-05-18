package nl.hu.to4.groep5.atd.web.controllers;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
* Servlet implementation class MyAccount
*/
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    /**
    * @see HttpServlet#HttpServlet()
    */
    public LogoutServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        
        Cookie loginCookie = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    loginCookie = cookie;
                    break;
                }
            }
        }
        if(loginCookie != null){
            loginCookie = new Cookie("user", null);
            loginCookie.setMaxAge(0);
            loginCookie.setPath("/");
            response.addCookie(loginCookie);
            System.out.println("asdfuoas;djf");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        System.out.println("Logincookie = null");
    }
}