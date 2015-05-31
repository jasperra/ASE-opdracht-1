/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainTestsSprint2;

import nl.hu.to4.groep5.atd.web.domain.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tristan
 */
public class NewKlantTest {
    
    private static Bedrijf b = null;
    
    public NewKlantTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
        b = new Bedrijf();
    }
    
    @After
    public void tearDown() throws Exception {
        b = null;
    }

    //
    // TODO add test methods here.
    //
    
    @Test
    public void test1() throws Exception {
        Klant k = new Klant("TestKlant1","TestKlant1","TestWachtwoord","1234567890","1234-AB","Test","TestKlant1@test.com",true);
        
        k.setNaam("NewName");
        assertEquals("NewName",k.getNaam());
    }
    @Test
    public void test2() throws Exception {
        Klant k = new Klant("TestKlant1","TestKlant1","TestWachtwoord","1234567890","1234-AB","Test","TestKlant1@test.com",true);
        
        k.setUsername("NewUsername");
        assertEquals("NewUsername",k.getUsername());
    }
    @Test
    public void test3() throws Exception {
        Klant k = new Klant("TestKlant1","TestKlant1","TestWachtwoord","1234567890","1234-AB","Test","TestKlant1@test.com",true);
        
        k.setNaam("FalseName");
        assertEquals("NewName",k.getNaam());
    }
    @Test
    public void test4() throws Exception {
        Klant k = new Klant("TestKlant1","TestKlant1","TestWachtwoord","1234567890","1234-AB","Test","TestKlant1@test.com",true);
        
        k.setUsername("FalseUserName");
        assertEquals("NewName",k.getUsername());
    }
    @Test
    public void test5() throws Exception {
        Klant k = new Klant("TestKlant1","TestKlant1","TestWachtwoord","1234567890","1234-AB","Test","TestKlant1@test.com",true);
        
        k.setWachtwoord("NewPass");
        assertEquals("NewPass",k.getWachtwoord());
    }
    @Test
    public void test6() throws Exception {
        Klant k = new Klant("TestKlant1","TestKlant1","TestWachtwoord","1234567890","1234-AB","Test","TestKlant1@test.com",true);
        
        k.setNaam("FalsePass");
        assertEquals("NewPass",k.getWachtwoord());
    }
}
