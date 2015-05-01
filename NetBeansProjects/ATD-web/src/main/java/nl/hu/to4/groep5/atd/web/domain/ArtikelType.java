package nl.hu.to4.groep5.atd.web.domain;

import java.io.Serializable;

/*
 * Gemaakt door: Tristan en Roger
 */





public class ArtikelType implements Serializable{
	private String type;
	
	public ArtikelType(String t){
		type = t;
	}
	
	public String getType() { return type; }

}