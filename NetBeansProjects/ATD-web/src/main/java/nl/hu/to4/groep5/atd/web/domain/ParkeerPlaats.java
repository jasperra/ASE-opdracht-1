package hu.to4.groep5.atd.web.domain;

import java.io.Serializable;



 
public class ParkeerPlaats implements Serializable{
    private int maxAantal = 25;
    private int aantalBezet = 0;
    private ParkeerPlek parkeerPlek = ParkeerPlek.createParkeerPlek(this);
     
    public ParkeerPlaats(){
         
    }
     
    public void setAantalBezet(int aB){
         
    }
     
    public boolean isPlaats(){
        boolean b = false;
        if(aantalBezet < maxAantal){
            b = true;
        }
        return b;
    }
     
    public boolean isBezet(){
        boolean b = false;
        if(aantalBezet > 0){
            b = true;
        }
        return b;
    }
     
    public void voegToe(){
            aantalBezet += 1;
    }
     
    public void vertrek(){
        aantalBezet -= 1;
    }
     
    public int getAantalbezet(){
        return aantalBezet;
    }
     
    public int getMaxAantal(){
        return maxAantal;
    }
     
    public int aantalVrij(){
        int i = maxAantal - aantalBezet;
        return i;
    }


    public ParkeerPlek getImplValue() {
        return parkeerPlek;
    }
}