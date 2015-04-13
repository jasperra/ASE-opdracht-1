package nl.hu.to4.groep5.atd.web.domain;

/*
 * Gemaakt door: Tristan en Roger
 */





public abstract class Dienst {

	private int dienstNummer;
	private String datum;
	private double nettoPrijs;
	private Factuur deBetaling;
 
	public Dienst(int dN, String dat){
		dienstNummer = dN;
		datum = dat;
	}
	
	public void setDeBetaling(Factuur f){
		deBetaling = f;
	}
	
	public Factuur getDeBetaling(){
		return deBetaling;
	}
	
	public String getKlantNaam(){
		return deBetaling.getKlantNaam();
	}
	
	public abstract void berekenPrijs();
	
	public abstract boolean equalsDienst(Object andere);
	
	public int getDienstNummer(){
		return dienstNummer;
	}
	
	public String getDatum(){
		return datum;
	}
	
	public abstract String getNaam();
	
	public double getNettoPrijs(){
		return nettoPrijs;
	}
	public void setNettoPrijs(double p){
		nettoPrijs = p;
	}
	
	public abstract Onderhoudsbeurt getOnderhoudsbeurt();
}
