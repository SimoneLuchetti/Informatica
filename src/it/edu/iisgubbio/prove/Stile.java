package it.edu.iisgubbio.prove;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Stile extends Application {
	
	Label lBase = new Label();
	Label lArea = new Label();
	Label lPerimetro = new Label();
	Label lAltezza = new Label();
	TextField cBase = new TextField();
	TextField cAltezza = new TextField();
	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lBase.setText("Base");
		lAltezza.setText("Altezza");
		lArea.setText("Area");
		lPerimetro.setText("Perimetro");
		lPerimetro.setText("Perimetro");
		cBase.setOnAction(e -> calcolaAP());
		cAltezza.setOnAction(e -> calcolaAP());
		lPerimetro.setId("label-blu");
		griglia.add(lBase, 0, 0);
		griglia.add(lAltezza, 0, 1);
		griglia.add(lArea, 0, 2);
		griglia.add(cBase, 1, 0);
		griglia.add(cAltezza, 1, 1);
		griglia.add(lPerimetro, 1, 2);
		griglia.setId("gridpane-spazio");		
		
		Scene scena = new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/prove/Stile.css");

		finestra.setTitle("CSS");
		finestra.setScene(scena);
		finestra.show();
		
		
		}
		
		public void  calcolaAP() {
			
			String baseStr;
			String altezzaStr;
			Double base, altezza, area, perimetro;
			baseStr = cBase.getText();
			altezzaStr = cAltezza.getText();
			if(baseStr.equals("")) {
				baseStr = "0";
			}
			if(altezzaStr.equals("")) {
				altezzaStr = "0";
			}
			base = Double.parseDouble(baseStr);
			altezza = Double.parseDouble(altezzaStr);
			if(base != 0 && altezza != 0 ) {
				area = base * altezza;
				perimetro = (base + altezza) * 2;
				lArea.setText("area=" + area + "m²" );
				lPerimetro.setText("permimetro=" + perimetro + "m" );
			}else if(base == 0) {
				cBase.setText("base mancante" );

			}else {
				cAltezza.setText("altezza mancante" );
			}
			
		}
		
	public static void main(String[] args) {
		launch(args);
	}
}