/*
 * Gemaakt door: Tristan en Roger
 */




package nl.hu.to4.groep5.atd.web.gui;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import nl.hu.to4.groep5.atd.web.domain.*;

public class BestelPanel extends MyPanel {
	
	private MyStage myStage;
	private Bedrijf hetBedrijf;
	private VoorraadbeheerPanel vP;
	
	public BestelPanel(MyStage ms, Bedrijf b, MyPanel mP) {
		super(ms);
		myStage = ms;
		vP = (VoorraadbeheerPanel) mP;
		hetBedrijf = b;
		setId("BestelPanel");
		
		setBottom(null);
		HBox terugBox = new HBox(); //Een HBox voor de aangepaste Terug-button onderin.
		
		Button terug = new Button("Terug");
		terug.setPrefWidth(125);
		terug.setPrefHeight(50);
		
		Button b2 = new Button("Bestellen");
		b2.setPrefWidth(125);
		b2.setPrefHeight(50);
		
		terug.setOnAction(e -> myStage.sceneSetter(1));
		b2.setOnAction(e -> bestellen());
		
		terugBox.getChildren().addAll(terug, b2);
		
		//In deze VBox komt het voorraadoverzicht te staan
		VBox labelBox = fillVBox(); //Een VBox voor de invoervelden etc.
		
		labelBox.setSpacing(3);
		labelBox.setPadding(new Insets(176,0,0,20));
		
		setLeft(labelBox);
		setBottom(terugBox);
		
		terugBox.setSpacing(520);
		terugBox.setPrefWidth(200);
		terugBox.setPadding(new Insets(10));
		terugBox.setAlignment(Pos.BOTTOM_LEFT);
	}
	
	/*
	 * Hier wordt daadwerkelijk besteld, we gaan ervanuit dat alle bestelde artikelen geleverd worden
	 */
	public void bestellen() {
		for(Artikel a : hetBedrijf.getAlleArtikelen()){
			if(a.getAantal() < a.getMinimum()){
				a.setAantal(a.getMinimum()+10);
			}
			vP.refresh();
		}
		myStage.sceneSetter(1);
	}
	
	public VBox fillVBox(){
		//De voorraad uitprinten, de toString van voorraad kijkt of er wel of niet besteld moet worden.
		VBox vb = new VBox();
		for(Artikel a : hetBedrijf.getAlleArtikelen()){
			Label l = new Label(a.toString());
			l.setStyle("-fx-font-weight: bold");
			if(!l.getText().equals("")){
				vb.getChildren().add(l);
			}
		}
		return vb;
	}
}