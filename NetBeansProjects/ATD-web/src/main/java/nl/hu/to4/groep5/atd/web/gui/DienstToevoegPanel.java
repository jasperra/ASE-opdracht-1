/*
 * Gemaakt door: Tristan en Roger
 */




package nl.hu.to4.groep5.atd.web.gui;
import java.time.LocalDate;

import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import DomeinKlassen.*;

public class DienstToevoegPanel extends Stage{
	
	private Bedrijf hetBedrijf;
	
	public DienstToevoegPanel(DienstenPanel dP, Bedrijf b){
		super(StageStyle.UTILITY);
		setTitle("Nieuwe Dienst");
		hetBedrijf = b;
		FlowPane panel = new FlowPane();
		
		VBox vB = new VBox(); //Een VBox voor de invoervelden etc.
		vB.setPrefWidth(400);
		HBox hB = new HBox(); //Een HBox voor de menu-buttons onderin.
		hB.setPrefWidth(400);
		
		Label l = new Label("Vul de betreffende gegevens in");
		Label typeLabel = new Label("Type Dienst: ");
		ComboBox typeBox = new ComboBox();
		typeBox.getItems().addAll("Onderhoudsbeurt","Tankdienst","Parkeerdienst");
		
		Label datumLabel = new Label("Datum: ");
		DatePicker datumP = new DatePicker();
		
		Label klantLabel = new Label("Klant: ");
		ComboBox klantBox = new ComboBox();
		//Hier wordt de ComboBox gevuld.
		for(Klant k : hetBedrijf.getAlleKlanten()){
			klantBox.getItems().add(k.getNaam());
		}
		
		Label monteurLabel = new Label("Monteur: ");
		ComboBox monteurBox = new ComboBox();
		//Hier wordt de ComboBox gevuld.
		for(Monteur m : hetBedrijf.getAlleMonteurs()){
			monteurBox.getItems().add(m.getNaam()); //Als deze hetzelfde zijn, dan wordt het object getoond in de ComboBox
		}
		
		Label aantalLabel = new Label("Aantal uur/Aantal Liter");
		TextField aantalTF = new TextField();
		aantalTF.setMaxWidth(100);
		
		Label brandstofLabel = new Label("Brandstoftype (Alleen bij tanken): ");
		ComboBox brandstofBox = new ComboBox();
		//Hier wordt de ComboBox gevuld.
		for(Artikel a : hetBedrijf.getAlleArtikelen()){
			if(a.getType().equals("Brandstof")){
				brandstofBox.getItems().add(a.getCode()); //Als deze hetzelfde zijn, dan wordt het object getoond in de ComboBox
			}
		}
		
		Button b1 = new Button("Bevestigen");
		
		b1.setOnAction(event -> {
			l.setStyle("-fx-text-fill: black");
			l.setText("Vul de betreffende gegevens in");
			Dienst d = null;
			
			if(datumP.getValue() == null){
				datumP.setValue(LocalDate.now()); //Als er geen datum is ingevuld, dan voert hij de dag van vandaag in
			}
			LocalDate Date = datumP.getValue();
			//Datum naar String parsen
			String yearS = "" + Date.getYear();
			String monthS = "" + Date.getMonthValue();
			String dayS = "" + Date.getDayOfMonth();
			
			//2e datum naar String parsen, dit is de vervaldatum
			String dayS2 = "01"; //vervaldatum is altijd de 1e dag van de volgendemaand
			String monthS2 = "" + (Date.getMonthValue() +1);
			String yearS2;
			//Als het van december naar januari gaat, moet er wel een jaar bij komen
			if(Date.getMonthValue() > 11){
				yearS2 = "" + Date.getYear() +1;
				monthS2 = "01";
			}
			else{
				yearS2 = "" + Date.getYear();
			}
			
			//Als het om bv. de 1e vd maand gaat, moet er komen te staan 01 ipv 1.
			if(monthS2.length() < 2){
				monthS2 = "0" + monthS2;
			}
			if(monthS.length() < 2){
				monthS = "0" + monthS;
			}
			if(dayS.length() < 2){
				dayS = "0" + dayS;
			}
			
			Klant tempK = null;
			if(klantBox.getValue() != null){
				tempK = null;
				for(Klant k : hetBedrijf.getAlleKlanten()){
					if(k.getNaam().equals(klantBox.getValue())){
						tempK = k;//De juiste klant toevoegen
					}
				}
			}
			if(typeBox.getValue() == null || klantBox.getValue() == null){ //Controleren of alle comboboxen zijn ingevuld
				l.setText("Niet alles is correct ingevuld!");
				l.setStyle("-fx-text-fill: red");
			}
			else if(typeBox.getValue().equals("Onderhoudsbeurt")){ //Kijken of het gaat om een onderhoudsbeurt
				if(klantBox.getValue() != null || monteurBox.getValue() != null){
					System.out.println("Onderhoud geselecteerd");
					Auto tempA = null;
					for(Auto a : hetBedrijf.getAlleAutos()){
						if(a.getDeEigenaarsNaam().equals(klantBox.getValue())){
							tempA = a;
						}
					}
					Monteur tempM = null;
					for(Monteur m : hetBedrijf.getAlleMonteurs()){
						if(m.getNaam().equals(monteurBox.getValue())){
							tempM = m;
						}
					}
					d = new Onderhoudsbeurt(hetBedrijf.getAlleDiensten().size() + 1, dayS+"-"+monthS+"-"+yearS, tempA, tempM);
					System.out.println("Onderhoudsbeurt gemaakt");
					Factuur f = new Factuur(hetBedrijf.getAlleFacturen().size() + 1, dayS+"-"+monthS+"-"+yearS, dayS2+"-"+monthS2+"-"+yearS2, "Onderhoudsbeurt", tempK);
					d.setDeBetaling(f);//Eerst wordt er een dienst gemaakt, vervolgens wordt gelijk de factuur van de dienst opgesteld.
					hetBedrijf.voegFactuurToe(f);
				}
			}
			else if(typeBox.getValue().equals("Tankdienst")){ //Kijken of het gaat om een tankdienst
				if(brandstofBox.getValue() != null){
					System.out.println("Tanken geselecteerd");
					String s = aantalTF.getText();
					if(!s.contains("[^0-9]") && !s.equals("")){
						int n = Integer.parseInt(s);//Veilig parsen naar int
						if(brandstofBox.getValue() != null){
							Artikel tempA = null;
							for(Artikel a : hetBedrijf.getAlleArtikelen()){
								if(a.getCode().equals(brandstofBox.getValue())){
									tempA = a; //Het ophalen en selecteren van het artikel
								}
							}
							d = new TankDienst(hetBedrijf.getAlleDiensten().size() + 1, dayS+"-"+monthS+"-"+yearS,tempA,n);
							System.out.println("Tankdienst gemaakt");
							Factuur f = new Factuur(hetBedrijf.getAlleFacturen().size() + 1, dayS+"-"+monthS+"-"+yearS, dayS2+"-"+monthS2+"-"+yearS2, "Tankdienst", tempK);
							d.setDeBetaling(f);//Ook hier wordt eerst een dienst gemaakt, vervolgens wordt gelijk de factuur van de dienst opgesteld.
							hetBedrijf.voegFactuurToe(f);
							
						}
					}
					else{
						aantalLabel.setText("Aantal liter verkeerd ingevuld");
					}
				}
			}
			else if(typeBox.getValue().equals("Parkeerdienst")){//Kijken of het gaat om een parkeerdienst
				System.out.println("Parkeren geselecteerd");
				String s = aantalTF.getText();
				if(!s.contains("[^0-9]") && !s.equals("")){
					int n = Integer.parseInt(s);//Veilig parsen naar int
					d = new ParkeerDienst(hetBedrijf.getAlleDiensten().size() + 1, dayS+"-"+monthS+"-"+yearS,n);
					System.out.println("Parkeerdienst gemaakt");
					Factuur f = new Factuur(hetBedrijf.getAlleFacturen().size() + 1, dayS+"-"+monthS+"-"+yearS, dayS2+"-"+monthS2+"-"+yearS2, "Parkeerdienst", tempK);
					d.setDeBetaling(f);//Ook hier wordt eerst een dienst gemaakt, vervolgens wordt gelijk de factuur van de dienst opgesteld.
					hetBedrijf.voegFactuurToe(f);
				}
				else {
					aantalLabel.setText("Aantal uur verkeerd ingevuld");
				}
			}
			if(d != null){
				hetBedrijf.voegDienstToe(d);
				System.out.println("Dienst is toegevoegd");
				close();
				dP.refresh();
				//het toevoegen van de dienst aan de arrayList (database).
				//En het afsluiten van het panel en refreshen van het overzicht.
			}
		});
		
		
		
		
		
		
		
		Button b2 = new Button("Cancel");
		b2.setOnAction(event -> {
			close();//Cancelbutton, sluit het scherm af, slaat niks op
		});
		
		vB.getChildren().addAll(l, typeLabel,typeBox, datumLabel, datumP,klantLabel,klantBox,monteurLabel,monteurBox,brandstofLabel, brandstofBox,aantalLabel,aantalTF);
		vB.setSpacing(2);
		vB.setPadding(new Insets(10));
		hB.getChildren().addAll(b1,b2);
		hB.setPadding(new Insets(10));
		panel.getChildren().addAll(vB,hB);
		Scene scene = new Scene(panel,300,400);
		setScene(scene);
		show();
	}
	
}
