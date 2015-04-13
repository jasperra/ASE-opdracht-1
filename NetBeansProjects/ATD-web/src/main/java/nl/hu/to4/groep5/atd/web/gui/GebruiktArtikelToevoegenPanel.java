/*
 * Gemaakt door: Tristan en Roger
 */




package nl.hu.to4.groep5.atd.web.gui;
import java.time.*;
import java.time.format.*;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import DomeinKlassen.*;

public class GebruiktArtikelToevoegenPanel extends Stage{
	
	private Bedrijf hetBedrijf;
	
	public GebruiktArtikelToevoegenPanel(Dienst d, DienstWijzigPanel dWP, Bedrijf b){
		super(StageStyle.UTILITY);
		hetBedrijf = b;
		FlowPane panel = new FlowPane();
		
		VBox vB = new VBox(); //Een VBox voor de invoervelden etc.
		vB.setPrefWidth(300);
		HBox hB = new HBox(); //Een HBox voor de menu-buttons onderin.
		
		Label l = new Label("Artikel en aantal: ");
		ComboBox artikelen = new ComboBox();
		// Hier gaan we de combobox vullen met alle artikelen behalve brandstof.
		// getCode geeft de naam van het product weer.
		for(Artikel a : hetBedrijf.getAlleArtikelen()){
			if(!a.getType().equals("brandstof")){
				artikelen.getItems().add(a.getCode());
			}
		}		
		TextField aantal = new TextField();
		aantal.setMaxWidth(75);
		
		Button b1 = new Button("Bevestigen");
		b1.setOnAction(event -> {
			// Hier worden een innerklasse gemaakt en wanneer de naam van het artikel hetzelfde is als
			// het lijstje dan zetten we het tijdelijke Artikel daarop. Hier werken we vervolgens mee verder.
			if(artikelen.getValue() != null){
				Artikel tempA = null;
				for(Artikel a : hetBedrijf.getAlleArtikelen()){
					if(a.getCode().equals(artikelen.getValue())){
						tempA = a;
					}
				}
				String s = aantal.getText();
				// Hier wordt het Artikel toegevoegd aan de onderhoudsbeurt.
				if(!s.contains("[^0-9]") && !s.equals("")){
					int n = Integer.parseInt(s);
					d.getOnderhoudsbeurt().voegArtikelToe(tempA, n);
					dWP.refresh();
					close();
				}
			}
		});
		
		vB.setSpacing(2);
		vB.setPadding(new Insets(10));
		vB.getChildren().addAll(l,artikelen,aantal);
		hB.getChildren().addAll(b1);
		hB.setPadding(new Insets(10));
		panel.getChildren().addAll(vB,hB);
		
		Scene scene = new Scene(panel,300,400);
		setScene(scene);
		setTitle("Dienst Wijzigen");
		setResizable(false);
		show();
	}
}
