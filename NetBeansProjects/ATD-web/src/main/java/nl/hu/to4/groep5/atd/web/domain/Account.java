/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.to4.groep5.atd.web.domain;

import java.io.*;

/**
 * @author Tristan
 */
public abstract class Account implements Serializable{
    private String username, naam, wachtwoord, telefoonnummer, postcode, plaats, emailadres;
    
    public Account(String user,String nm, String ww, String tel, String pc, String pl, String email){
        username = user;
        naam = nm;
        wachtwoord = ww;
        telefoonnummer = tel;
        postcode = pc;
        plaats = pl;
        emailadres = email;
    }

    public boolean login(String ww){
        if(ww.equals(getWachtwoord())){
            return true;
        }else{
            return false;
        }
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param naam the naam to set
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * @return the wachtwoord
     */
    public String getWachtwoord() {
        return wachtwoord;
    }

    /**
     * @param wachtwoord the wachtwoord to set
     */
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    /**
     * @return the telefoonnummer
     */
    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    /**
     * @param telefoonnummer the telefoonnummer to set
     */
    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return the plaats
     */
    public String getPlaats() {
        return plaats;
    }

    /**
     * @param plaats the plaats to set
     */
    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    /**
     * @return the emailadres
     */
    public String getEmailadres() {
        return emailadres;
    }

    /**
     * @param emailadres the emailadres to set
     */
    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }
}
