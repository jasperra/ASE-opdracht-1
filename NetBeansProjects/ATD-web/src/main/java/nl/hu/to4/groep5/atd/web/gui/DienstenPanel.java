/*
 * Gemaakt door: Tristan en Roger
 */




package nl.hu.to4.groep5.atd.web.gui;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import DomeinKlassen.*;

public class DienstenPanel extends MyPanel{
	
	private Bedrijf hetBedrijf;
	private boolean type = false;
	private Button typeB;
	
	public DienstenPanel(MyStage ms, Bedrijf b){
		super(ms);
		hetBedrijf = b;
		setId("AgendaPanel");
		
		VBox menu = new VBox(); //VBox voor het menu
		Button check = new Button("Dienst Toevoegen");
		check.setTextAlignment(TextAlignment.CENTER);
		check.setPrefWidth(150);
		check.setPrefHeight(50);
		check.setOnAction(e -> nieuweDienst()); //Button voegt een nieuwe dienst toe
		
		typeB = new Button("Show alleen \nonderhoudsbeurten");
		typeB.setTextAlignment(TextAlignment.CENTER);
		typeB.setPrefWidth(150);
		typeB.setPrefHeight(50);
		typeB.setOnAction(e -> swapType()); //Button swapped tussen alle diensten, of alleen onderhoudsbeurten
		
		menu.setPadding(new Insets(10));
		menu.setSpacing(10);
		menu.getChildren().addAll(check,typeB);
		
		//In deze VBox komt het voorraadoverzicht te staan
		VBox vB = fillVBox();
		
		//De HBox & VBox worden op het panel geplaatst.
		setCenter(vB);
		setRight(menu);
	}
	
	public void nieuweDienst() {
		DienstToevoegPanel dTP = new DienstToevoegPanel(this, hetBedrijf); //het Panel voor het toevoegen van een nieuwe dienst wordt aangemaakt.
	}

	public VBox fillVBox(){
		//Hier wordt een VBox aangemaakt, waarin het dienstenoverzicht wordt weergegeven. Dit is dus een soort planning/agenda
		VBox vB = new VBox();
		HBox items = new HBox();//Een HBox waar de namen van de kolommen in komen
		items.setStyle("-fx-font-weight: bold;-fx-font-size: 15");
		Label lnr = new Label("DienstNr: ");//De namen van de kolommen
		Label ld = new Label("Datum: ");
		Label lk = new Label("Monteur: ");
		Label lt = new Label("Type dienst: ");//De textkleur moet zwart zijn, want de standaard kleur is niet duidelijk te lezen
		lnr.setStyle("-fx-text-fill:black");
		ld.setStyle("-fx-text-fill:black");
		lk.setStyle("-fx-text-fill:black");
		lt.setStyle("-fx-text-fill:black");
		lnr.setPrefWidth(100);
		ld.setPrefWidth(120);
		lk.setPrefWidth(120);
		items.getChildren().addAll(lnr, ld, lk, lt);
		vB.getChildren().add(items);
		for(Dienst d : hetBedrijf.getAlleDiensten()){ //Elke dienst krijgt zijn eigen HBox waar de gegevens in komen
			if(type == true){ //Als type true is, dan komen er alleen onderhoudsbeurten in het overzicht
				if(d.equalsDienst(d)){
					HBox list = new HBox();
					Label l1 = new Label("" + d.getDienstNummer());
					Label l2 = new Label(d.getDatum());
					Label l3 = new Label(d.getNaam());
					Label l4 = new Label("Onderhoudsbeurt");
					l1.setStyle("-fx-text-fill: black");
					l2.setStyle("-fx-text-fill: black");
					l3.setStyle("-fx-text-fill: black");
					l4.setStyle("-fx-text-fill: black");
					
					Button b = new Button("Wijzigen");
					b.setOnAction(e -> {
						DienstWijzigPanel dWP = new DienstWijzigPanel(d, this, hetBedrijf);
					});
					l1.setPrefWidth(100);
					l2.setPrefWidth(120);
					l3.setPrefWidth(120);
					l4.setPrefWidth(120);
					list.getChildren().addAll(l1,l2,l3,l4,b);
					vB.getChildren().add(list);
				}
			}
			else{ //Als type false is, dan komen alle diensten in het overzicht
				HBox list = new HBox();
				Label l1 = new Label("" + d.getDienstNummer());
				Label l2 = new Label(d.getDatum());
				Label l3 = new Label(d.getNaam());
				Label l4;
				if(d instanceof Onderhoudsbeurt){
					l4 = new Label("Onderhoudsbeurt");
				}
				else if(d instanceof TankDienst){
					l4 = new Label("Tankdienst");
				}
				else {
					l4 = new Label("Parkeerdienst");
				}Button b = new Button("Wijzigen");
				b.setOnAction(e -> {
					DienstWijzigPanel dWP = new DienstWijzigPanel(d, this, hetBedrijf);
				});
				l1.setPrefWidth(100);
				l2.setPrefWidth(120);
				l3.setPrefWidth(120);
				l4.setPrefWidth(120);
				l1.setStyle("-fx-text-fill: black");
				l2.setStyle("-fx-text-fill: black");
				l3.setStyle("-fx-text-fill: black");
				l4.setStyle("-fx-text-fill: black");
				list.getChildren().addAll(l1,l2,l3, l4,b);
				vB.getChildren().add(list);
			}
		}
		vB.setSpacing(2);
		vB.setPadding(new Insets(140,0,0,20));
		
		return vB;
	}
	
	public void refresh() { //Het refreshen van het overzicht
		setCenter(null);
		VBox vB = fillVBox();
		setCenter(vB);
		System.out.println("Refreshing");
	}
	
	
	public void swapType(){ //Het swappen tussen "alle soorten" en "alleen onderhoudsbeurten"
		if(type == false){
			type = true;
			typeB.setText("Show alle soorten");
		}
		else if(type == true){
			type = false;typeB.setText("Show alleen reparaties");
		}
		refresh();
	}
}
