/*
 * Gemaakt door: Tristan en Roger
 */




package nl.hu.to4.groep5.atd.web.gui;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import nl.hu.to4.groep5.atd.web.domain.*;

public class VoorraadbeheerPanel extends MyPanel implements EventHandler<ActionEvent>{
	
	private MyStage myStage;
	private Bedrijf hetBedrijf;
	private Button[] soorten;
	
	public VoorraadbeheerPanel(MyStage ms, Bedrijf b){
		super(ms);
		myStage = ms;
		hetBedrijf = b;
		setId("VoorraadbeheerPanel");
		
		//Hier worden de menu-buttons aangemaakt.
		soorten = new Button[6];
		soorten[0] = new Button("Schroeven");
		soorten[1] = new Button("Moeren");
		soorten[2] = new Button("Deuren");
		soorten[3] = new Button("Auto-onderdelen");
		soorten[4] = new Button("Brandstof");
		for(int i = 0 ; i < 5 ; i ++){
			soorten[i].setPrefWidth(166);
			soorten[i].setOnAction(this); //Bij het klikken op een van deze buttons verschijnt er een scherm waarop de gebruiker de nieuwe voorraad van het geselecteerde soort in kan vullen.
		}
		soorten[3].setPrefWidth(150);
		soorten[5] = new Button("Bestellen");
		soorten[5].setPrefWidth(125);
		soorten[5].setOnAction(e -> showBestellijst()); //Hier wordt het scherm getoont waarop de bestellijst te zien is.
		
		//In deze HBox komen de menu-items te staan.
		HBox menuBar = new HBox();
		menuBar.getChildren().addAll(soorten);
		
		//In deze VBox komt het voorraadoverzicht te staan
		VBox vB = fillVBox();
		
		//De HBox & VBox worden op het panel geplaatst.
		setCenter(vB);
		setTop(menuBar);
	}
	public void showBestellijst() {
		myStage.sceneSetter(6);
	}
	public void handle(ActionEvent e) {
		//Hier wordt per button gekeken welke button moet worden meegegeven aan het nieuwe wijzigPanel.		
		for(int i = 0 ; i < soorten.length ; i ++ ){
			if(e.getSource() == soorten[i]){
				VoorraadWijzigPanel vWP = new VoorraadWijzigPanel(hetBedrijf,soorten[i].getText(), this);
			}
		}
	}
	public VBox fillVBox(){
		//Hier wordt een VBox aangemaakt, waarin het voorraadoverzicht wordt weergegeven.
		VBox vB = new VBox();
		HBox items = new HBox();
		items.setStyle("-fx-font-weight: bold;-fx-font-size: 15");
		Label ls = new Label("Code: ");
		Label lt = new Label("Type: ");
		Label la = new Label("Aantal: ");
		ls.setStyle("-fx-text-fill:black");
		lt.setStyle("-fx-text-fill:black");
		la.setStyle("-fx-text-fill:black");
		ls.setPrefWidth(150);
		lt.setPrefWidth(150);
		items.getChildren().addAll(ls,lt,la);
		vB.getChildren().add(items);
		for(Artikel a : hetBedrijf.getAlleArtikelen()){	
			HBox artikel = new HBox();
			artikel.setStyle("-fx-font-weight: bold");
			Label l1 = new Label(a.getCode());
			Label l2 = new Label(a.getType());
			Label l3 = new Label("" + a.getAantal());
			l1.setPrefWidth(150);
			l2.setPrefWidth(150);
			artikel.getChildren().addAll(l1,l2,l3);
			vB.getChildren().add(artikel);
		}
		
		vB.setSpacing(2);
		vB.setPadding(new Insets(150,0,0,20));
		
		return vB;
	}
	public void refresh() {
		//Hier wordt de huidige waarde van de VBox op null gezet en vervolgens opnieuw ingevuld 
		// met nieuwe gegevens. Daarna wordt hij weer op de Center positie gezet.
		setCenter(null);
		VBox vB = fillVBox();
		setCenter(vB);
	}
}