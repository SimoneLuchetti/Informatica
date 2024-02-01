package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Somma extends Application {

	TextField cNumeri = new TextField();
	Label lRisultato = new Label();
	Label lCrescente = new Label();
	Button pSomma = new Button();
	Button pVerifica = new Button();
	int numeri[];



	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		pSomma.setText("Somma");
		pVerifica.setText("Verifica");
		griglia.add(cNumeri, 0, 0);
		griglia.add(pSomma, 0, 1);
		griglia.add(lRisultato, 0, 2);
		griglia.add(pVerifica, 0, 3);
		griglia.add(lCrescente, 0, 4);
		pSomma.setOnAction(e -> somma());
		pVerifica.setOnAction(e -> verifica());
		pSomma.setMinWidth(300);
		cNumeri.setMinWidth(300);
		lRisultato.setMinWidth(300);
		pVerifica.setMinWidth(300);
		lCrescente.setMinWidth(300);



		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));


		Scene scena = new Scene(griglia,320,300);

		finestra.setTitle("Nuotatori");
		finestra.setScene(scena);
		finestra.show();


	}


	public void  somma() {
		String numeriStr = cNumeri.getText();
		if(numeriStr.equals("")) {
			lRisultato.setText("Numeri Mancanti");
		}
		else {
			String[] vNumeriStr = numeriStr.split(" ");
			numeri = new int [vNumeriStr.length];
			int somma = 0;
			for(int i=0; i<numeri.length; i++) {
				numeri[i] = Integer.parseInt(vNumeriStr[i]);
				somma += numeri[i];
			}

			lRisultato.setText(somma + "");
		}

	}

	public void  verifica() {

		String numeriStr = cNumeri.getText();
		String[] vNumeriStr = numeriStr.split(" ");
		numeri = new int [vNumeriStr.length];
		for(int i=0; i<numeri.length; i++) {
			numeri[i] = Integer.parseInt(vNumeriStr[i]);
		}	

		int somma = 0;
		boolean presenteDecrescente = false;
		boolean presenteCrescente = false;
		for(int i=1; i<numeri.length && !presenteDecrescente; i++) {
			if(numeri[i]<=numeri[i-1]) {
				presenteDecrescente = true;
			}
		}

		for(int i=0; i<numeri.length-1 && !presenteCrescente; i++) {
			if(numeri[i]<numeri[i+1]) {
				presenteCrescente = true;
			}
		}
		if(!presenteDecrescente) {
			lCrescente.setText("L'ordine è crescente.");
		} else {
			if(!presenteCrescente) {
				lCrescente.setText("L'ordine è decrescente.");
			} else {
				lCrescente.setText("Il vettore non è ordinato.");
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}