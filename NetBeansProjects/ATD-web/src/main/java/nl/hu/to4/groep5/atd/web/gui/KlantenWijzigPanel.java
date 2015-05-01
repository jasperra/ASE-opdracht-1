/*
 * Gemaakt door: Thijs
 */




package nl.hu.to4.groep5.atd.web.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import nl.hu.to4.groep5.atd.web.domain.*;

public class KlantenWijzigPanel extends Stage{
	TextField naam;
	TextField adres;
	TextField geboortedatum;
	TextField telefoonnummer;
	TextField postcode;
	TextField email;
	CheckBox cB ;
	Label nm, ad, gd,tn,pc,em, hbrief;
	Button terug;
	Button opslaan;
	Bedrijf hetBedrijf;
	
	public KlantenWijzigPanel (MyStage ms, Bedrijf b, KlantenPanel p){
		super(StageStyle.UTILITY);
		hetBedrijf = b;
		Label knm = new Label ("Klant: ");
		ComboBox  cb = new ComboBox ();		
		cb.setPrefWidth(140);
		cB = new CheckBox();		
		cB.setSelected(false);
		hbrief = new Label ("Herinneringsbrief: ");
		nm = new Label ("Naam: ");
		naam = new TextField();
		ad = new Label ("Adres: ");
		adres = new TextField ();
		gd = new Label ("Geboortedatum: ");
		geboortedatum = new TextField ();
		tn = new Label ("Telefoonnummer: ");
		telefoonnummer = new TextField();
		pc = new Label ("Postcode: ");
		postcode = new TextField ();
		em = new Label ("Emailadres: ");
		email = new TextField ();
		
		terug = new Button ("Terug");
		terug.setPrefWidth(100);
		terug.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				close();				
			}
			
		});
		//Combobox vullen
		for (Klant k : hetBedrijf.getAlleKlanten()){	
			cb.getItems().add(k.getNaam());	
		}	
		//Na op de knop opslaan te hebben gedrukt bekijkt hij welke value er uit de combobox gehaald is.
		opslaan = new Button ("Opslaan");
		opslaan.setPrefWidth(100);
		opslaan.setOnAction (new EventHandler <ActionEvent>(){
			public void handle (ActionEvent e){
				//Hier kijkt hij of de value uit de combobox overeen komt met k.getNaam()
				if (cb.getValue() != null){
					Klant tempK = null;
					for(Klant k : hetBedrijf.getAlleKlanten()){
						if(k.getNaam().equals(cb.getValue())){
							tempK = k;
						}
					}
					//En vervangt hij, indeed de TextField niet leeg is, de Sting van bijv. Naam met het uit het TextField opgehaald stuk String
					if (!naam.getText().equals("")){
						String s = naam.getText();
						tempK.setNaam(s); 											
					}
					if (!adres.getText().equals("")){
						String s = adres.getText();
						//tempK.setAdres(s); 	
											
					}
					if (!geboortedatum.getText().equals("")){
						String s = geboortedatum.getText();
						//tempK.setGeboortedatum(s); 						
					}
					if (!telefoonnummer.getText().equals("")){
						String s = telefoonnummer.getText();
						tempK.setTelefoonnummer(s); 					
					}
					if (!postcode.getText().equals("")){
						String s = postcode.getText();
						tempK.setPostcode(s); 						
					}
					if (!email.getText().equals("")){
						String s = email.getText();
						tempK.setEmailadres(s); 						
					}
					tempK.setWiltHerinnering(cB.isSelected());
					
				}
				//Hij sluit KlantenWijzigPanel af en refreshed KlantenPanel
				close();
				p.refresh();
			}			
		});
				
		HBox hbox = new HBox();
		hbox.getChildren().addAll(terug,opslaan);
		hbox.setSpacing(10);
		hbox.setPadding(new Insets(5));
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox Vb = new VBox ();
		Vb.getChildren().addAll(knm,nm,ad,gd,tn,pc,em, hbrief);
		Vb.setSpacing(12);
		Vb.setPadding(new Insets (6,0,0,0));
		VBox vB = new VBox ();
		vB.getChildren().addAll(cb,naam,adres,geboortedatum,telefoonnummer,postcode,email, cB);
		vB.setSpacing(5);
		vB.setAlignment(Pos.TOP_CENTER);
		
		FlowPane panel = new FlowPane ();
		panel.setAlignment(Pos.CENTER);
		panel.setPadding(new Insets(5));
		panel.getChildren().addAll(Vb,vB, hbox);
		
		Scene scene = new Scene(panel,280,280);
		this.setScene(scene);
		show();
	}
}