package nl.hu.to4.groep5.atd.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    
    public LogoutServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getSession().invalidate();
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
