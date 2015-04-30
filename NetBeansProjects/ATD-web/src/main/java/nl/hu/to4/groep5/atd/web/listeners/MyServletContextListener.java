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
        
        /*ArrayList<User> allUsers = null;
        try
        {
        FileInputStream fis = new FileInputStream("allUsers.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            allUsers = (ArrayList<User>)obj;
            ois.close();
        }
        catch(IOException ioe){
            allUsers = new ArrayList<User>();
            User u = new User("admin", "admin");
            allUsers.add(u);
            System.out.println("catched");
        } 
        catch (ClassNotFoundException ex) {   }
      
        sc.setAttribute("allUsers", allUsers);*/
    }
    public void contextDestroyed(ServletContextEvent sce) {
        Object obj = sce.getServletContext().getAttribute("allUsers");
      
        try {
        FileOutputStream fos = new FileOutputStream("allUsers.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.close(); 
        } catch (IOException ioe) { ioe.printStackTrace(); }

    }
    
}
