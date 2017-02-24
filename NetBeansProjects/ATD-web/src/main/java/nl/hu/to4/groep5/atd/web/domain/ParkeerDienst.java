package hu.to4.groep5.atd.web.domain;

import java.io.Serializable;

/*
 * Gemaakt door: Tristan en Roger
 */





public class ParkeerDienst extends Dienst implements Serializable{

	private int aantalUur;
	private ParkeerPlaats deParkeerPlaats;

	public ParkeerDienst(int dN, String dat,int n){
		super(dN,dat);
		aantalUur = n;
	}
	public void setAantalUur(int aU){
		 aantalUur = aU;
	}

	public void berekenPrijs(){
		double p = 0.0;
		p = new Calculations().invoke();
		super.setNettoPrijs(p);
	}

	public boolean equalsDienst(Object andere){
		boolean b = false;
		if(andere instanceof ParkeerDienst){
			b = true;
		}
		return false;
	}
	public String getNaam() {
		return "Geen monteur";
	}
	
	public Onderhoudsbeurt getOnderhoudsbeurt() {
		return null;
	}

	public int getAantalUur() {
		return aantalUur;
	}

	private class Calculations {

		public static final double costPerHour = 5.0;

		public double invoke() {
			return aantalUur * costPerHour;
		}
	}
}