package nl.hu.to4.groep5.atd.web.domain;

/*
 * Gemaakt door: Tristan en Roger
 */

import java.io.*;
import java.util.*;

public class Bedrijf implements Serializable{

	private String naam;
	private ArrayList<Klant> alleKlanten = new ArrayList<Klant>();
	private ArrayList<Factuur> alleFacturen = new ArrayList<Factuur>();
	private ArrayList<Dienst> alleDiensten = new ArrayList<Dienst>();
	private ParkeerPlaats deParkeerPlaats;
	private ArrayList<Artikel> alleArtikelen = new ArrayList<Artikel>();
	private ArrayList<Monteur> alleMonteurs = new ArrayList<Monteur>();
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

            Artikel a1 = new Artikel("Moer 1",200,100,1.50,at1);
            Artikel a2 = new Artikel("Moer 2",200,100,1.28,at1);
            Artikel a3 = new Artikel("Schroef 1",200,100,1.78,at2);
            Artikel a4 = new Artikel("Schroef 2",200,100,2.96,at2);
            Artikel a5 = new Artikel("Deur 1",6,100,1.50,at3);
            Artikel a6 = new Artikel("Deur 2",3,100,1.28,at3);
            Artikel a7 = new Artikel("Auto-onderdeel 1",40,100,14.59,at4);
            Artikel a8 = new Artikel("Auto-onderdeel 2",60,100,41.67,at4);
            Artikel a9 = new Artikel("Diesel",300,100,2.50,at5);
            Artikel a10 = new Artikel("Benzine",300,100,1.99,at5);
            alleArtikelen.add(a1);alleArtikelen.add(a2);alleArtikelen.add(a3);alleArtikelen.add(a4);alleArtikelen.add(a5);alleArtikelen.add(a6);alleArtikelen.add(a7);alleArtikelen.add(a8);alleArtikelen.add(a9);alleArtikelen.add(a10);

            Monteur m1 = new Monteur("Jurjen van Geenen", 1);
            Monteur m2 = new Monteur("Helen Clason", 2);
            alleMonteurs.add(m1);alleMonteurs.add(m2);

            //In klant toevoegPanel wordt ook de nieuwe auto aangemaakt
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
			if (k.getNaam().equals(kN)) {
				b = true;
			}
		}
		return b;
	}
	
	public void verwijderKlant(Klant exKlant) {
		if (heeftKlant(exKlant.getNaam())){
			alleKlanten.remove(exKlant);
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
	
	public ArrayList<Artikel> getAlleArtikelen() {
		return alleArtikelen;
	}
	
	public ArrayList<Factuur> getAlleFacturen() {
		return alleFacturen;
	}
	
	public ArrayList<Dienst> getAlleDiensten() {
		return alleDiensten;
	}
	
	public ArrayList<Monteur> getAlleMonteurs() {
		return alleMonteurs;
	}
	
	public ArrayList<Auto> getAlleAutos() {
		return alleAutos;
	}
	
        public void setAlleKlanten(ArrayList<Klant> k){
            alleKlanten = k;
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
        
        public void setAlleMonteurs(ArrayList<Monteur> m){
            alleMonteurs = m;
        }
        
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