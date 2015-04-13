package nl.hu.to4.groep5.atd.web.domain;

/*
 * Gemaakt door: Tristan en Roger
 */






public class GebruikteArtikelen {
	private int aantal;
	private Artikel hetArtikel;
	
	public GebruikteArtikelen(int a, Artikel hA){
		aantal = a;
		hetArtikel = hA;
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
