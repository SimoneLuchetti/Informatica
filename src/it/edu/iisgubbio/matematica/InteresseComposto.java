package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InteresseComposto extends Application {

	Label lCapitale = new Label();
	TextField cCapitale = new TextField();
	Label lTassoInt = new Label();
	TextField cTassoInt = new TextField();
	Label lAnni = new Label();
	TextField cAnni = new TextField();
	Label lCapitaleFP = new Label();
	Button pCalcolaCapitaleFP = new Button();

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lCapitale.setText("Capitale");
		lTassoInt.setText("Tasso Interesse(%)");
		lAnni.setText("Anni");
		pCalcolaCapitaleFP.setText("Calcola Capitale Fine Periodo");
		griglia.add(lCapitale, 0, 0);
		griglia.add(lTassoInt, 0, 1);
		griglia.add(lAnni, 0, 2);
		griglia.add(cCapitale, 1, 0);
		griglia.add(cTassoInt, 1, 1);
		griglia.add(cAnni, 1, 2);
		griglia.add(pCalcolaCapitaleFP, 0, 3);
		griglia.add(lCapitaleFP, 1, 3);
		pCalcolaCapitaleFP.setOnAction(e -> calcolaCapitale());

		Scene scena = new Scene(griglia, 240, 100);		

		finestra.setTitle("Interesse Composto");
		finestra.setScene(scena);
		finestra.show();

	}

	public void calcolaCapitale() {
		
		String capitaleStr, tassoIntStr, anniStr;
		capitaleStr = cCapitale.getText();
		tassoIntStr = cTassoInt.getText();
		anniStr = cAnni.getText();
		double capitale=Double.parseDouble(capitaleStr);
		double tassoInt=Double.parseDouble(tassoIntStr);
		int anni=Integer.parseInt(anniStr);
		for (int contatore=1; contatore<=anni; contatore++) {
			capitale= capitale + ((capitale)/100)*tassoInt;
		}
		lCapitaleFP.setText(""+ capitale + "€");
	}

	public static void main(String[] args) {
		launch(args);
	}
}