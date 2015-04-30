/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep5.atd.web.listeners;

import nl.hu.to4.groep5.atd.web.domain.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.servlet.*;

/**
 *
 * @author Roger
 */
public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        Bedrijf b = new Bedrijf();
        
        ArrayList<Klant> alleKlanten = null;
	ArrayList<Factuur> alleFacturen = null;
	ArrayList<Dienst> alleDiensten = null;
	ArrayList<Artikel> alleArtikelen = null;
	ArrayList<Monteur> alleMonteurs = null;
	ArrayList<Auto> alleAutos = null;
        
        try
        {
            FileInputStream fis = new FileInputStream("/alleKlanten.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            alleKlanten = (ArrayList<Klant>)obj;
            ois.close();
        }
        catch(IOException ioe){
            alleKlanten = new ArrayList<Klant>();
            Klant k = new Klant("admin", "admin", "admin", "admin", "admin", "admin", false);
            alleKlanten.add(k);
        } 
        catch (ClassNotFoundException cnfe) {   }
      
        sc.setAttribute("alleKlanten", alleKlanten);
        
        try
        {
            FileInputStream fis = new FileInputStream("/alleFacturen.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            alleFacturen = (ArrayList<Factuur>)obj;
            ois.close();
        }
        catch(IOException ioe){
            alleFacturen = new ArrayList<Factuur>();
            
        } 
        catch (ClassNotFoundException cnfe) {   }
      
        sc.setAttribute("alleFacturen", alleFacturen);
        
        try
        {
            FileInputStream fis = new FileInputStream("/alleDiensten.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            alleDiensten = (ArrayList<Dienst>)obj;
            ois.close();
        }
        catch(IOException ioe){
            alleDiensten = new ArrayList<Dienst>();
        } 
        catch (ClassNotFoundException cnfe) {   }
      
        sc.setAttribute("alleDiensten", alleDiensten);
        
        try
        {
            FileInputStream fis = new FileInputStream("/alleArtikelen.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            alleArtikelen = (ArrayList<Artikel>)obj;
            ois.close();
        }
        catch(IOException ioe){
            alleArtikelen = new ArrayList<Artikel>();
        } 
        catch (ClassNotFoundException cnfe) {   }
      
        sc.setAttribute("alleArtikelen", alleArtikelen);
        
        try
        {
            FileInputStream fis = new FileInputStream("/alleMonteurs.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            alleMonteurs = (ArrayList<Monteur>)obj;
            ois.close();
        }
        catch(IOException ioe){
            alleMonteurs = new ArrayList<Monteur>();
        } 
        catch (ClassNotFoundException cnfe) {   }
      
        sc.setAttribute("alleMonteurs", alleMonteurs);
        
        try
        {
            FileInputStream fis = new FileInputStream("/alleAutos.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            alleAutos = (ArrayList<Auto>)obj;
            ois.close();
        }
        catch(IOException ioe){
            alleAutos = new ArrayList<Auto>();
        } 
        catch (ClassNotFoundException cnfe) {   }
      
        sc.setAttribute("alleAutos", alleAutos);
        
    }
    public void contextDestroyed(ServletContextEvent sce) {
        
        Object klantlist = sce.getServletContext().getAttribute("alleKlanten");
        try {
        FileOutputStream fos = new FileOutputStream("/alleKlanten.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(klantlist);
        oos.close(); 
        } catch (IOException ioe) {  }
        
        Object factuurlist = sce.getServletContext().getAttribute("alleFacturen");
        try {
        FileOutputStream fos = new FileOutputStream("/alleFacturen.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(factuurlist);
        oos.close(); 
        } catch (IOException ioe) {  }
        
        Object dienstlist = sce.getServletContext().getAttribute("alleDiensten");
        try {
        FileOutputStream fos = new FileOutputStream("/alleDiensten.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(dienstlist);
        oos.close(); 
        } catch (IOException ioe) {  }
        
        Object artikellist = sce.getServletContext().getAttribute("alleArtikelen");
        try {
        FileOutputStream fos = new FileOutputStream("/alleArtikelen.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(artikellist);
        oos.close(); 
        } catch (IOException ioe) {  }
        
        Object monteurlist = sce.getServletContext().getAttribute("alleMonteurs");
        try {
        FileOutputStream fos = new FileOutputStream("/alleMonteurs.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(monteurlist);
        oos.close(); 
        } catch (IOException ioe) {  }
        
        Object autolist = sce.getServletContext().getAttribute("alleAutos");
        try {
        FileOutputStream fos = new FileOutputStream("alleAutos.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(autolist);
        oos.close(); 
        } catch (IOException ioe) {  }
    }
    
}
