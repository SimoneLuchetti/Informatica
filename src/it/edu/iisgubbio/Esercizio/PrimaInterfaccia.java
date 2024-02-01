package it.edu.iisgubbio.Esercizio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrimaInterfaccia extends Application {
	
	Label lCopiatoSx = new Label();
	Label lMostraUnione = new Label();
	Label lCopiatoDx = new Label();
	TextField cPrimaParola = new TextField();
	TextField cSecondaParola = new TextField();
	Button pCopiaSx = new Button();
	Button pUnire = new Button();
	Button pPulire = new Button();
	Button pCopiaDx = new Button();
	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		pCopiaSx.setText("COPIA");
		pUnire.setText("UNISCI");
		pPulire.setText("PULISCI");
		pCopiaDx.setText("COPIA");
		cPrimaParola.setPromptText("Inserisci Prima Parola");
		cSecondaParola.setPromptText("Inserisci Seconda Parola");
		griglia.add(cPrimaParola, 0, 0);
		griglia.add(pCopiaSx, 0, 1);
		griglia.add(lCopiatoSx, 0, 2);
		griglia.add(pUnire, 1, 0);
		griglia.add(lMostraUnione, 1, 1);
		griglia.add(pPulire, 1, 2);
		griglia.add(cSecondaParola, 2, 0);
		griglia.add(pCopiaDx, 2, 1);
		griglia.add(lCopiatoDx, 2, 2);
		pCopiaSx.setOnAction(e -> copiaSx());
		pUnire.setOnAction(e -> unire());
		pPulire.setOnAction(e -> pulire());
		pCopiaDx.setOnAction(e -> copiaDx());
		griglia.setHgap(20);
		griglia.setVgap(20);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia);

		finestra.setTitle("PrimaInterfaccia");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	public void copiaSx() {
		String parolaSx;
		parolaSx = cPrimaParola.getText();
		lCopiatoSx.setText(parolaSx);
	}
	
	public void unire() {
		String primaParola;
		String secondaParola;
		primaParola = cPrimaParola.getText();
		secondaParola = cSecondaParola.getText();
		lMostraUnione.setText(primaParola + secondaParola);
		
	}
	
	public void pulire() {
		cPrimaParola.setText("");
		cSecondaParola.setText("");
		
	}
	
	public void copiaDx() {
		String parolaDx;
		parolaDx = cSecondaParola.getText();
		lCopiatoDx.setText(parolaDx);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
	
	


