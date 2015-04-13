/*
 * Gemaakt door: Tristan en Roger
 */




package nl.hu.to4.groep5.atd.web.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.*;
import nl.hu.to4.groep5.atd.web.domain.*;

public class VoorraadWijzigPanel extends Stage{
	
	private Bedrijf hetBedrijf;
	
	public VoorraadWijzigPanel(Bedrijf b, String type, VoorraadbeheerPanel p){
		super(StageStyle.UTILITY);
		hetBedrijf = b;
		BorderPane panel = new BorderPane();
		
		VBox vb = new VBox(); //Een VBox voor de invoervelden etc.
		HBox hb = new HBox(); //Een HBox voor de menu-buttons onderin.
		
		Label lr1 = new Label("Type :");
		TextField tfr1 = new TextField(type); //Hier wordt het soort ingevuld.
		tfr1.setEditable(false); //Dit kan niet gewijzigd worden.
		Label lr2 = new Label("Code :");
		ComboBox cb = new ComboBox();
		//Hier wordt de ComboBox gevuld.
		for(Artikel v : hetBedrijf.getAlleArtikelen()){
			if(v.getType().equals(type)){//Hier wordt de geselecteerde soort vergeleken met de soort van het voorraad-object.
				cb.getItems().add(v.getCode()); //Als deze hetzelfde zijn, dan wordt het object getoond in de ComboBox
			}
		}
		Label lr3 = new Label("Aantal :");
		TextField tfr2 = new TextField("");
		//Hier wordt de 'Bevestigen' button toegevoegd.
		//Ook wordt hier gecontroleerd op verschillende fouten gegevens voor de nieuwe voorraad.
		Button br1 = new Button("Bevestigen");
		br1.setOnAction(event -> {
			if(cb.getValue() != null){
				if(!tfr2.getText().equals("")){
					String s = tfr2.getText();
					s = s.replaceAll("[^0-9]", ""); //Alle niet cijfers worden uit de String gehaalt.
					int n = 0;
					if(!s.equals("")){ //De String mag niet leeg zijn
						try {
							n = Integer.parseInt(s);
							System.out.println(n);
						}
						catch (NumberFormatException e2){
							tfr2.setText("Waarde is te groot"); //De waarde mag niet te groot zijn voor een int (Dit zou ook onrealistisch zijn om zomaar te bestellen).
							System.out.println("Waarde is te groot");
						}
						//Waarde 'n' toevoegen als echte waarde
						for(Artikel a : hetBedrijf.getAlleArtikelen()){
							System.out.println("in for");
							if(a.getType().equals(type) && a.getCode().equals(cb.getValue())){
								System.out.println("in if");
								//De waarde wordt bij het juiste voorraadobject toegevoegd.
								a.setAantal(n);
								p.refresh();
								close();
								//Het voorraadoverzicht wordt gerefresht en dit scherm wordt afgesloten.
							}
						}
					}
					else{
						tfr2.setText("Waarde moet getal zijn");
						System.out.println("Waarde moet getal zijn");
					}
				}
				else{
					tfr2.setText("Vul hier een waarde in");
					System.out.println("Vul hier een waarde in");
				}
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
		vb.getChildren().addAll(lr1,tfr1,lr2,cb,lr3,tfr2);
		
		
		Scene scene = new Scene(panel,200,200);
		setScene(scene);
		setTitle(type);
		setResizable(false);
		show();
	}
}
