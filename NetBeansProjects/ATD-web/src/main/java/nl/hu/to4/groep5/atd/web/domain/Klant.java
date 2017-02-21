package nl.hu.to4.groep5.atd.web.domain;

import java.io.Serializable;

/*
 * Gemaakt door: Tristan
 */

public class Klant extends Account implements Serializable{
    private boolean WiltHerinnering;

    public Klant(String user,String naam, String wachtwoord, String telefoonnummer, String postcode, String plaats, String email, boolean wiltHerinneringsBrieven){
        super(user,naam,wachtwoord,telefoonnummer,postcode,plaats,email);
        WiltHerinnering = wiltHerinneringsBrieven;
    }

    /**
     * @return the WiltHerinnering
     */
    public boolean getWiltHerinnering() {
        return WiltHerinnering;
    }

    /**
     * @param WiltHerinnering the WiltHerinnering to set
     */
    public void setWiltHerinnering(boolean WiltHerinnering) {
        this.WiltHerinnering = WiltHerinnering;
    }
        
        
}