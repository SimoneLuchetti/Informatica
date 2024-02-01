package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TriangoloRettangolo extends Application {
	
	Label lCateto1 = new Label();
	Label lCateto2 = new Label();
	Label lIpotenusa = new Label();
	TextField cCateto1 = new TextField();
	TextField cCateto2 = new TextField();
	TextField cIpotenusa = new TextField();
	Button pCalcolaCateto1 = new Button();
	Button pCalcolaCateto2 = new Button();
	Button pCalcolaIpotenusa = new Button();
	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lCateto1.setText("Cateto 1");
		lCateto2.setText("Cateto2");
		lIpotenusa.setText("Ipotenusa");
		pCalcolaCateto1.setText("Calcola Cateto 1");
		pCalcolaCateto2.setText("Calcola Cateto 2");
		pCalcolaIpotenusa.setText("Calcola Ipotenusa");
		griglia.add(lCateto1, 0, 0);
		griglia.add(lCateto2, 0, 1);
		griglia.add(lIpotenusa, 0, 2);
		griglia.add(cCateto1, 1, 0);
		griglia.add(cCateto2, 1, 1);
		griglia.add(cIpotenusa, 1, 2);
		griglia.add(pCalcolaCateto1, 2, 0);
		griglia.add(pCalcolaCateto2, 2, 1);
		griglia.add(pCalcolaIpotenusa, 2, 2);

		pCalcolaCateto1.setOnAction(e -> calcolaCateto1());
		pCalcolaCateto2.setOnAction(e -> calcolaCateto2());
		pCalcolaIpotenusa.setOnAction(e -> calcolaIpotenusa());
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia);

		finestra.setTitle("Triangolo Rettangolo");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	
	public void  calcolaCateto1() {
		
		String cateto2Str;
		String ipotenusaStr;
		Double cateto2, ipotenusa, cateto1;
		cateto2Str = cCateto2.getText();
		ipotenusaStr = cIpotenusa.getText();
		cateto2 = Double.parseDouble(cateto2Str);
		ipotenusa = Double.parseDouble(ipotenusaStr);
		cateto1 = Math.sqrt((ipotenusa*ipotenusa)-(cateto2*cateto2));
		cCateto1.setText("" + cateto1);
	}
	
	public void  calcolaCateto2() {
		
		String cateto1Str;
		String ipotenusaStr;
		Double cateto2, ipotenusa, cateto1;
		cateto1Str = cCateto1.getText();
		ipotenusaStr = cIpotenusa.getText();
		cateto1 = Double.parseDouble(cateto1Str);
		ipotenusa = Double.parseDouble(ipotenusaStr);
		cateto2 = Math.sqrt((ipotenusa*ipotenusa)-(cateto1*cateto1));
		cCateto2.setText("" + cateto2);
	}
	
	public void  calcolaIpotenusa() {
		
		String cateto1Str;
		String cateto2Str;
		Double cateto2, ipotenusa, cateto1;
		cateto1Str = cCateto1.getText();
		cateto2Str = cCateto2.getText();
		cateto1 = Double.parseDouble(cateto1Str);
		cateto2 = Double.parseDouble(cateto2Str);
		ipotenusa = Math.sqrt((cateto1*cateto1)+(cateto2*cateto2));
		cIpotenusa.setText("" + ipotenusa);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}