package hu.to4.groep5.atd.web.domain.move;

import hu.to4.groep5.atd.web.domain.Auto;
import hu.to4.groep5.atd.web.domain.Monteur;
import hu.to4.groep5.atd.web.domain.Onderhoudsbeurt;

public class OnderhoudsbeurtBuilder {
    private int dN;
    private String dat;
    private Auto dA;
    private Monteur dM;

    public OnderhoudsbeurtBuilder setdN(int dN) {
        this.dN = dN;
        return this;
    }

    public OnderhoudsbeurtBuilder setDat(String dat) {
        this.dat = dat;
        return this;
    }

    public OnderhoudsbeurtBuilder setdA(Auto dA) {
        this.dA = dA;
        return this;
    }

    public OnderhoudsbeurtBuilder setdM(Monteur dM) {
        this.dM = dM;
        return this;
    }

    public Onderhoudsbeurt createOnderhoudsbeurt() {
        return new Onderhoudsbeurt(dN, dat, dA, dM);
    }
}