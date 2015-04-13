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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KlantenToevoegPanel extends Stage{
	TextField naam;
	TextField adres;
	TextField geboortedatum;
	TextField telefoonnummer;
	TextField postcode;
	TextField email;
	CheckBox cB ;
	Label nm, ad, gd,tn,pc,em, hbrief, bezet;
	Button terug;
	Button opslaan;
	

	
	public KlantenToevoegPanel (MyStage ms){
		super();
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
		opslaan = new Button ("Opslaan");
		opslaan.setPrefWidth(100);
			
		HBox hbox = new HBox();
		hbox.getChildren().addAll(terug,opslaan);
		hbox.setSpacing(10);
		hbox.setPadding(new Insets(20,0,0,0));
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox Vb = new VBox ();
		Vb.getChildren().addAll(nm,ad,gd,tn,pc,em, hbrief);
		Vb.setSpacing(12);
		Vb.setPadding(new Insets (6,0,0,0));
		VBox vB = new VBox ();
		vB.getChildren().addAll(naam,adres,geboortedatum,telefoonnummer,postcode,email, cB);
		vB.setSpacing(5);
		vB.setAlignment(Pos.TOP_CENTER);
		
		FlowPane panel = new FlowPane ();
		panel.setAlignment(Pos.CENTER);
		panel.setPadding(new Insets(5));
		panel.getChildren().addAll(Vb,vB, hbox);
		

		
		Scene scene = new Scene(panel,280,260);
		this.setScene(scene);
	}

}


