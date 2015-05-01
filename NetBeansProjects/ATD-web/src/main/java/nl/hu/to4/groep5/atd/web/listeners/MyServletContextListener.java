/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep5.atd.web.listeners;

import nl.hu.to4.groep5.atd.web.domain.*;
import java.io.*;
import javax.servlet.*;

/**
 *
 * @author Roger
 */
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        Bedrijf b = null;
        
        System.out.println("\n" + "\n" + "\n" + "STARTING  ADFSDASFLJADFS" + "\n" + "\n" + "\n");
        
        try
        {
            File f = new File("/hetBedrijf.obj");
            System.out.println("-");
            System.out.println("-");
            System.out.println(f.getAbsoluteFile());
            System.out.println("-");
            System.out.println("-");
            FileInputStream fis = new FileInputStream("/hetBedrijf.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            b = (Bedrijf) obj;
            ois.close();
        }
        catch(IOException ioe){
            b = new Bedrijf();
            System.out.println("-");
            System.out.println("-");
            System.out.println("IN DE CATCH");
            System.out.println("-");
            System.out.println("-");
        } 
        catch (ClassNotFoundException cnfe) {   }
      
        sc.setAttribute("hetBedrijf", b);
        
    }
    public void contextDestroyed(ServletContextEvent sce) {
        
        Object hetBedrijf = sce.getServletContext().getAttribute("hetBedrijf");
        try {
            FileOutputStream fos = new FileOutputStream("/hetBedrijf.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hetBedrijf);
            oos.close(); 
        } catch (IOException ioe) {  }
    }
    
}
