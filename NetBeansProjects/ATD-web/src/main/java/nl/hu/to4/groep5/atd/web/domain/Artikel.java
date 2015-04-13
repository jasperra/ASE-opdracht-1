package nl.hu.to4.groep5.atd.web.domain;

/*
 * Gemaakt door: Tristan en Roger
 */





public class Artikel {

	private String code;
	private ArtikelType hetType;
	private int aantal,minimum;
	private double prijs;

	public Artikel(String s, int min, int a, double pr, ArtikelType at){
		code = s;
		minimum = min;
		aantal = a;
		prijs = pr;
		hetType = at;
	}
	public void setAantal(int al){
		aantal = al;
	}
	public String getCode(){ return code; }
	public String getType(){ return hetType.getType(); }
	public int getAantal() { return aantal;}
	public int getMinimum() { return minimum; }
	public double getPrijs() { return prijs; }
	
	public String toString(){
		//Hier wordt gekeken of er wel of niet besteld moet worden. Dan wordt dit in een String gezet, deze String wordt vervolgens gereturned.
		String s = "Van type: " + hetType.getType() + ", ";
		int a = minimum - aantal;
		if(a > 0){
			s += "moeten er " + a + " besteld worden";
		}
		else{
			s = "";
		}
		return s;
	}
}