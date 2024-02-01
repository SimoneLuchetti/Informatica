package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RicercaBinaria extends Application {

	TextField cLista = new TextField();
	TextField cNumero = new TextField();
	Label lRisultato = new Label();
	Button pTrova = new Button("Trova");

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		griglia.add(cLista, 0, 0);
		griglia.add(cNumero, 0, 1);
		griglia.add(pTrova, 0, 2);
		griglia.add(lRisultato, 0, 3);
		pTrova.setOnAction(e -> trova());
		pTrova.setMinWidth(300);
		cLista.setMinWidth(300);
		cNumero.setMinWidth(300);
		lRisultato.setMinWidth(300);

		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));


		Scene scena = new Scene(griglia,320,300);

		finestra.setTitle("Somma Binaria");
		finestra.setScene(scena);
		finestra.show();


	}


	public void  trova() {
		int inizio;
		int fine;
		int meta;
		int numeroTrovato = 0;
		String numeriStr = cLista.getText();
		String numeroStr = cNumero.getText();
		int numero = Integer.parseInt(numeroStr);
		String[] vNumeriStr = numeriStr.split(" ");
		int numeri[] = new int[vNumeriStr.length];
		for(int i = 0; i < numeri.length; i++) {
			numeri[i] = Integer.parseInt(vNumeriStr[i]);
		}
		
		inizio = 0;
		fine = numeri.length - 1;
		
		while(inizio<=fine) {
			
			meta = (fine + inizio) / 2;
			if(numeri[meta] == numero) {
				numeroTrovato = numeri[meta];
				break;
			} 
			
			else if (numeri[meta] > numero) {
				fine = meta - 1;
			}
			
			else if (numeri[meta] < numero) {
				inizio = meta + 1;
			}	
		}
		if(numeroTrovato == 0) {
			lRisultato.setText("Il Valore " + numero + "non è presente");
		}
		else {
			lRisultato.setText("Il Valore " + numeroTrovato + " è presente");
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}