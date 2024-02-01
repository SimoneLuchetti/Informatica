package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvertiMescola extends Application {

	TextField cLista = new TextField();
	TextField cOutput = new TextField();
	Button pInverti = new Button("Inverti");
	Button pMescola = new Button("Mescola");



	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		griglia.add(cLista, 0, 0, 2, 1);
		griglia.add(pInverti, 0, 1);
		griglia.add(pMescola, 1, 1);
		griglia.add(cOutput, 0, 2, 2, 1);
		pInverti.setOnAction(e -> inverti());
		pMescola.setOnAction(e -> mescola());



		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));


		Scene scena = new Scene(griglia,150,120);

		finestra.setTitle("Inverti e Mescola");
		finestra.setScene(scena);
		finestra.show();

	}


	public void  inverti() {
		String numeriStr = cLista.getText();
		String[] vNumeriStr = numeriStr.split(" ");
		int numeri[] = new int[vNumeriStr.length];
		int numeroSospeso = 0;
		int fineVettore = numeri.length - 1;
		String numeriInvertitiStr = "";
		
		for(int indiceRiempiVettore = 0; indiceRiempiVettore < numeri.length; indiceRiempiVettore++) {
			numeri[indiceRiempiVettore] = Integer.parseInt(vNumeriStr[indiceRiempiVettore]);
		}
		
		
		
		for(int indiceInvertiVettore = 0; indiceInvertiVettore < numeri.length/2; indiceInvertiVettore++ ) {
			numeroSospeso = numeri[indiceInvertiVettore];
			numeri[indiceInvertiVettore] = numeri[fineVettore];
			numeri[fineVettore] = numeroSospeso;
			fineVettore -= 1;
			numeroSospeso = 0;
			
		}
		for(int indiceStampa = 0; indiceStampa<numeri.length; indiceStampa++) {
			if(numeriInvertitiStr == "") {
				numeriInvertitiStr = "" + numeri[indiceStampa];
			} 

			else {
				numeriInvertitiStr += " " + numeri[indiceStampa];
			}
		}
		cOutput.setText("" + numeriInvertitiStr);
	}

	public void mescola() {
		String numeriStr = cLista.getText();
		String[] vNumeriStr = numeriStr.split(" ");
		int numeri[] = new int[vNumeriStr.length];
		int numeroSospeso = 0;
		int numeroCasuale = 0;
		String numeriMescolatiStr = "";

		for(int indiceRiempiVettore = 0; indiceRiempiVettore < numeri.length; indiceRiempiVettore++) {
			numeri[indiceRiempiVettore] = Integer.parseInt(vNumeriStr[indiceRiempiVettore]);
		}
		
		for(int indiceMescolaVettore = 0; indiceMescolaVettore < numeri.length; indiceMescolaVettore++ ) {
			numeroCasuale = (int) (Math.random()*numeri.length);
			numeroSospeso = numeri[indiceMescolaVettore];
			numeri[indiceMescolaVettore] = numeri[numeroCasuale];
			numeri[numeroCasuale] = numeroSospeso;
		}
		
	
		for(int indiceStampa = 0; indiceStampa<numeri.length; indiceStampa++) {
			if(numeriMescolatiStr == "") {
				numeriMescolatiStr = "" + numeri[indiceStampa];
			} 

			else {
				numeriMescolatiStr += " " + numeri[indiceStampa];
			}
		}
		cOutput.setText("" + numeriMescolatiStr);

	}



	public static void main(String[] args) {
		launch(args);
	}
}