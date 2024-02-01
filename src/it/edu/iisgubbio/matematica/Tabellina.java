package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tabellina extends Application {

	Label lNumero = new Label();
	TextField cNumero = new TextField();
	Label lTabellina = new Label();
	Button pTabellina = new Button();

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lTabellina.setText("Tabellina:");
		lNumero.setText("Numero:");
		pTabellina.setText("Tabellina");
		griglia.add(lNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(pTabellina, 0, 1, 2, 1);
		griglia.add(lTabellina, 0, 2, 2, 1);
		pTabellina.setOnAction(e -> tabellina());

		Scene scena = new Scene(griglia, 240, 100);
		scena.getStylesheets().add("it/edu/iisgubbio/matematica/StileTabellina.css");
		griglia.setId("gridpane-spazio");
		pTabellina.setMinWidth(220);

		finestra.setTitle("Tabellina");
		finestra.setScene(scena);
		finestra.show();

	}

	public void tabellina() {
		String numeroStr, sequenza;
		int numero, contatore;
		sequenza = "0";
		numeroStr = cNumero.getText();
		numero = Integer.parseInt(numeroStr);
		for(contatore = 1; contatore <= 10; contatore++) {
			sequenza += ", " + numero*contatore;
			lTabellina.setText(sequenza);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}