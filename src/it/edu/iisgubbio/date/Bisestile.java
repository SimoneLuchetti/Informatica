package it.edu.iisgubbio.date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Bisestile extends Application {
	
	Label lAnno = new Label();
	Label lBisestile = new Label();
	TextField cAnno = new TextField();
	Button pCalcolaBisestile = new Button();
	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lAnno.setText("Anno");
		pCalcolaBisestile.setText("Bistestile?");
		griglia.add(lAnno, 0, 0);
		griglia.add(lBisestile, 1, 1);
		griglia.add(pCalcolaBisestile, 0, 1);
		griglia.add(cAnno, 1, 0);
		pCalcolaBisestile.setOnAction(e -> calcolaBisestile());



		
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia);

		finestra.setTitle("Sconto");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	
	public void  calcolaBisestile() {
		
		String annoStr;
		int anno;
		annoStr = cAnno.getText();
		anno = Integer.parseInt(annoStr);
		
		if (anno%4 == 0 && anno%100 != 0 || anno%400 == 0) {
			lBisestile.setText("L'anno è bisestile");
		}
		
		else {
			lBisestile.setText("L'anno non è bisestile");
		}
		

	}

	public static void main(String[] args) {
		launch(args);
	}
}