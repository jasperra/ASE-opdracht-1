package nl.hu.to4.groep5.atd.web.domain;

import java.io.Serializable;

/*
 * Gemaakt door: Tristan
 */

public class Medewerker extends Account implements Serializable{
    private int ID;
    private String rol;

    public Medewerker(int iD,String r,String user,String nm, String ww, String tel, String pc, String pl, String email){
        super(user,nm,ww,tel,pc,pl,email);
        ID = iD;
        rol = r;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
}