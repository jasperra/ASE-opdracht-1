package nl.hu.to4.groep5.atd.web.domain;

/*
 * Gemaakt door: Thijs
 */






public class Klant {
	private boolean WiltHerinnering;
	private String naam, adres, geboortedatum, telefoonnummer, postcode,emailadres;
	
	public Klant(String nm, String ad, String gd, String tel,String pc, String email, boolean wh){
        naam = nm;
        adres = ad;
        geboortedatum = gd;
        telefoonnummer = tel;
        postcode = pc;
        emailadres = email;
        WiltHerinnering = wh;
        
	}

	public String getEmailadres() {
		return emailadres;
	}

	public void setEmailadres(String email) {
		emailadres = email;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String pc) {
		postcode = pc;
	}

	public String getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(String tel) {
		telefoonnummer = tel;
	}

	public String getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(String gd) {
		geboortedatum = gd;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String ad) {
		adres = ad;
	}
	public String getNaam() {
		return naam;
	}

	public void setNaam(String nm) {
		naam = nm;
	}

	public String wiltHerinnering (){
		String s = "";
		if (WiltHerinnering == true){
			s = "Ja";
		}
		else if (WiltHerinnering == false){
			s = "Nee";
		}
		return s;
	}		
	
	public void setWiltHerinnering(boolean b){
		WiltHerinnering = b;
	}
	
	public boolean isWiltHerinnering() {
		return WiltHerinnering;
	}

	public Klant getKlant(){
		return this;
	}
}