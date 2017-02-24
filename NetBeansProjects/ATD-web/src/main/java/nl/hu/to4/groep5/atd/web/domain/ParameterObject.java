package hu.to4.groep5.atd.web.domain;

public class ParameterObject{
	private int fN;
	private String fD;
	private String vD;
	private String oS;
	private Klant k;

	public ParameterObject(int fN, String fD,String vD, String oS, Klant k){
		this.fN = fN;
		this.fD = fD;
		this. vD = vD;
		this.oS = oS;
		this.k = k;
	}

	public int getfN() {
		return fN;
	}

	public String getfD() {
		return fD;
	}

	public String getvD() {
		return vD;
	}

	public String getoS() {
		return oS;
	}

	public Klant getK() {
		return k;
	}
}
