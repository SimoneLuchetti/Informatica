package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Primi extends Application {

	Label lNumero = new Label();
	TextField cNumero = new TextField();
	Label lPrimo = new Label();
	Button pCalcolaPrimo = new Button();

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lNumero.setText("Numero:");
		pCalcolaPrimo.setText("Primo");
		griglia.add(lNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(pCalcolaPrimo, 0, 1, 2, 1);
		griglia.add(lPrimo, 0, 2, 2, 1);
		pCalcolaPrimo.setOnAction(e -> primi());
		Scene scena = new Scene(griglia, 220, 100);
		pCalcolaPrimo.setMinWidth(220);

		finestra.setTitle("Primi");
		finestra.setScene(scena);
		finestra.show();

	}

	public void primi() {
		
		String numeroStr;
		int numero, contatore, contaDiv = 0;
		numeroStr = cNumero.getText();
		numero = Integer.parseInt(numeroStr);
		for(contatore = 1; contatore <= numero; contatore++) {
			if(numero%contatore==0) {
				contaDiv += 1;
			}
		}
		if(contaDiv > 2) {
			lPrimo.setText("Il numero non è primo");
		}else {
			lPrimo.setText("Il numero è primo");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}