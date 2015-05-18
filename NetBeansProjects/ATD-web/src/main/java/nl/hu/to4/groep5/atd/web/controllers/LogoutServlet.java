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
            if(cookies != null){
                for(int i = 0; i < cookies.length; i++){
                    if(cookies[i].getName().equals("user")){
                        loginCookie = cookies[i];
                        break;
                    }
                }
            }
        }
        if(loginCookie != null){
            loginCookie.setMaxAge(0);
            response.addCookie(loginCookie);
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        System.out.println("Logincookie = null");
    }
}