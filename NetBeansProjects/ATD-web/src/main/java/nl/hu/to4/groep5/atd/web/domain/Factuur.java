package hu.to4.groep5.atd.web.domain;

/*
 * Gemaakt door: Tristan en Roger
 */






import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Factuur implements Serializable{
	
	private int factuurNummer;
	private double brutoPrijs;
	private boolean isBetaald;
	private String omschrijving, factuurDatum, vervalDatum;
	private Klant betalendeKlant;

	public Factuur(ParameterObject parameterObject){
		factuurNummer = parameterObject.getfN();
		setFactuurDatum(parameterObject.getfD());
		setVervalDatum(parameterObject.getvD());
		setOmschrijving(parameterObject.getoS());
		isBetaald = false;
		betalendeKlant = parameterObject.getK();
	}
	
	public static boolean checkFactuur(String vD) {
		Date currentDate = Calendar.getInstance().getTime();

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date vervalDate = null;
		try {
			vervalDate = df.parse(vD);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if(currentDate.compareTo(vervalDate) > 0){
			return true;
		}
		return false;
	}
	
	public String toString(){
		String s = "De Klant: " + betalendeKlant.getNaam() + ", heeft";
		if(isBetaald){
			s += "wel betaald en is succesvol afgerond";
		}
		else{
			s = " niet betaald en zal nog" + brutoPrijs + " euro moeten betalen";
		}
		return s;
	}
	
	public void setIsBetaald(boolean b){
		isBetaald = b;
	}
	
	public boolean getIsBetaald(){
		return isBetaald;
	}
	
	public int getFactuurNummer(){
		return factuurNummer;
	}
	
	public String getKlantNaam(){
		return betalendeKlant.getNaam();
	}
	
	public void setFactuurNummer(int fN){
		factuurNummer = fN;
	}
	
	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String oS) {
		omschrijving = oS;
	}

	public String getFactuurDatum() {
		return factuurDatum;
	}

	public void setFactuurDatum(String fD) {
		factuurDatum = fD;
	}

	public String getVervalDatum() {
		return vervalDatum;
	}

	public void setVervalDatum(String vD) {
		vervalDatum = vD;
	}
	
	public double getBrutoPrijs() {
		return brutoPrijs;
	}

	public void setBrutoPrijs(double bP) {
		brutoPrijs = bP;
	}
}

