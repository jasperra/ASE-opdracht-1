package nl.hu.to4.groep5.atd.web.domain;

/*
 * Gemaakt door: Tristan en Roger
 */






public class Auto {
	private String naam;
	private String merk;
	private Klant deEigenaar;
	
	public Auto(String nm, String mk, Klant dE){
		naam = nm;
		merk = mk;
		deEigenaar = dE;
	}
	
	public String getNaam(){
		return naam;
	}
	public String getMerk(){
		return merk;
	}
	public Klant getKlant(){
		return deEigenaar;
	}
	public String getDeEigenaarsNaam(){
		return deEigenaar.getNaam();
	}
}
