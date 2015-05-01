package nl.hu.to4.groep5.atd.web.domain;

/*
 * Gemaakt door: Thijs
 */






public class Klant {
	private boolean WiltHerinnering;
	private String username, naam, wachtwoord, telefoonnummer, postcode, plaats, emailadres;
	
	public Klant(String user,String nm, String ww, String tel, String pc, String pl, String email, boolean wh){
        username = user;
        naam = nm;
        wachtwoord = ww;
        telefoonnummer = tel;
        postcode = pc;
        plaats = pl;
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
        
        public String getWachtwoord() {
            return wachtwoord;
        }
        
        public void setWachtwoord(String ww) {
            wachtwoord = ww;
        }

	public String getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(String tel) {
		telefoonnummer = tel;
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

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param user the username to set
     */
    public void setUsername(String user) {
        username = user;
    }
}