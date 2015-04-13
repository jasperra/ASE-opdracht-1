/*
 * Gemaakt door: Tristan en Roger
 */




package nl.hu.to4.groep5.atd.web.gui;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import DomeinKlassen.*;

public abstract class MyPanel extends BorderPane {
	
	private MyStage myStage;
	private Button terug;
	
	public MyPanel(MyStage mystage){
		//Dit is de Parent classe van onze panels. In deze classe worden alleen de standaard waarde gezet.
		// Daarnaast wordt hier de button terug aangemaakt die elke Child erft en gebruikt.
		myStage = mystage;
		getStylesheets().add("style.css");
		
		terug = new Button("Terug");
		terug.setPrefWidth(125);
		terug.setPrefHeight(50);
		terug.setOnAction(e -> myStage.sceneSetter(0));
		
		VBox vB = new VBox();
		vB.getChildren().add(terug);
		vB.setSpacing(10);
		vB.setPadding(new Insets(10));
		setBottom(vB);
		vB.setAlignment(Pos.BOTTOM_LEFT);
	}
}