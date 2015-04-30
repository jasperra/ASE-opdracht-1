package nl.hu.to4.groep5.atd.web.domain;

/*
 * Gemaakt door: Tristan en Roger
 */

import java.util.*;

public class Bedrijf {

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
		
		Klant k1 = new Klant("Thijs Gelton", "Nijenoord 1", "06-06-1996", "0612345678", "4105EE", "thijs.gelton@student.hu.nl", true);
		Klant k2 = new Klant("Sam Cornelissen", "Oudenoord 500", "06-06-1996", "0687654321", "5083FF", "sam.cornellisen@student.hu.nl", true);
		alleKlanten.add(k1);alleKlanten.add(k2);
		
		Auto aut1 = new Auto("Gallardo", "Lamborghini", k1);
		Auto aut2 = new Auto("C1", "Citroen", k2);
		alleAutos.add(aut1);alleAutos.add(aut2);
		
		Factuur f1 = new Factuur(1,"02-04-2015", "01-05-2015", "Onderhoudsbeurt", k1);
		Factuur f2 = new Factuur(2,"02-03-2015", "01-04-2015", "Onderhoudsbeurt", k2);
		Factuur f3 = new Factuur(3,"02-04-2015", "01-05-2015", "Onderhoudsbeurt", k1);
		Factuur f4 = new Factuur(4,"02-03-2015", "01-04-2015", "Onderhoudsbeurt", k2);
		Factuur f5 = new Factuur(5,"02-04-2015", "01-05-2015", "Onderhoudsbeurt", k1);
		Factuur f6 = new Factuur(6,"02-03-2015", "01-04-2015", "ParkeerDienst", k2);
		Factuur f7 = new Factuur(7,"02-04-2015", "01-05-2015", "ParkeerDienst", k1);
		Factuur f8 = new Factuur(8,"02-03-2015", "01-04-2015", "TankDienst", k2);
		Factuur f9 = new Factuur(9,"02-04-2015", "01-05-2015", "TankDienst", k1);
		alleFacturen.add(f1);alleFacturen.add(f2);alleFacturen.add(f3);alleFacturen.add(f4);alleFacturen.add(f5);alleFacturen.add(f6);alleFacturen.add(f7);alleFacturen.add(f8);alleFacturen.add(f9);
		f3.setIsBetaald(true);
		f6.setIsBetaald(true);
		
		Dienst d1 = new Onderhoudsbeurt(1, "03-04-2012", aut1, m1); 	d1.setDeBetaling(f1);
		Dienst d2 = new Onderhoudsbeurt(2, "03-04-2015", aut2, m2);	 	d2.setDeBetaling(f2);
		Dienst d7 = new Onderhoudsbeurt(7, "23-04-2017", aut1, m1); 	d7.setDeBetaling(f3);
		Dienst d8 = new Onderhoudsbeurt(8, "03-07-2015", aut2, m2); 	d8.setDeBetaling(f4);
		Dienst d9 = new Onderhoudsbeurt(9, "23-04-2017", aut1, m1); 	d9.setDeBetaling(f5);
		Dienst d3 = new ParkeerDienst(3, "03-04-2012",20);			 	d3.setDeBetaling(f6);
		Dienst d4 = new ParkeerDienst(4, "03-04-2015",500);			 	d4.setDeBetaling(f7);
		Dienst d5 = new TankDienst(5, "03-04-2012", a9, 10);		 	d5.setDeBetaling(f8);
		Dienst d6 = new TankDienst(6, "03-04-2015", a10, 50);		 	d6.setDeBetaling(f9);
		alleDiensten.add(d1);alleDiensten.add(d2);alleDiensten.add(d3);alleDiensten.add(d4);alleDiensten.add(d5);alleDiensten.add(d6);alleDiensten.add(d7);alleDiensten.add(d8);alleDiensten.add(d9);
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