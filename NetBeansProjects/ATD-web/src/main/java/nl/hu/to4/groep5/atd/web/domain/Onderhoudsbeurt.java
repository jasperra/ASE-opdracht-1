package hu.to4.groep5.atd.web.domain;

/*
 * Gemaakt door: Tristan en Roger
 */





import java.io.Serializable;
import java.util.ArrayList;

public class Onderhoudsbeurt extends Dienst implements Serializable{

	private int aantalBestedeUur;
	private Auto deAuto;
	private Monteur deMonteur;
	private ArrayList<GebruikteArtikelen> deArtikelen = new ArrayList<GebruikteArtikelen>();
	private final double pricePerHour = 50.0;

	public Onderhoudsbeurt(int dN, String Dat, Auto dA, Monteur dM){
		super(dN,Dat);
		deAuto = dA;
		deMonteur = dM;
		aantalBestedeUur = 0;
	}
	
	public void berekenPrijs() {
		double p = aantalBestedeUur * pricePerHour;
		p += getAantalBestedeUur();
		super.setNettoPrijs(p);
	}

	private double getPriceOfAllArticles(){
		double d = 0.0;
		for(GebruikteArtikelen ga : deArtikelen){
			d += ga.getHetArtikel().getPrijs() * ga.getAantal();
		}
		return d;
	}
	
	public void voegArtikelToe(Artikel a, int n){
		deArtikelen.add(new GebruikteArtikelen(n, a));
	}
	
	public ArrayList<GebruikteArtikelen> getGebruikteArtikelen(){
		return deArtikelen;
	}
	
	public void setAantalBestedeUur(int u){
		aantalBestedeUur = u;
	}
	
	public int getAantalBestedeUur(){
		return aantalBestedeUur;
	}
	
        @Override
	public boolean equalsDienst(Object andere){
		boolean b = false;
		if(andere instanceof Onderhoudsbeurt){
			b = true;
		}
		return b;
	}
	
        @Override
	public String getNaam() {
		return deMonteur.getNaam();
	}
	
	public void setDeMonteur(Monteur m){
		deMonteur = m;
	}

        @Override
	public Onderhoudsbeurt getOnderhoudsbeurt() {
		return this;
	}
}
