package nl.hu.to4.groep5.atd.web.controllers;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.hu.to4.groep5.atd.web.domain.Artikel;
import nl.hu.to4.groep5.atd.web.domain.Bedrijf;

@WebServlet("/VoorraadbeheerServlet")
public class VoorraadbeheerServlet extends HttpServlet {

    public VoorraadbeheerServlet() { super(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Bedrijf b = (Bedrijf)getServletContext().getAttribute("hetBedrijf"); 
        ArrayList<Artikel> alleArtikelen = b.getAlleArtikelen();
        
        if(alleArtikelen != null){
            for(Artikel a: alleArtikelen){
                if(a.getAantal() < a.getMinimum()){
                    a.setAantal(a.getMinimum());
                }
            }
        }
        
        request.getRequestDispatcher("voorraadbeheer.jsp").forward(request, response);
    }
}