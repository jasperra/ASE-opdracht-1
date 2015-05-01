package nl.hu.to4.groep5.atd.web.controllers;
import nl.hu.to4.groep5.atd.web.domain.*;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VoorraadbeheerServlet")
public class VoorraadbeheerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    

    public VoorraadbeheerServlet() { super(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        String code = request.getParameter("code");
        String type = request.getParameter("type");
        String aantal = request.getParameter("aantal");
       
        
        RequestDispatcher rd = null;

       
        rd.forward(request, response);
    }
}