package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rettangolo extends Application {
	
	Label lBase = new Label();
	Label lArea = new Label();
	Label lPerimetro = new Label();
	Label lAltezza = new Label();
	TextField cBase = new TextField();
	TextField cAltezza = new TextField();
	Button pCalcola = new Button();
	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lBase.setText("Base");
		lAltezza.setText("Altezza");
		pCalcola.setText("CalcolaAP");
		griglia.add(lBase, 0, 0);
		griglia.add(lAltezza, 0, 1);
		griglia.add(pCalcola, 0, 2, 2, 1);
		griglia.add(lArea, 0, 3);
		griglia.add(cBase, 1, 0);
		griglia.add(cAltezza, 1, 1);
		griglia.add(lPerimetro, 1, 3);
		pCalcola.setOnAction(e -> calcolaAP());
		pCalcola.setMinWidth(200);
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia);

		finestra.setTitle("Rettangolo");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	public void  calcolaAP() {
		
		String baseStr;
		String altezzaStr;
		Double base, altezza, area, perimetro;
		baseStr = cBase.getText();
		altezzaStr = cAltezza.getText();
		base = Double.parseDouble(baseStr);
		altezza = Double.parseDouble(altezzaStr);
		area = base * altezza;
		perimetro = (base + altezza) * 2;
		lArea.setText("area=" + area + "m²" );
		lPerimetro.setText("permimetro=" + perimetro + "m" );

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}