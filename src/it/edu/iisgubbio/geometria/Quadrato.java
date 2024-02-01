package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Quadrato extends Application {
	
	Label lLato = new Label();
	Label lArea = new Label();
	Label lPerimetro = new Label();
	TextField cLato = new TextField();
	Button pArea = new Button();
	Button pPerimetro = new Button();
	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lLato.setText("Lato");
		pArea.setText("Area");
		pPerimetro.setText("Perimetro");
		griglia.add(lLato, 0, 0);
		griglia.add(pArea, 0, 1);
		griglia.add(pPerimetro, 0, 2);
		griglia.add(cLato, 1, 0);
		griglia.add(lArea, 1, 1);
		griglia.add(lPerimetro, 1, 2);
		pArea.setOnAction(e -> area());
		pPerimetro.setOnAction(e -> perimetro());
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia);

		finestra.setTitle("Quadrato");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	public void area() {
		
		String testo1;
		int numero1, prodotto;
		testo1 = cLato.getText();
		numero1 = Integer.parseInt(testo1);
		prodotto = numero1 * numero1;
		lArea.setText(prodotto + "m²" );

	}
	
	public void perimetro() {
		
		String testo1;
		int numero1, somma;
		testo1 = cLato.getText();
		numero1 = Integer.parseInt(testo1);
		somma = numero1 * 4;
		lPerimetro.setText(somma + "m" );
		
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}