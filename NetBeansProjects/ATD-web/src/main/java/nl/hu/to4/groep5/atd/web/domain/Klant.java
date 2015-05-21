package nl.hu.to4.groep5.atd.web.domain;

import java.io.Serializable;

/*
 * Gemaakt door: Tristan
 */

public class Klant extends Account implements Serializable{
    private boolean WiltHerinnering;

    public Klant(String user,String nm, String ww, String tel, String pc, String pl, String email, boolean wh){
        super(user,nm,ww,tel,pc,pl,email);
        WiltHerinnering = wh;
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