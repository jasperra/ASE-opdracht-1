
package nl.hu.to4.groep5.atd.web.gui;
import java.io.Serializable;
import java.util.ArrayList;

import nl.hu.to4.groep5.atd.web.domain.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class ParkeerPanel extends MyPanel implements EventHandler<ActionEvent>{
     
    private MyStage myStage;
    private Bedrijf hetBedrijf;
    private VBox vbox = new VBox();
    private ParkeerPlaats deParkeerplaats = new ParkeerPlaats();
    private Button plek;
    private Button vertrek;
    private Button nieuw;
    private TableView<ParkeerPlaats> tabel = new TableView<ParkeerPlaats>();
    private Label vrij;
    private Label bezet;
    private Label lab, lab2;
    private int nieuwgetal = 1;
     
    public ParkeerPanel(MyStage ms, Bedrijf b){
        super(ms);
        hetBedrijf = b;
        setId("ParkeerPanel");
        BorderPane panel = new BorderPane();
         
        //Hier worden de buttons en labels aangemaakt
        plek = new Button("Plek reserveren");
        plek.setOnAction(this);
        vertrek = new Button("Plek komt vrij");
        vertrek.setOnAction(this);
        vrij = new Label("Er zijn nog vrij: " + deParkeerplaats.aantalVrij());
        vrij.setFont(Font.font("Arial", 20));
        bezet = new Label("Er zijn bezet: " + deParkeerplaats.getAantalbezet());
        bezet.setFont(Font.font("Arial", 20));
        lab = new Label("");
        lab.setFont(Font.font("Arial", 15));
        lab2 = new Label("");
        lab2.setFont(Font.font("Arial", 25));
        nieuw = new Button("Nieuwe reservering");
        nieuw.setOnAction(this);
        
         
        //Hier worden de knoppen en labels toegevoegd aan de VBOX
        vbox.getChildren().addAll(plek, vertrek, vrij, bezet, lab, lab2, nieuw);
         
        //Hier wordt de vbox ingesteld, hij komt links van het midden met ruimte tussen de attributen en ruimte vanaf de rand
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(10,10,10,10));
         
        setCenter(panel);
        panel.setCenter(vbox);
    }
     
    public void handle(ActionEvent e){
         
        // Hier wordt beschreven wat er gebeurt zodra de knop 'plek' wordt ingedrukt
        if(e.getSource() == plek){
            if(deParkeerplaats.isPlaats() == true){
                deParkeerplaats.voegToe();
                lab.setText("er is nog plaats en er is gereserveerd, aantal gereserveerd is nu " + deParkeerplaats.getAantalbezet());   
                bezet.setText("Er zijn bezet: " + deParkeerplaats.getAantalbezet());
                vrij.setText("Er zijn  nog vrij: " + deParkeerplaats.aantalVrij());
                plek.setDisable(true);
                
        }
            else{
                lab.setText("Er is helaas geen plek en er is niet gereserveerd");
            }
         
        }
     
        // Hier wordt beschreven wat er gebeurt zodra de knop 'vertrek' wordt ingedrukt
        if(e.getSource() == vertrek){
            if(deParkeerplaats.isBezet() == true){
                deParkeerplaats.vertrek();
                lab.setText("er is iemand vertrokken, aantal gereserveerd is nu " + deParkeerplaats.getAantalbezet());
                bezet.setText("Er zijn bezet: " + deParkeerplaats.getAantalbezet());
                vrij.setText("Er zijn  nog vrij: " + deParkeerplaats.aantalVrij());
            }
            else{
                lab.setText("Niemand is vertrokken");
            }
        }
         
        //Hier een nieuwe reservering worden gemaakt
        if(e.getSource() == nieuw){
        	plek.setDisable(false);
        	
        }
    }   
}