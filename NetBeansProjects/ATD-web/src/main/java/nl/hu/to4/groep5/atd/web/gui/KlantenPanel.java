/*
 * Gemaakt door: Thijs
 */




package nl.hu.to4.groep5.atd.web.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import nl.hu.to4.groep5.atd.web.domain.*;

public class KlantenPanel extends MyPanel {
	private Bedrijf hetBedrijf;
	private Button toevoegen, wijzigen;
	private KlantenToevoegPanel kT;
	//private KlantenWijzigPanel kW;
	private HBox klant;
	
	public KlantenPanel (MyStage ms, Bedrijf b){
		super(ms);
		setId("KlantenPanel");
		kT = new KlantenToevoegPanel(ms);	
		//kW = new KlantenWijzigPanel(ms, b, this);
		hetBedrijf = b;
		
		//Titel van de tabel
		Label label = new Label("Klanten");
		label.setAlignment(Pos.TOP_LEFT);
        label.setFont(new Font("Arial", 20));
        
        //Opmaak van de tabel
        VBox vB = fillVbox();       
        setCenter(vB);
       
        HBox debuttons = new HBox(10);
        HBox bovenkant = new HBox(480);
        bovenkant.setPadding(new Insets(10,0,40,10));
        bovenkant.getChildren().addAll(label,debuttons);
        setTop(bovenkant);        
  
        
		//Haalt gegevens uit het venster "toevoegen" en maakt een nieuwe klant in de list
        toevoegen = new Button ("Toevoegen");
        toevoegen.setPrefWidth(100);
        toevoegen.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle (ActionEvent e){
        		kT.showAndWait();
        	}
        });
        //Ophalen van de gegevens uit de TextFields van KlantenToevoegPanel
    	(kT).opslaan.setOnAction(new EventHandler <ActionEvent>(){
			public void handle (ActionEvent e){	
				 
				 Klant k = new Klant(
						(kT).naam.getText(),
						(kT).adres.getText(),
						(kT).geboortedatum.getText(),
						(kT).telefoonnummer.getText(),
						(kT).postcode.getText(),
						(kT).email.getText(),
						(kT).cB.isSelected()
						);
				 hetBedrijf.voegKlantToe(k);
				 	 refresh();
				 	 (kT).close();
				 	 (kT).naam.setText("");
				 	 (kT).adres.setText("");
				 	 (kT).geboortedatum.setText("");
				 	 (kT).telefoonnummer.setText("");
				 	 (kT).postcode.setText("");
				 	 (kT).email.setText("");
				 	 (kT).cB.setSelected(false);
				 	}						
		});
    	 wijzigen = new Button ("Wijzigen");
         wijzigen.setPrefWidth(100);
         wijzigen.setOnAction(e -> {
         	//kW.showAndWait();
         	KlantenWijzigPanel kW = new KlantenWijzigPanel(ms, b, this);
         }); 
    	debuttons.getChildren().addAll(wijzigen,toevoegen);
	}
	//Aanmaken van de "Tabellen"
	public VBox fillVbox(){
		VBox vB = new VBox();
		HBox gegevens = new HBox();
        Label naam = new Label ("Naam");
        naam.setPrefWidth(100);
        Label adres = new Label ("Adres");
        adres.setPrefWidth(120);
        Label geboortedatum = new Label ("Geboortedatum");
        geboortedatum.setPrefWidth(100);
        Label telnummer = new Label ("Telfoonnummer");
        telnummer.setPrefWidth(100);
        Label postcode = new Label ("Postcode");
        postcode.setPrefWidth(75);
        Label email = new Label ("Email");
        email.setPrefWidth(165);
        Label herinneringsbrief = new Label ("Herinneringsbrief");
        herinneringsbrief.setPrefWidth(100);
        gegevens.setStyle("-fx-font-weight: bold;-fx-font-size: 10");
        gegevens.getChildren().addAll(naam,adres,geboortedatum,telnummer,postcode,email,herinneringsbrief);
        vB.getChildren().add(gegevens); 
       
        
        for (Klant k : hetBedrijf.getAlleKlanten()){
        	     klant = new HBox(7);
        	     Label l1 = new Label (k.getNaam());
        	     l1.setPrefWidth(95);
        	     Label l2 = new Label (k.getAdres());
        	     l2.setPrefWidth(120);
        	     Label l3 = new Label (k.getGeboortedatum());
        	     l3.setPrefWidth(90);
        	     Label l4 = new Label (k.getTelefoonnummer());
        	     l4.setPrefWidth(90);
        	     Label l5 = new Label (k.getPostcode());
        	     l5.setPrefWidth(70);
        	     Label l6 = new Label (k.getEmailadres());
        	     l6.setPrefWidth(160);
        	     Label l7 = new Label (k.wiltHerinnering());
        	     l7.setPrefWidth(100);
        	     klant.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7);
        	     klant.setPadding(new Insets(10,0,0,0));
        	     vB.getChildren().add(klant);
        	     setCenter(vB);
        	}
        vB.setSpacing(5);
        vB.setPadding(new Insets(0,0,0,30));
		
		return vB;
	}
	
	public void refresh() {
		setCenter(null);
		VBox vB = fillVbox();
		setCenter(vB);
	}	
}