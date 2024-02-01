package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Fattoriale extends Application {

	Label lNumero = new Label();
	TextField cNumero = new TextField();
	Button pCalcolaFattoriale = new Button();

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		pCalcolaFattoriale.setText("!");
		griglia.add(cNumero, 0, 0);
		griglia.add(lNumero, 2, 0);
		griglia.add(pCalcolaFattoriale, 1, 0);
		pCalcolaFattoriale.setOnAction(e -> fattoriale());

		Scene scena = new Scene(griglia, 220, 100);
		finestra.setTitle("Fattoriale");
		finestra.setScene(scena);
		finestra.show();

	}

	public void fattoriale() {
		
		String numeroStr;
		int numero, contatore, fattoriale = 1;
		numeroStr = cNumero.getText();
		numero = Integer.parseInt(numeroStr);
		for(contatore = 1; contatore <= numero; contatore++) {
			fattoriale = fattoriale*contatore;
		}
		
		lNumero.setText(""+ fattoriale);

	}

	public static void main(String[] args) {
		launch(args);
	}
}