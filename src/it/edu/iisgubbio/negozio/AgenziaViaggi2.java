package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgenziaViaggi2 extends Application {
	
	TextField cPersoneXAutobus = new TextField();
	TextField cPartecipanti = new TextField();
	TextField cCostoAutobus = new TextField();
	Label lPersoneXAutobus = new Label();
	Label lPartecipanti = new Label();
	Label lCostoAutobus = new Label();
	Label lCostoBiglietto = new Label();
	Label lCostoBigliettoOut = new Label();
	Button pCalcolaBiglietto = new Button();


	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lPersoneXAutobus.setText("Persone per Autobus");
		lPartecipanti.setText("Partecipanti");
		lCostoAutobus.setText("Costo Autobus");
		lCostoBiglietto.setText("Costo Biglietto");
		pCalcolaBiglietto.setText("Calcola Biglietto");
		griglia.add(lPersoneXAutobus, 0, 0);
		griglia.add(lPartecipanti, 0, 1);
		griglia.add(lCostoAutobus, 0, 2);
		griglia.add(pCalcolaBiglietto, 0, 3, 2, 1);
		griglia.add(lCostoBiglietto, 0, 4);
		griglia.add(cPersoneXAutobus, 1, 0);
		griglia.add(cPartecipanti, 1, 1);
		griglia.add(cCostoAutobus, 1, 2);
		griglia.add(lCostoBigliettoOut, 1, 4);
		pCalcolaBiglietto.setOnAction(e -> calcolaBiglietto());

		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia,250,200);

		finestra.setTitle("Agenzia Viaggi");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	
	public void  calcolaBiglietto() {
		
		String personeXAutobusStr = cPersoneXAutobus.getText();
		String partecipantiStr = cPartecipanti.getText();
		String costoAutobusStr = cCostoAutobus.getText();
		int personeXAutobus = Integer.parseInt(personeXAutobusStr);
		int	partecipanti = Integer.parseInt(partecipantiStr);
		int	costoAutobus = Integer.parseInt(costoAutobusStr);
		int nAutobus;
		
		if(partecipanti%personeXAutobus==0) {
			nAutobus = partecipanti/personeXAutobus;
			lCostoBigliettoOut.setText((nAutobus*costoAutobus)/partecipanti + "€");
		}else {
			nAutobus = (partecipanti/personeXAutobus)+1;
			lCostoBigliettoOut.setText((nAutobus*costoAutobus)/partecipanti + "€");
	    }
			
	}

	public static void main(String[] args) {
		launch(args);
	}
}