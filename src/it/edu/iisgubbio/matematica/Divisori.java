package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Divisori extends Application {

	Label lNumero = new Label();
	TextField cNumero = new TextField();
	Label lDivisori = new Label();
	Button pCalcolaDivisori = new Button();

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lNumero.setText("Numero:");
		pCalcolaDivisori.setText("Divisori");
		griglia.add(lNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(pCalcolaDivisori, 0, 1, 2, 1);
		griglia.add(lDivisori, 0, 2, 2, 1);
		pCalcolaDivisori.setOnAction(e -> divisori());

		Scene scena = new Scene(griglia, 220, 100);
		pCalcolaDivisori.setMinWidth(220);

		finestra.setTitle("Divisori");
		finestra.setScene(scena);
		finestra.show();

	}

	public void divisori() {
		
		String numeroStr, divisori;
		int numero, contatore;
		divisori = "";
		numeroStr = cNumero.getText();
		numero = Integer.parseInt(numeroStr);
		for(contatore = 2; contatore < numero; contatore++) {
			if (numero%contatore == 0) {
				if(divisori.equals("")) {
					divisori += contatore;
				}else {
					divisori += ", " + contatore;
				}
			}
		}
		lDivisori.setText(divisori);
	}

	public static void main(String[] args) {
		launch(args);
	}
}