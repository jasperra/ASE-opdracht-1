package nl.hu.to4.groep5.atd.web.domain;

import java.io.Serializable;

/*
 * Gemaakt door: Tristan en Roger
 */






public class Auto implements Serializable{
	private String naam;
	private String merk;
	private Klant klant;
	
	public Auto(String nm, String mk, Klant dE){
		naam = nm;
		merk = mk;
		klant = dE;
	}
	
	public String getNaam(){
		return naam;
	}
	public String getMerk(){
		return merk;
	}
	public Klant getKlant(){
		return klant;
	}
	public String getDeEigenaarsNaam(){
		return klant.getNaam();
	}
}
