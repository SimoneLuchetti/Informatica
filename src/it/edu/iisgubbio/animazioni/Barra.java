package it.edu.iisgubbio.animazioni;

import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Barra extends Application{
	
	Label lSimbolo = new Label();
	Label lMillisecondi = new Label();
	Label lOutput = new  Label();
	TextField cSimbolo = new  TextField();
	TextField cMillisecondi = new  TextField();
	Button pStart = new Button("via");
	Timeline timeline;
	int contatore = 0;
	boolean avanti;

	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(lSimbolo, 0, 0);
		griglia.add(lMillisecondi, 0, 1);
		griglia.add(lOutput, 0, 2, 3, 1);
		griglia.add(cSimbolo, 1, 0);
		griglia.add(cMillisecondi, 1, 1);
		griglia.add(pStart, 2, 0);
		pStart.setOnAction(e -> muoviti());
		griglia.setHgap(22); 
		griglia.setVgap(10);

		Scene scene = new Scene(griglia,200,100);
		finestra.setTitle("Barra"); 
		finestra.setScene(scene);
		finestra.show();
		
	}
	public void muoviti(){
		String milliSecondiStr = cMillisecondi.getText();
		int milliSecondi = Integer.parseInt(milliSecondiStr);
		timeline = new Timeline(new KeyFrame(
				Duration.millis(milliSecondi),
				x -> aggiornaTimer()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	public void aggiornaTimer(){
		String simbolo = "";
		for(int contaSimboli = 1; contaSimboli<contatore; contaSimboli++) {
			simbolo = simbolo + cSimbolo.getText();
		}
		
		if(contatore==20) {
			avanti = false;
		}
		if(contatore==0) {
			avanti = true;
		}
		if(avanti==false) {
			contatore--;
		}
		else {
			contatore++;
		}
		
		lOutput.setText(simbolo);

	}

	public static void main(String args[]){
		launch();
	}
}