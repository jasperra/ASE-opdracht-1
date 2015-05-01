package nl.hu.to4.groep5.atd.web.domain;

import java.io.Serializable;

/*
 * Gemaakt door: Tristan en Roger
 */






public class GebruikteArtikelen implements Serializable{
	//Hier staan de attributen
	private int aantal; //Dit is een int getal, met de naam: aantal
	private Artikel hetArtikel; //Dit is een Artikel Object, met de naam: hetArtikel
	
	//Dit is de constructor voor een GebruiktArtikel
	public GebruikteArtikelen(int a, Artikel hA){
		aantal = a; 
		hetArtikel = hA; //Hier wordt het betreffende artikel meegegeven.
	}
	
	public Artikel getHetArtikel(){
		return hetArtikel;
	}
	
	public int getAantal(){
		return aantal;
	}
	
	public String toString(){
		return "" + hetArtikel.getCode() + " : " +aantal;
	}
}
