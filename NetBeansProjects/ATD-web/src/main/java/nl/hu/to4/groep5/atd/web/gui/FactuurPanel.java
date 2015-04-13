/*
 * Gemaakt door: Tristan en Roger
 */




package nl.hu.to4.groep5.atd.web.gui;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import nl.hu.to4.groep5.atd.web.domain.*;

public class FactuurPanel extends MyPanel{
	
	private Bedrijf hetBedrijf;
	private boolean totaal = false;
	private Button totaalB;
	
	public FactuurPanel(MyStage ms, Bedrijf b){
		super(ms);
		hetBedrijf = b;
		setId("FactuurPanel");
		
		VBox menu = new VBox();
		Button check = new Button("Verzend \nWaarschuwingsmails"); //Button voor het verzenden van de waarschuwingsmails
		check.setTextAlignment(TextAlignment.CENTER);
		check.setPrefWidth(150);
		check.setPrefHeight(50);
		check.setOnAction(e -> checkAlleFacturen());
		
		Button btw = new Button("BTW-Rapportage \nOpstellen"); //Button voor het opstellen van de BTW-rapportage
		btw.setTextAlignment(TextAlignment.CENTER);
		btw.setPrefWidth(150);
		btw.setPrefHeight(50);
		btw.setOnAction(e -> opstellenBTW());
		
		totaalB = new Button("Show alle facturen");
		totaalB.setTextAlignment(TextAlignment.CENTER); //Button voor het laten zien van alle facturen
		totaalB.setPrefWidth(150);
		totaalB.setPrefHeight(50);
		totaalB.setOnAction(e -> swapTotaal());
		
		menu.setPadding(new Insets(10));
		menu.setSpacing(10);
		menu.getChildren().addAll(check, btw, totaalB);
		
		//In deze VBox komt het voorraadoverzicht te staan
		VBox vB = fillVBox();
		
		//De HBox & VBox worden op het panel geplaatst.
		setCenter(vB);
		setRight(menu);
	}
	
	public VBox fillVBox(){
		//Hier wordt een VBox aangemaakt, waarin het voorraadoverzicht wordt weergegeven.
		VBox vB = new VBox();
		HBox items = new HBox();
		items.setStyle("-fx-font-weight: bold;-fx-font-size: 15;");
		Label ls = new Label("Factuurnummer: ");
		Label lt = new Label("Klantnaam: ");
		Label la = new Label("Vervaldatum: ");
		Label lp = new Label("Brutoprijs");
		ls.setStyle("-fx-text-fill:black");
		lt.setStyle("-fx-text-fill:black");
		la.setStyle("-fx-text-fill:black");
		lp.setStyle("-fx-text-fill:black");
		ls.setPrefWidth(140);
		lt.setPrefWidth(130);
		la.setPrefWidth(120);
		items.getChildren().addAll(ls,lt,la,lp);
		vB.getChildren().add(items);
		// Hier worden alle facturen opgehaald en vervolgens onderverdeeld in niet en wel betaalde facturen.
		for(Factuur f : hetBedrijf.getAlleFacturen()){	
			
			if(totaal == false){
				// Hier worden niet betaalde facturen getoont op het scherm.
				if(!f.getIsBetaald()){
					HBox artikel = new HBox();
					Label l1 = new Label("" + f.getFactuurNummer());
					Label l2 = new Label(f.getKlantNaam());
					Label l3 = new Label(f.getVervalDatum());
					Label l4 = new Label("" + f.getBrutoPrijs());
					ContextMenu cM = new ContextMenu();
					MenuItem wijzig = new MenuItem("Wijzigen");
					wijzig.setOnAction(e_-> wijzigFactuur(f));
					cM.getItems().add(wijzig);
					l1.setContextMenu(cM);
					l2.setContextMenu(cM);
					l3.setContextMenu(cM);
					l4.setContextMenu(cM);
					Button b = new Button("Bereken");
					b.setOnAction(e -> {
						Dienst d = getDienst(f);
						d.berekenPrijs();
						System.out.println("" + d.getNettoPrijs());
						f.setBrutoPrijs(d.getNettoPrijs()*1.21);
						refresh();
					});
					if(f.checkFactuur(f.getVervalDatum())){
						l1.setStyle("-fx-text-fill: red");
						l2.setStyle("-fx-text-fill: red");
						l3.setStyle("-fx-text-fill: red");
						l4.setStyle("-fx-text-fill: red");
					}
					else{
						l1.setStyle("-fx-text-fill: black");
						l2.setStyle("-fx-text-fill: black");
						l3.setStyle("-fx-text-fill: black");
						l4.setStyle("-fx-text-fill: black");
					}
					l1.setPrefWidth(140);
					l2.setPrefWidth(130);
					l3.setPrefWidth(120);
					l4.setPrefWidth(50);
					artikel.getChildren().addAll(l1,l2,l3,l4,b);
					vB.getChildren().add(artikel);
				}
			}
			else{
				HBox artikel = new HBox();
				Label l1 = new Label("" + f.getFactuurNummer());
				Label l2 = new Label(f.getKlantNaam());
				Label l3 = new Label(f.getVervalDatum());
				Label l4 = new Label("" + f.getBrutoPrijs());
				ContextMenu cM = new ContextMenu();
				MenuItem wijzig = new MenuItem("Wijzigen");
				wijzig.setOnAction(e_-> wijzigFactuur(f));
				cM.getItems().add(wijzig);
				l1.setContextMenu(cM);
				l2.setContextMenu(cM);
				l3.setContextMenu(cM);
				l4.setContextMenu(cM);
				Button b = new Button("Bereken");
				b.setOnAction(e -> {
					Dienst d = getDienst(f);
					d.berekenPrijs();
					f.setBrutoPrijs(d.getNettoPrijs()*1.21);
					refresh();
				});
				if(f.checkFactuur(f.getVervalDatum())){
					l1.setStyle("-fx-text-fill: red");
					l2.setStyle("-fx-text-fill: red");
					l3.setStyle("-fx-text-fill: red");
					l4.setStyle("-fx-text-fill: red");
				}
				else{
					l1.setStyle("-fx-text-fill: black");
					l2.setStyle("-fx-text-fill: black");
					l3.setStyle("-fx-text-fill: black");
					l4.setStyle("-fx-text-fill: black");
				}
				l1.setPrefWidth(140);
				l2.setPrefWidth(130);
				l3.setPrefWidth(120);
				l4.setPrefWidth(50);
				if(f.getIsBetaald()){
					l1.setStyle("-fx-background-color: #00FF00");
				}
				artikel.getChildren().addAll(l1,l2,l3,l4,b);
				vB.getChildren().add(artikel);
			}
		}
		
		vB.setSpacing(2);
		vB.setPadding(new Insets(140,0,0,20));
		
		return vB;
	}
	
	public void refresh() { // Hier wordt de VBox met informatie opnieuw gevuld.
		setCenter(null);
		VBox vB = fillVBox();
		setCenter(vB);
		System.out.println("Refreshing");
	}
	
	public void swapTotaal(){ // Hier wordt de informatie van de button veranderd en 
								// de variable totaal wordt omgedraait. 
		if(totaal == false){
			totaal = true;
			totaalB.setText("Show betaalde facturen");
		}
		else if(totaal == true){
			totaal = false;
			totaalB.setText("Show alle facturen");
		}
		refresh();
		System.out.println(totaal);
	}
	
	public void opstellenBTW(){ //berekent alle btw bedragen.
		int totaalBedrag = 0;
		for(Factuur f : hetBedrijf.getAlleFacturen()){
			totaalBedrag += f.getBrutoPrijs();
		}
		System.out.println("Totaalbedrag incl BTW = �" + totaalBedrag*1.0);
		System.out.println("Totaalbedrag excl BTW = �" + totaalBedrag/1.21);
		System.out.println("Te vorderen BTW = �" + (totaalBedrag-totaalBedrag/1.21));
	}
	
	public void checkAlleFacturen(){ //gaat voor alle facturen controleren of ze verlopen zijn
		for(Factuur f : hetBedrijf.getAlleFacturen()){
			if(!f.getIsBetaald()){
				if(f.checkFactuur(f.getVervalDatum())){
					System.out.println("Factuurnummer: " + f.getFactuurNummer() + " Onder naam van: " + f.getKlantNaam() + " Is te laat, Mail wordt verzonden");
				}
			}
		}
	}
	
	public void wijzigFactuur(Factuur f){ //Maakt een nieuw wijzigingsscherm aan
		FactuurWijzigPanel fWP = new FactuurWijzigPanel(f, this, hetBedrijf);
	}

	public Dienst getDienst(Factuur f){ //returned de Dienst die bij de factuur hoort
		Dienst tempD = null;
		for(Dienst d : hetBedrijf.getAlleDiensten()){
			if(d.getDeBetaling() == f){
				tempD = d;
			}
		}
		return tempD;
	}
	
}