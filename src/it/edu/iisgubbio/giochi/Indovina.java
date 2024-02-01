package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Indovina extends Application {
	
	Label lNumero = new Label();
	Label lPiccoloGrande = new Label();
	TextField cNumero = new TextField();
	Button pProva = new Button();
	int numeroCasuale = 0;
	GridPane griglia = new GridPane();
	
	public void start(Stage finestra) {

		pProva.setText("Prova");
		lNumero.setText("Numero:");
		griglia.add(cNumero, 1, 0);
		griglia.add(pProva, 0, 1, 2, 1);
		griglia.add(lNumero, 0, 0);
		griglia.add(lPiccoloGrande, 0, 2, 2, 1);
		pProva.setOnAction(e -> prova());
		griglia.setHgap(20);
		griglia.setVgap(20);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		pProva.setMinWidth(220);
		lPiccoloGrande.setMinWidth(220);
		numeroCasuale = (int)(Math.random()*100)+1;
		
		
		Scene scena = new Scene(griglia);

		finestra.setTitle("Indovina");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	public void prova() {
		String numeroCasellaStr;
		int numeroCasella;
		numeroCasellaStr = cNumero.getText();
		numeroCasella = Integer.parseInt(numeroCasellaStr);
		if(numeroCasella > numeroCasuale) {
			lPiccoloGrande.setText("Il numero è troppo grande");
		}else if(numeroCasella < numeroCasuale) {
			lPiccoloGrande.setText("Il numero è troppo piccolo");
		}else {
			lPiccoloGrande.setText("Il numero è giusto");
			pProva.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}