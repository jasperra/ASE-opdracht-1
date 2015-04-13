/*
 * Gemaakt door: Tristan en Roger
 */




package nl.hu.to4.groep5.atd.web.gui;
import nl.hu.to4.groep5.atd.web.domain.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class MenuPanel extends MyPanel implements EventHandler<ActionEvent>{
	
	private Button[] menuButtons;
	private MyStage myStage;
	
	public MenuPanel(MyStage ms){
		super(ms);
		myStage = ms;
		setId("MenuPanel");
		
		//Alle menu-items in het hoofdmenu, deze worden toegevoegd in een HBox, de HBox wordt op het panel weergegeven
		menuButtons = new Button[5];
		menuButtons[0] = new Button("Voorraadbeheer");
		menuButtons[1] = new Button("Agenda");
		menuButtons[2] = new Button("Facturen");
		menuButtons[3] = new Button("Klanten");
		menuButtons[4] = new Button("Parkeren");
		for(int i = 0 ; i < 5 ; i ++){
			menuButtons[i].setPrefWidth(125);
			menuButtons[i].setPrefHeight(50);
			menuButtons[i].setOnAction(this);
		}
		
		VBox vB = new VBox();
		vB.getChildren().addAll(menuButtons);
		vB.setSpacing(10);
		vB.setPadding(new Insets(10));
		setRight(vB);
		setBottom(null);
		vB.setAlignment(Pos.CENTER_RIGHT);
	}
	
	public void handle(ActionEvent e) {
		// Hier worden gekeken welk scherm moet worden gevuld op de scene.
		if(e.getSource() == menuButtons[0]){
			myStage.sceneSetter(1);
		}
		if(e.getSource() == menuButtons[1]){
			myStage.sceneSetter(2);
		}
		if(e.getSource() == menuButtons[2]){
			myStage.sceneSetter(3);
		}
		if(e.getSource() == menuButtons[3]){
			myStage.sceneSetter(4);
		}
		if(e.getSource() == menuButtons[4]){
			myStage.sceneSetter(5);
		}
	}
}
