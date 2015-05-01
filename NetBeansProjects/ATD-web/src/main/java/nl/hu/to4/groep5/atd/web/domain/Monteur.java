package nl.hu.to4.groep5.atd.web.domain;

import java.io.Serializable;

/*
 * Gemaakt door: Tristan en Roger
 */





public class Monteur implements Serializable{

	private int ID;
	private String naam;
	
	public Monteur(String nm,int id){
		naam = nm;
		ID = id;
	}
	
	public String getNaam(){
		return naam;
	}
}