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

public class DienstWijzigPanel extends Stage{
	
	private Bedrijf hetBedrijf;
	private Dienst d;
	BorderPane panel;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DienstWijzigPanel(Dienst di, DienstenPanel dP, Bedrijf b){
		super(StageStyle.UTILITY);
		d = di;
		hetBedrijf = b;
		panel = new BorderPane();
		
		VBox vB = new VBox(); //Een VBox voor de invoervelden etc.
		HBox hB = new HBox(); //Een HBox voor de menu-buttons onderin.
		
		Label l = new Label("Vul de betreffende gegevens in");
		Label typeLabel = new Label("Type Dienst: ");
		TextField typeTF = new TextField();
		typeTF.setMaxWidth(150);
		typeTF.setEditable(false);
		
		Label datumLabel = new Label("Datum: ");
		TextField datumTF = new TextField(d.getDatum());
		datumTF.setMaxWidth(150);
		datumTF.setEditable(false);
		
		Label klantLabel = new Label("Klant: ");
		TextField klantTF = new TextField(d.getKlantNaam());
		klantTF.setMaxWidth(150);
		klantTF.setEditable(false);
		
		vB.getChildren().addAll(l,typeLabel,typeTF,datumLabel,datumTF,klantLabel,klantTF);
		
		
		
		
		ComboBox monteurBox = new ComboBox();
		TextField aantalBestedeUur = new TextField();
		if(d instanceof Onderhoudsbeurt){//Dit wordt alleen uitgevoerd als het om een onderhoudsbeurt gaat
			typeTF.setText("Onderhoudsbeurt");
			Label monteurLabel = new Label("Monteur: ");
			//Hier wordt de ComboBox gevuld.
			for(Monteur m : hetBedrijf.getAlleMonteurs()){
				monteurBox.getItems().add(m.getNaam()); //Als deze hetzelfde zijn, dan wordt het object getoond in de ComboBox
			}
			monteurBox.setValue(d.getOnderhoudsbeurt().getNaam());
			
			Label aantalUurLabel = new Label("Aantal bestede uur: ");
			aantalBestedeUur.setText("" + ((Onderhoudsbeurt)d).getAantalBestedeUur());
			
			VBox artikelen = fillVBox();
			panel.setRight(artikelen);
			
			Button addArtikel = new Button("Artikel Toevoegen");
			addArtikel.setOnAction(e -> {
				GebruiktArtikelToevoegenPanel gAtP = new GebruiktArtikelToevoegenPanel(d, this, hetBedrijf);
			}); //Een popup waar je "Gebruike Artikelen" toevoegt aan de onderhoudsbeurt.
			
			vB.getChildren().addAll(monteurLabel,monteurBox, addArtikel, aantalUurLabel, aantalBestedeUur);
		}
		ComboBox brandstofBox = new ComboBox();
		TextField aantalLTF = new TextField();
		if(d instanceof TankDienst){//Dit wordt alleen uitgevoerd als het om een tankdienst gaat
			typeTF.setText("Tankdienst");
			Label brandstofLabel = new Label("Brandstoftype (Alleen bij tanken): ");
			//Hier wordt de ComboBox gevuld.
			for(Artikel a : hetBedrijf.getAlleArtikelen()){
				if(a.getType().equals("Brandstof")){
					brandstofBox.getItems().add(a.getCode()); //Als deze hetzelfde zijn, dan wordt het object getoond in de ComboBox
				}
			}
			brandstofBox.setValue(((TankDienst)d).getDeBrandstof());
			Label aantalLabel = new Label("Aantal Liter");
			aantalLTF.setText("" + ((TankDienst)d).getAantalLiter());
			aantalLTF.setMaxWidth(100);
			vB.getChildren().addAll(brandstofLabel,brandstofBox,aantalLabel,aantalLTF);
		}
		TextField aantalUTF = new TextField();
		if(d instanceof ParkeerDienst){ //Dit wordt alleen uitgevoerd als het om een parkeerdienst gaat
			typeTF.setText("Parkeerdienst");
			Label aantalLabel = new Label("Aantal uur");
			aantalUTF.setText("" + ((ParkeerDienst)d).getAantalUur());
			aantalUTF.setMaxWidth(100);
			vB.getChildren().addAll(aantalLabel,aantalUTF);
		}
		
		Button b1 = new Button("Bevestigen");
		b1.setOnAction(event -> {
			/*
			 * De volgende code ziet er misschien ingewikkeld uit, maar dit valt best mee,
			 * Er wordt eerst gekeken om wat voor dienst het gaat.
			 * Vervolgens worden alle ingevulde wijzigingen eerst gecontroleerd voordat ze uiteindelijk worden opgeslagen.
			 */
			if(d instanceof Onderhoudsbeurt){
				System.out.println("Onderhoudsbeurt");
				if(monteurBox.getValue() != null){
					Monteur tempM = null;
					for(Monteur m : hetBedrijf.getAlleMonteurs()){
						if(m.getNaam().equals(monteurBox.getValue())){
							tempM = m;
						}
					}
					String s = aantalBestedeUur.getText();
					System.out.println(aantalBestedeUur.getText());
					if(!s.contains("[^0-9]") && !s.equals("")){
						int n = Integer.parseInt(s);//Veilig parsen
						((Onderhoudsbeurt) d).setAantalBestedeUur(n);
						((Onderhoudsbeurt) d).setDeMonteur(tempM);
						dP.refresh();
						close();
					}
				}
			}
			if(d instanceof TankDienst){
				System.out.println("TankDienst");
				if(brandstofBox.getValue() != null){
					Artikel tempA = null;
					for(Artikel a : hetBedrijf.getAlleArtikelen()){
						if(a.getCode().equals(brandstofBox.getValue())){
							tempA = a;
						}
					}
					String s = aantalLTF.getText();
					if(!s.contains("[^0-9]") && !s.equals("")){
						int n = Integer.parseInt(s);//Veilig parsen
						((TankDienst)d).setDeBrandstof(n, tempA);
						dP.refresh();
						close();
					}
				}
			}
			if(d instanceof ParkeerDienst){
				System.out.println("ParkeerDienst");
				String s = aantalUTF.getText();
				if(!s.contains("[^0-9]") && !s.equals("")){
					int n = Integer.parseInt(s);//Veilig parsen
					((ParkeerDienst) d).setAantalUur(n);
					dP.refresh();
					close();
				}
			}
		});
		Button b2 = new Button("Cancel");
		b2.setOnAction(event -> {
			close();//Cancelbutton die het venster sluit, zonder iets op te slaan.
		});
		
		vB.setSpacing(2);
		vB.setPadding(new Insets(10));
		hB.getChildren().addAll(b1,b2);
		hB.setPadding(new Insets(10));
		panel.setLeft(vB);
		panel.setBottom(hB);
		
		Scene scene = new Scene(panel,300,400);
		setScene(scene);
		setTitle("Dienst Wijzigen");
		setResizable(false);
		show();
	}
	
	public VBox fillVBox(){//Het overzicht van de gebruikte artikelen die bij de dienst horen
		VBox vB = new VBox();
		Label l = new Label("Gebruikte Artikelen:");
		vB.getChildren().add(l);
		for(GebruikteArtikelen ga : d.getOnderhoudsbeurt().getGebruikteArtikelen()){
			Label lab = new Label("" + ga);
			vB.getChildren().add(lab);
		}		
		vB.setPadding(new Insets(220,5,5,10));
		return vB;
	}
	
	public void refresh(){ //refresht de VBox met daarin het overzicht van de gebruikte artikelen
		panel.setRight(null);
		VBox vb = fillVBox();
		panel.setRight(vb);
	}
}
