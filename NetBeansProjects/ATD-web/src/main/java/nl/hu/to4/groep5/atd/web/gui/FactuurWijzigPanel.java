/*
 * Gemaakt door: Tristan en Roger
 */




package nl.hu.to4.groep5.atd.web.gui;
import java.time.*;
import java.time.format.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import DomeinKlassen.*;

public class FactuurWijzigPanel extends Stage{
	
	private Bedrijf hetBedrijf;
	
	public FactuurWijzigPanel(Factuur f, FactuurPanel fP, Bedrijf b){
		super(StageStyle.UTILITY);
		hetBedrijf = b;
		BorderPane panel = new BorderPane();
		
		VBox vb = new VBox(); //Een VBox voor de invoervelden etc.
		HBox hb = new HBox(); //Een HBox voor de menu-buttons onderin.
		
		Label l1 = new Label("Factuurnummer:");
		TextField tf1 = new TextField("" + f.getFactuurNummer()); //Hier wordt het soort ingevuld.
		tf1.setEditable(false); //Dit kan niet gewijzigd worden.
		Label l2 = new Label("Factuurdatum:");
		TextField tf2 = new TextField("" + f.getFactuurDatum());
		tf2.setEditable(false);
		Label l3 = new Label("Vervaldatum:");
		DatePicker vervalD = new DatePicker();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		vervalD.setValue(LocalDate.parse(f.getVervalDatum(), formatter));
		Label l4 = new Label("Klantnaam:");
		TextField tf4 = new TextField("" +  f.getKlantNaam());
		tf4.setEditable(false);
		Label l5 = new Label("Omschrijving: ");
		TextArea ta5 = new TextArea(f.getOmschrijving());
		
		Label l6 = new Label("Brutoprijs: ");
		TextField pTF = new TextField("" + f.getBrutoPrijs());
		
		CheckBox cb6 = new CheckBox("Factuur is betaald.");
		cb6.setSelected(f.getIsBetaald());
		
		//Hier wordt de 'Bevestigen' button toegevoegd.
		//Ook wordt hier gecontroleerd op verschillende fouten gegevens voor de nieuwe voorraad.
		Button br1 = new Button("Bevestigen");
		br1.setOnAction(event -> {
			l3.setStyle("-fx-text-fill: black");
			l5.setStyle("-fx-text-fill: black");
			l3.setText("Vervaldatum: ");
			l5.setText("Omschrijving: ");
			if(!ta5.getText().equals("") && !pTF.getText().equals("")){
				f.setOmschrijving(ta5.getText());
				LocalDate vervalDate = vervalD.getValue();
				
				String yearS = "" + vervalDate.getYear();
				String monthS = "" + vervalDate.getMonthValue();
				String dayS = "" + vervalDate.getDayOfMonth();
				
				if(monthS.length() < 2){
					monthS = "0" + monthS;
				}
				if(dayS.length() < 2){
					dayS = "0" + dayS;
				}
				f.setIsBetaald(cb6.isSelected());
				f.setVervalDatum(dayS+"-"+monthS+"-"+yearS);
				System.out.println(f.getVervalDatum());
				String s = pTF.getText();
				// hier worden gekeken of er geen andere characters dan 0 tot en met 9,
				// of een "." in zit.
				if(!s.contains("[^0-9.]") && !s.equals("")){
					double n = Double.parseDouble(s);
					f.setBrutoPrijs(n);
					System.out.println("gerefresht");
					fP.refresh();
					close();
				}
			}
			else{
				l5.setText("Omschrijving: Niet alles is juist ingevuld!");
				l5.setStyle("-fx-text-fill: red");
			}
		});
		//Het aanmaken van een cancel button
		Button br2 = new Button("Cancel");
		br2.setOnAction(event -> {
			close();
		});
		//Alles wordt toegevoegd aan het scherm.
		panel.setLeft(vb);
		panel.setBottom(hb);
		hb.getChildren().addAll(br1,br2);
		hb.setAlignment(Pos.CENTER_RIGHT);
		hb.setSpacing(10);
		hb.setPadding(new Insets(10,10,10,10));
		vb.setPadding(new Insets(10,10,10,10));
		vb.setMaxWidth(250);
		vb.getChildren().addAll(l1,tf1,l2, tf2,l3,vervalD,l4,tf4,l5,ta5,l6,pTF);
		if(f.getBrutoPrijs() != 0.0){
			vb.getChildren().add(cb6);
		}
		
		Scene scene = new Scene(panel,400,400);
		setScene(scene);
		setTitle("Factuur Wijzigen");
		setResizable(false);
		show();
	}
}
