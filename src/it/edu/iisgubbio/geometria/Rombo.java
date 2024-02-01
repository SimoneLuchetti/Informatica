package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rombo extends Application {
	
	Label lArea = new Label();
	Label lDiagonale1 = new Label();
	Label lDiagonale2 = new Label();
	Label lPerimetro = new Label();
	TextField cDiagonale1 = new TextField();
	TextField cDiagonale2 = new TextField();
	Button pCalcola = new Button();
	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lDiagonale1.setText("Diagonale 1");
		lDiagonale2.setText("Diagonale 2");
		pCalcola.setText("CalcolaAP");
		griglia.add(lDiagonale1, 0, 0);
		griglia.add(lDiagonale2, 0, 1);
		griglia.add(pCalcola, 0, 2, 2, 1);
		griglia.add(lArea, 0, 3);
		griglia.add(lPerimetro, 1, 3);
		griglia.add(cDiagonale1, 1, 0);
		griglia.add(cDiagonale2, 1, 1);
		pCalcola.setOnAction(e -> calcolaAP());
		pCalcola.setMinWidth(200);
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia);

		finestra.setTitle("Rombo");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	
	public void  calcolaAP() {
		
		String diagonale1Str;
		String diagonale2Str;
		Double diagonale1, diagonale2, area, perimetro, lato;
		diagonale1Str = cDiagonale1.getText();
		diagonale2Str = cDiagonale2.getText();
		diagonale1 = Double.parseDouble(diagonale1Str);
		diagonale2 = Double.parseDouble(diagonale2Str);
		area = (diagonale1 * diagonale2)/2;
		lato = Math.sqrt(diagonale1*diagonale1+diagonale2*diagonale2)/2;
		perimetro = lato * 4;
		lPerimetro.setText("perimetro=" + perimetro + "m" );
		lArea.setText("area=" + area + "m²" );
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}