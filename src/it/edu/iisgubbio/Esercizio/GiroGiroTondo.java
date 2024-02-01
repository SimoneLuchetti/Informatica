package it.edu.iisgubbio.Esercizio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GiroGiroTondo extends Application {
	
	TextField cPrimaParola = new TextField();
	TextField cSecondaParola = new TextField();
	TextField cTerzaParola = new TextField();
	TextField cQuartaParola = new TextField();
	TextField cQuintaParola = new TextField();
	TextField cSestaParola = new TextField();
	TextField cSettimaParola = new TextField();
	TextField cOttavaParola = new TextField();
	Button pGira = new Button();

	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		pGira.setText("GIRA");
		cPrimaParola.setPromptText("Inserisci Prima Parola");
		cSecondaParola.setPromptText("Inserisci Seconda Parola");
		cTerzaParola.setPromptText("Inserisci Terza Parola");
		cQuartaParola.setPromptText("Inserisci Quarta Parola");
		cQuintaParola.setPromptText("Inserisci Quinta Parola");
		cSestaParola.setPromptText("Inserisci Sesta Parola");
		cSettimaParola.setPromptText("Inserisci Settima Parola");
		cOttavaParola.setPromptText("Inserisci Ottava Parola");
		griglia.add(cPrimaParola, 0, 0);
		griglia.add(cOttavaParola, 0, 1);
		griglia.add(cSettimaParola, 0, 2);
		griglia.add(cSecondaParola, 1, 0);
		griglia.add(pGira, 1, 1);
		griglia.add(cSestaParola, 1, 2);
		griglia.add(cTerzaParola, 2, 0);
		griglia.add(cQuartaParola, 2, 1);
		griglia.add(cQuintaParola, 2, 2);
		pGira.setOnAction(e -> gira());
		griglia.setHgap(20);
		griglia.setVgap(20);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia);

		finestra.setTitle("Saluta Utente");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	public void gira() {
		String parola1;
		String parola2;
		String parola3;
		String parola4;
		String parola5;
		String parola6;
		String parola7;
		String parola8;
		parola1 = cPrimaParola.getText();
		parola2 = cSecondaParola.getText();
		parola3 = cTerzaParola.getText();
		parola4 = cQuartaParola.getText();
		parola5 = cQuintaParola.getText();
		parola6 = cSestaParola.getText();
		parola7 = cSettimaParola.getText();
		parola8 = cOttavaParola.getText();
		cPrimaParola.setText(parola8);
		cSecondaParola.setText(parola1);
		cTerzaParola.setText(parola2);
		cQuartaParola.setText(parola3);
		cQuintaParola.setText(parola4);
		cSestaParola.setText(parola5);
		cSettimaParola.setText(parola6);
		cOttavaParola.setText(parola7);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}