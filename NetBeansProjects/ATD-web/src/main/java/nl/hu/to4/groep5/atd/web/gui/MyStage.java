/*
 * Gemaakt door: Tristan en Roger
 */




package nl.hu.to4.groep5.atd.web.gui;
import DomeinKlassen.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class MyStage extends Application {

	private Stage onzeStage;
	private Bedrijf b = new Bedrijf();
	
	private MyPanel mP = new MenuPanel(this);
	private MyPanel vP = new VoorraadbeheerPanel(this,b);
	private MyPanel aP = new DienstenPanel(this,b); //Agenda
	private MyPanel fP = new FactuurPanel(this,b);
	private MyPanel kP = new KlantenPanel(this,b);
	private MyPanel pP = new ParkeerPanel(this,b);
	private MyPanel bP = new BestelPanel(this,b, vP);
	
	private Scene menuScene = new Scene(mP,800,600);
	private Scene voorraadScene = new Scene(vP,800,600);
	private Scene agendaScene = new Scene(aP,800,600);
	private Scene factuurScene = new Scene(fP,800,600);
	private Scene klantenScene = new Scene(kP,800,600);
	private Scene parkeerScene = new Scene(pP,800,600);
	private Scene bestelScene = new Scene(bP,800,600);
	
	public void start(Stage stage){
		onzeStage = stage;
		onzeStage.setScene(menuScene);
		onzeStage.show();
		onzeStage.setResizable(false);
	}
	
	public MyPanel getBP(){
		return bP;
	}
	
	public void sceneSetter(int newScene){
		// hier wordt een switcher gebruiker, deze heeft 7 schermen met het Menu als standaard scherm.
		//Vanuit de andere Panels kunnen we nu aanroepen welke scene getoont moet worden.
		onzeStage.setScene(null);
		switch (newScene) {
			case 1 : onzeStage.setScene(voorraadScene); break;
			case 2 : onzeStage.setScene(agendaScene); break;
			case 3 : onzeStage.setScene(factuurScene); break;
			case 4 : onzeStage.setScene(klantenScene); break;
			case 5 : onzeStage.setScene(parkeerScene); break;
			case 6 : onzeStage.setScene(bestelScene); break;
			default : onzeStage.setScene(menuScene);
		}
	}
	public static void main(String[] arg){
		Application.launch(arg);
	}
}