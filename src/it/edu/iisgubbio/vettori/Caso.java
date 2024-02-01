package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Caso extends Application {

	TextField cElementi = new TextField();
	TextField cMin = new TextField();
	TextField cMax = new TextField();
	Label lElementi = new Label();
	Label lMin = new Label();
	Label lMax = new Label();
	Label lOutput = new Label();
	Label lPari = new Label();
	Label lSomma = new Label();
	Label lSommaMultipli = new Label();
	Label lOutputMin = new Label();
	Button pGenera = new Button();
	Button pStampa = new Button();
	Button pPari = new Button();
	Button pSomma = new Button();
	Button pSommaMultipli = new Button();
	Button pMin = new Button();



	int elementi[];
	int numeroTempi;

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lElementi.setText("Elementi:");
		lMin.setText("Min:");
		lMax.setText("Max:");
		pGenera.setText("Genera");
		pStampa.setText("Stampa");
		pPari.setText("Pari");
		pSomma.setText("Somma");
		pSommaMultipli.setText("2 e 3");
		pMin.setText("Min");
		griglia.add(lElementi, 0, 0);
		griglia.add(lMin, 0, 1);
		griglia.add(lMax, 0, 2);
		griglia.add(pGenera, 0, 3);
		griglia.add(cMax, 1, 2);
		griglia.add(cElementi, 1, 0);
		griglia.add(cMin, 1, 1);
		griglia.add(lOutput, 0, 4, 2, 1);
		griglia.add(pStampa, 1, 3);
		griglia.add(pPari, 0, 5);
		griglia.add(lPari, 1, 5);
		griglia.add(pSomma, 0, 6);
		griglia.add(lSomma, 1, 6);
		griglia.add(pSommaMultipli, 0, 7);
		griglia.add(lSommaMultipli, 1, 7);
		griglia.add(pMin, 0, 8);
		griglia.add(lOutputMin, 1, 8);
		pGenera.setOnAction(e -> creaVettore());
		pStampa.setOnAction(e -> elenca());
		pPari.setOnAction(e -> contaPari());
		pSomma.setOnAction(e -> somma());
		pSommaMultipli.setOnAction(e -> sommaMultipli());
		pMin.setOnAction(e -> calcolaMin());
		lOutput.setMinWidth(300);


		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));


		Scene scena = new Scene(griglia,320,320);

		finestra.setTitle("Caso");
		finestra.setScene(scena);
		finestra.show();

	}


	public void  creaVettore() {

		String numeroTempiStr = cElementi.getText();
		String numeroMinStr = cMin.getText();
		String numeroMaxStr = cMax.getText();
		int numeroMin = Integer.parseInt(numeroMinStr);
		int numeroMax = Integer.parseInt(numeroMaxStr);
		numeroTempi = Integer.parseInt(numeroTempiStr);
		int numeroCasuale;
		int diff = numeroMax - numeroMin + 1;
		elementi = new int [numeroTempi];
		for(int indice = 0; indice < elementi.length; indice++) {
			numeroCasuale = (int)(Math.random()*diff)+numeroMin;
			elementi[indice] = numeroCasuale;
			numeroCasuale = 0;
		}
	}
	
	public void  somma() {
		int somma = 0;
		for(int indice = 0; indice < elementi.length; indice++ ) {
				somma += elementi[indice];
		}
		lSomma.setText("" + somma);
	}
	
	public void  sommaMultipli() {
		int sommaMultipli = 0;
		for(int indice = 0; indice < elementi.length; indice++ ) {
			if(elementi[indice]%2 == 0 && elementi[indice]%3 == 0)
				sommaMultipli += elementi[indice];
		}
		lSommaMultipli.setText("" + sommaMultipli);
	}
	
	public void  contaPari() {
		int contapari = 0;
		for(int indice = 0; indice < elementi.length; indice++ ) {
			if(elementi[indice]%2 == 0) {
				contapari += 1;
			}
		}
		lPari.setText("" + contapari);
	}

	
	public void elenca() {
		String elencaStr = "";
		for(int indice = 0; indice < elementi.length; indice++) {
			if(elencaStr.equals("")) {	
				elencaStr += elementi[indice];
			}else {
				elencaStr += ", " + elementi[indice];
			}
		}
		lOutput.setText(elencaStr);
	}
	
	public void  calcolaMin() {

		int numeroMin = elementi[0];
		for(int indice = 1; indice < elementi.length; indice++) {
			if(elementi[indice] < numeroMin) {
				numeroMin = elementi[indice];
			}
		}
		lOutputMin.setText("" + numeroMin);;
	}

	public static void main(String[] args) {
		launch(args);
	}
}