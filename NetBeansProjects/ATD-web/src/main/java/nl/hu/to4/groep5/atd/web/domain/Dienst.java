package nl.hu.to4.groep5.atd.web.domain;

import java.io.Serializable;

/*
 * Gemaakt door: Tristan en Roger
 */





public abstract class Dienst implements Serializable{

    private int dienstNummer;
    private String datum;
    private double nettoPrijs;
    private Factuur deBetaling;

    public Dienst(int dN, String dat){
        dienstNummer = dN;
        datum = dat;
    }

    public void setDeBetaling(Factuur f){
        deBetaling = f;
    }

    public Factuur getDeBetaling(){
        return deBetaling;
    }

    public String getKlantNaam(){
        return getDeBetaling().getKlantNaam();
    }

    public abstract void berekenPrijs();

    public abstract boolean equalsDienst(Object andere);

    public int getDienstNummer(){
        return dienstNummer;
    }

    public String getDatum(){
        return datum;
    }

    public abstract String getNaam();

    public double getNettoPrijs(){
        return nettoPrijs;
    }
    public void setNettoPrijs(double p){
        nettoPrijs = p;
    }

    public abstract Onderhoudsbeurt getOnderhoudsbeurt();

    /**
     * @param dienstNummer the dienstNummer to set
     */
    public void setDienstNummer(int dienstNummer) {
        this.dienstNummer = dienstNummer;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(String datum) {
        this.datum = datum;
    }
}
