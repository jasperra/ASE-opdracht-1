package hu.to4.groep5.atd.web.domain;

/*
 * Gemaakt door: Tristan en Roger
 */

import java.io.*;
import java.util.*;

public class Bedrijf implements Serializable{

	private String naam;
	private ArrayList<Klant> alleKlanten = new ArrayList<Klant>();
        private ArrayList<Medewerker> alleMedewerkers = new ArrayList<Medewerker>();
	private ArrayList<Account> alleAccounts = new ArrayList<Account>();
	private ArrayList<Factuur> alleFacturen = new ArrayList<Factuur>();
	private ArrayList<Dienst> alleDiensten = new ArrayList<Dienst>();
	private ParkeerPlaats deParkeerPlaats;
	private ArrayList<Artikel> alleArtikelen = new ArrayList<Artikel>();
        //private ArrayList<Monteur> alleMonteurs = new ArrayList<Monteur>();
	private ArrayList<Auto> alleAutos = new ArrayList<Auto>();
	
	
	public Bedrijf(){
		naam = "ATD Systeem";
		aanmaken();
	}


	private void aanmaken() { //hierin worden alle arraylists vast gevuld met wat testobjecten
            ArtikelType at1 = new ArtikelType("Moeren");
            ArtikelType at2 = new ArtikelType("Schroeven");
            ArtikelType at3 = new ArtikelType("Deuren");
            ArtikelType at4 = new ArtikelType("Auto-onderdelen");
            ArtikelType at5 = new ArtikelType("Brandstof");

        addNewArtikel("Moer 1",200,100,1.50,at1);
        addNewArtikel("Moer 2",200,100,1.28,at1);
        addNewArtikel("Schroef 1",200,100,1.78,at2);
        addNewArtikel("Schroef 2",200,100,2.96,at2);
        addNewArtikel("Deur 1",6,100,1.50,at3);
        addNewArtikel("Deur 2",3,100,1.28,at3);
        addNewArtikel("Auto-onderdeel 1",40,100,14.59,at4);
        addNewArtikel("Auto-onderdeel 2",60,100,41.67,at4);
        addNewArtikel("Diesel",300,100,2.50,at5);
        addNewArtikel("Benzine",300,100,1.99,at5);

            //Monteur m1 = new Monteur("Jurjen van Geenen", 1);
            //Monteur m2 = new Monteur("Helen Clason", 2);
            //alleMonteurs.add(m1);alleMonteurs.add(m2);

            //In klant toevoegPanel wordt ook de nieuwe auto aangemaakt
	}

	private void addNewArtikel(String name, int amount, int maxAmount, double price, ArtikelType artikelType){
	    alleArtikelen.add(new Artikel(name, amount, maxAmount, price, artikelType));
    }

	public void voegKlantToe(Klant nweKlant) {
            if (!heeftKlant(nweKlant.getNaam())) {
                alleKlanten.add(nweKlant);
                System.out.println("toegevoegd");
            }
	}
	
	public boolean heeftKlant(String kN) {
            boolean b = false;
            for (Klant k : alleKlanten) {
                if (k.getUsername().equals(kN)) {
                    b = true;
                }
            }
            return b;
	}
	
	public void verwijderKlant(Klant exKlant) {
            if(heeftKlant(exKlant.getUsername())){
                alleKlanten.remove(exKlant);
            }
	}
        
        public void voegAccountToe(Account nwAccount) {
            if (!heeftAccount(nwAccount.getNaam())) {
                alleAccounts.add(nwAccount);
                System.out.println("toegevoegd");
            }
	}
	
	public boolean heeftAccount(String aN) {
            boolean b = false;
            for (Account a : alleAccounts) {
                if (a.getUsername().equals(aN)) {
                    b = true;
                }
            }
            return b;
	}
	
	public void verwijderAccount(Account exAccount) {
            if(heeftAccount(exAccount.getUsername())){
                alleAccounts.remove(exAccount);
            }
	}
	
        public void voegMedewerkerToe(Medewerker nwMedewerker) {
            if (!heeftMedewerker(nwMedewerker.getNaam())) {
                alleMedewerkers.add(nwMedewerker);
                System.out.println("toegevoegd");
            }
	}
	
	public boolean heeftMedewerker(String mN) {
            boolean b = false;
            for (Medewerker m : alleMedewerkers) {
                if (m.getUsername().equals(mN)) {
                    b = true;
                }
            }
            return b;
	}
        
        public boolean heeftMedewerkerId(int id) {
            boolean b = false;
            for (Medewerker m : alleMedewerkers) {
                if (m.getID() == id) {
                    b = true;
                }
            }
            return b;
	}
	
	public void verwijderMedewerker(Medewerker exMedewerker) {
            if(heeftMedewerker(exMedewerker.getUsername())){
                alleMedewerkers.remove(exMedewerker);
            }
	}
        
	public void voegDienstToe(Dienst d) {
            alleDiensten.add(d);
	}
	
	public void voegFactuurToe(Factuur f) {
            alleFacturen.add(f);
	}
	
	public int aantalKlanten() {
            return alleKlanten.size();
	}
	
	public ArrayList<Klant> getAlleKlanten() {
            return alleKlanten;
	}
        
	public ArrayList<Account> getAlleAccounts() {
            return alleAccounts;
	}
        
        public ArrayList<Medewerker> getAlleMedewerkers() {
            return alleMedewerkers;
	}
	
	public ArrayList<Artikel> getAlleArtikelen() {
            return alleArtikelen;
	}
	
	public ArrayList<Factuur> getAlleFacturen() {
            return alleFacturen;
	}
	
	public ArrayList<Dienst> getAlleDiensten() {
            return alleDiensten;
	}
	/*
	public ArrayList<Monteur> getAlleMonteurs() {
            return alleMonteurs;
	}
	*/
	public ArrayList<Auto> getAlleAutos() {
            return alleAutos;
	}
	
        public void setAlleKlanten(ArrayList<Klant> k){
            alleKlanten = k;
        }
        
        public void setAlleMedewerkers(ArrayList<Medewerker> m){
            alleMedewerkers = m;
        }
        
        public void setAlleAccounts(ArrayList<Account> a){
            alleAccounts = a;
        }
        
        public void setAlleArtikelen(ArrayList<Artikel> k){
            alleArtikelen = k;
        }
        
        public void setAlleFacturen(ArrayList<Factuur> k){
            alleFacturen = k;
        }
        
        public void setAlleDiensten(ArrayList<Dienst> k){
            alleDiensten = k;
        }
        /*
        public void setAlleMonteurs(ArrayList<Monteur> m){
            alleMonteurs = m;
        }
        */
        public void setAlleAutos(ArrayList<Auto> a){
            alleAutos = a;
        }      
        
        public String toString() {
		String s = "Bedrijf " + naam + " heeft " +
		aantalKlanten() + " klanten\n";
		for (Klant k : alleKlanten) {
			s += k + "\n";
		}
		return s;
	}

}