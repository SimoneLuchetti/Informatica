package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LuchettiSimoneMCD extends Application {

	Label lPrimoNumero = new Label();
	Label lSecondoNumero = new Label();
	Label lRisultato = new Label();
	TextField cPrimoNumero = new TextField();
	TextField cSecondoNumero = new TextField();
	Button pCalcola = new Button();

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lPrimoNumero.setText("primo numero:");
		lSecondoNumero.setText("secondo numero:");
		pCalcola.setText("Calcola");
		lRisultato.setText("risultato");
		griglia.add(lPrimoNumero, 0, 0);
		griglia.add(lSecondoNumero, 0, 1);
		griglia.add(pCalcola, 0, 2);
		griglia.add(cPrimoNumero, 1, 0);
		griglia.add(cSecondoNumero, 1, 1);
		griglia.add(lRisultato, 1, 2);
		pCalcola.setOnAction(e -> calcola());

		Scene scena = new Scene(griglia, 290, 120);
		
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));

		finestra.setTitle("Massimo Comune Divisore");
		finestra.setScene(scena);
		finestra.show();
	}

	public void calcola() {
		String primoNumeroStr = cPrimoNumero.getText();
		String secondoNumeroStr = cSecondoNumero.getText();
		int primoNumero = Integer.parseInt(primoNumeroStr);
		int secondoNumero = Integer.parseInt(secondoNumeroStr);
		int numeroMinore;
		int risultato = 0;
		if(primoNumero<secondoNumero) {
			numeroMinore = primoNumero;
		}else {
			numeroMinore = secondoNumero;
		}
		for(int divisore = 1; divisore<=numeroMinore; divisore++) {
			if(primoNumero%divisore==0 && secondoNumero%divisore==0) {
				risultato = divisore;
			}
		}
		
		lRisultato.setText("l'MCD è: " + risultato);
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}