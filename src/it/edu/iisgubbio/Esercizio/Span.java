package it.edu.iisgubbio.Esercizio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Span extends Application {
	
	Button pCiao = new Button();
	Button p2colonne = new Button();
	Button pA = new Button();
	Button pB = new Button();
	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		pCiao.setText("CIAO");
		p2colonne.setText("2 COLONNE");
		pA.setText("A");
		pB.setText("B");
		pCiao.setMaxSize(60, 60);
		p2colonne.setMaxWidth(90);
		pA.setMaxWidth(40);
		pB.setMaxWidth(40);
		
		griglia.add(pCiao, 0, 0, 1, 2);
		griglia.add(p2colonne, 1, 0, 2, 1);
		griglia.add(pA, 1, 1);
		griglia.add(pB, 2, 1);
		
		Scene scena = new Scene(griglia);

		finestra.setTitle("Span");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}