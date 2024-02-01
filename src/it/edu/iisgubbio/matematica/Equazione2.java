package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Equazione2 extends Application {
	
	Label lSoluzioni = new Label();
	Label lX2 = new Label();
	Label lX = new Label();
	Label l0 = new Label();
	Label lImmagine = new Label();
	TextField cA = new TextField();
	TextField cB = new TextField();
	TextField cC = new TextField();
	Button pCalcolaSoluzioni = new Button();
	Image uomoFelice = new Image(getClass().getResourceAsStream("uomoFelice.png"));
    ImageView uomoFeliceNero = new ImageView(uomoFelice);
	Image immagineNero = new Image(getClass().getResourceAsStream("Immaginenero.png"));
    ImageView uomoDubbiosoNero = new ImageView(immagineNero);
    Image immagineNeroTriste = new Image(getClass().getResourceAsStream("nerotriste.png"));
    ImageView uomoNeroTriste = new ImageView(immagineNeroTriste);
    
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lX2.setText("X²+");
		lX.setText("X+");
		l0.setText("=0");
		pCalcolaSoluzioni.setText("Calcola Soluzioni");
		pCalcolaSoluzioni.setGraphic(uomoDubbiosoNero);
		griglia.add(cA, 0, 0);
		griglia.add(lX2, 1, 0);
		griglia.add(cB, 2, 0);
		griglia.add(lX, 3, 0);
		griglia.add(cC, 4, 0);
		griglia.add(l0, 5, 0);
		griglia.add(pCalcolaSoluzioni, 0, 1, 5, 1);
		griglia.add(lSoluzioni, 0, 2, 5, 1);
		griglia.add(lImmagine, 0, 6);
		pCalcolaSoluzioni.setOnAction(e -> trovaTipo());
		pCalcolaSoluzioni.setMinWidth(550);
		lSoluzioni.setMinWidth(550);
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		uomoFeliceNero.setFitHeight(100);
		uomoFeliceNero.setPreserveRatio(true);
		uomoNeroTriste.setFitHeight(100);
		uomoNeroTriste.setPreserveRatio(true);
		uomoDubbiosoNero.setFitHeight(40);
		uomoDubbiosoNero.setPreserveRatio(true);

		Scene scena = new Scene(griglia, 575, 300);

		finestra.setTitle("Equazione2");
		finestra.setScene(scena);
		finestra.show();

	}

	public void  trovaTipo() {

		String aStr;
		String bStr;
		String cStr;
		String spuriaOPura;
		double a, b, c, delta, x1, x2;
		aStr = cA.getText();
		bStr = cB.getText();
		cStr = cC.getText();
		if(aStr.equals("")) {
			aStr = "0";
		}
		if(bStr.equals("")) {
			bStr = "0";
		}
		if(cStr.equals("")) {
			cStr = "0";
		}
		a = Double.parseDouble(aStr);
		b = Double.parseDouble(bStr);
		c = Double.parseDouble(cStr);
		x1 = 0;
		x2 = 0;
		if(a==0 && b==0 && c==0 || a==0 && b!=0 && c==0 || a==0 && b==0 && c!=0) {
			lSoluzioni.setText("Valori mancanti");
		}else {
			if(a!=0) {
				delta = (b*b)-4*a*c;
				if(b==0 && a!=0 && c!=0) {
					spuriaOPura = "L'equazione è una pura, ";
				}else if(c==0 && a!=0 && b!=0) {
					spuriaOPura = "L'equazione è una spuria, ";
				}else if(a!=0 && b==0 && c==0) {
					spuriaOPura = "L'equazione è monomia, ";
				}else {
					spuriaOPura = "L'equazione è completa, ";
				}
				if(delta>0) {
					x1 = (-(b)+Math.sqrt(delta))/(2*a);
					x2 = (-(b)-Math.sqrt(delta))/(2*a);
					lSoluzioni.setText(spuriaOPura + "L'equazione ha due soluzioni distinte " + "x1: " + x1 + " x2: " + x2);
					lImmagine.setGraphic(uomoFeliceNero);
				}else if(delta==0) {
					x1 =(-(b)+Math.sqrt(delta))/(2*a);
					lSoluzioni.setText(spuriaOPura + "L'equazione ha due soluzioni reali coincidenti: " + x1);
					lImmagine.setGraphic(uomoFeliceNero);
				}else {
					lSoluzioni.setText(spuriaOPura + "L'equazione non ammette soluzioni");
					lImmagine.setGraphic(uomoNeroTriste);
				}
			
			}else {
				lSoluzioni.setText("L'equazione non è di secondo grado");
				lImmagine.setGraphic(uomoNeroTriste);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}