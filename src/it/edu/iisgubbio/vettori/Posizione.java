package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Posizione extends Application {

	TextField cLista = new TextField();
	TextField cNumero = new TextField();
	Label lRisultato = new Label();
	Button pPosizione = new Button("Pos");

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		griglia.add(cLista, 0, 0, 2, 1);
		griglia.add(cNumero, 0, 1);
		griglia.add(pPosizione, 1, 1);
		griglia.add(lRisultato, 0, 3);
		pPosizione.setOnAction(e -> trova());

		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));


		Scene scena = new Scene(griglia,250,120);

		finestra.setTitle("Posizione");
		finestra.setScene(scena);
		finestra.show();


	}


	public void  trova() {
		int inizio;
		int fine;
		int meta;
		int posizioneNumeroTrovato = 0;
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
				posizioneNumeroTrovato = meta;
				break;
			} 
			
			else if (numeri[meta] > numero) {
				fine = meta - 1;
			}
			
			else if (numeri[meta] < numero) {
				inizio = meta + 1;
			}	
		}
		if(posizioneNumeroTrovato == 0) {
			lRisultato.setText("Il Valore " + numero + "non è presente");
		}
		else {
			lRisultato.setText("Il Valore " + numero + " è presente alla posizone " + posizioneNumeroTrovato);
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}