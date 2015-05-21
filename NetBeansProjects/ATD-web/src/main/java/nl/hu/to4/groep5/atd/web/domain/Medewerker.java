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
}