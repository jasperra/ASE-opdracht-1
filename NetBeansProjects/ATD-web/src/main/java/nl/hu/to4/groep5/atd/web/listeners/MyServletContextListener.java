/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates.
 * and open the template in the editor.
 */
package nl.hu.to4.groep5.atd.web.listeners;

import nl.hu.to4.groep5.atd.web.domain.*;
import java.io.*;
import java.util.logging.Logger;
import javax.servlet.*;

/**
 *
 * @author Roger
 */
public class MyServletContextListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(MyServletContextListener.class.getName());
    
    

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        Bedrijf b = null;
        
        try
        {
            LOG.fine("Launching");
            System.out.println("-");
            System.out.println("-");
            System.out.println("LAUNCHING --------------------------- IN DE TRY");
            System.out.println("-");
            System.out.println("-");
            FileInputStream fis = new FileInputStream("C:\\tempTest\\hetBedrijf.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            b = (Bedrijf) obj;
            ois.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            b = new Bedrijf();
            Medewerker m = new Medewerker(0,"admin","admin","admin","admin","admin","admin","admin","admin@atd.nl");
            b.voegMedewerkerToe(m);
            System.out.println("-");
            System.out.println("-");
            System.out.println("LAUNCHING --------------------------- IN DE CATCH");
            System.out.println("-");
            System.out.println("-");
        } 
        catch (ClassNotFoundException cnfe) {   }
      
        sc.setAttribute("hetBedrijf", b);
    }
    public void contextDestroyed(ServletContextEvent sce) {
        
        System.out.println("-");
        System.out.println("-");
        System.out.println("In Destroy");
        System.out.println("-");
        System.out.println("-");
        Object hetBedrijf = sce.getServletContext().getAttribute("hetBedrijf");
        try {
            System.out.println("-");
            System.out.println("-");
            System.out.println("IN DE TRY 2");
            System.out.println("-");
            System.out.println("-");
            FileOutputStream fos = new FileOutputStream("C:\\tempTest\\hetBedrijf.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hetBedrijf);
            oos.close(); 
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("-");
            System.out.println("-");
            System.out.println("IN DE CATCH 2");
            System.out.println("-");
            System.out.println("-");
        }
    }
}