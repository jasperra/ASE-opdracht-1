package nl.hu.to4.groep5.atd.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.hu.to4.groep5.atd.web.domain.Artikel;
import nl.hu.to4.groep5.atd.web.domain.Bedrijf;

@WebServlet("/ArtikelBewerken")
public class ArtikelBewerken extends HttpServlet {
    
    public ArtikelBewerken() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String aantal = request.getParameter("aantal");
        String code = request.getParameter("code");
        Bedrijf b = (Bedrijf)getServletContext().getAttribute("hetBedrijf"); 
        ArrayList<Artikel> alleArtikelen = b.getAlleArtikelen();
        
        String msg = null;
        Artikel art = new Artikel();
        RequestDispatcher rd = null;
        
        for(Artikel a: alleArtikelen){
            if(a.getCode().equals(code)){
                art = a;
                break;
            }
        }
        if(art == null)
            request.getRequestDispatcher("voorraadbeheer.jsp").forward(request, response);
        
        if(isInteger(aantal)){
            int nieuw = Integer.parseInt(aantal);
            if(nieuw >= 0){
                if(art!=null) {
                    art.setAantal(nieuw);
                }
                System.out.println("hoi extra test");
                rd = request.getRequestDispatcher("voorraadbeheer.jsp");
            } else {
                msg = "Er kan geen negatieve voorraad bestaan!";
                rd = request.getRequestDispatcher("ArtikelBewerken.jsp?Artikel=");
            }
        } else {
          msg = "U moet wel een geldig getal opgeven!";  
          rd = request.getRequestDispatcher("ArtikelBewerken.jsp?Artikel=");
        }
        
        request.setAttribute("msg", msg);
        rd.forward(request, response);
    }
    
    public static boolean isInteger(String str) {
	if (str == null) {
		return false;
	}
	int length = str.length();
	if (length == 0) {
		return false;
	}
	int i = 0;
	if (str.charAt(0) == '-') {
		if (length == 1) {
			return false;
		}
		i = 1;
	}
	for (; i < length; i++) {
		char c = str.charAt(i);
		if (c <= '/' || c >= ':') {
			return false;
		}
	}
	return true;
}
}
