package hu.to4.groep5.atd.web.domain;

/**
 * Created by Jasper on 24-Feb-17.
 */
public class ParkeerPlek {
    private ParkeerPlaats parkeerPlaats;

    private ParkeerPlek(ParkeerPlaats parkeerPlaats){
        this.parkeerPlaats = parkeerPlaats;
    }

    public static ParkeerPlek createParkeerPlek(ParkeerPlaats parkeerPlaats) {
        return new ParkeerPlek(parkeerPlaats);
    }

    public ParkeerPlaats getImplValue(){
        return parkeerPlaats;
    }

}
