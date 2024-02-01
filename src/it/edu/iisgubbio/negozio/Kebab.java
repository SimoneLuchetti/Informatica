package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class Kebab extends Application {
	
	CheckBox cCarne = new CheckBox();
	CheckBox cFormaggio = new CheckBox();
	CheckBox cPomodoro = new CheckBox();
	CheckBox cSalsa = new CheckBox();
	CheckBox cCipolla = new CheckBox();
	Label lTotale = new Label();
	Button pCalcolaTotale = new Button();
    Slider sNumKebab = new Slider(1,5,1);

	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		cCarne.setText("carne [4,00€]");
		cFormaggio.setText("formaggio [1,00€]");
		cPomodoro.setText("pomodoro [1,00€]");
		cSalsa.setText("salsa [0,50€]");
		cCipolla.setText("cipolla [0,50€]");
		pCalcolaTotale.setText("Totale");
		griglia.add(sNumKebab, 0, 0);
		griglia.add(cCarne, 0, 1);
		griglia.add(cFormaggio, 0, 2);
		griglia.add(cPomodoro, 0, 3);
		griglia.add(cSalsa, 0, 4);
		griglia.add(cCipolla, 0, 5);
		griglia.add(pCalcolaTotale, 0, 6);
		griglia.add(lTotale, 1, 6);
		pCalcolaTotale.setOnAction(e -> calcolaTotale());
		sNumKebab.setShowTickMarks(true);
		sNumKebab.setShowTickLabels(true);
		sNumKebab.setMajorTickUnit(1);
		sNumKebab.setMinorTickCount(0);
		sNumKebab.setSnapToTicks(true);


		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia,200,250);

		finestra.setTitle("Kebab");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	
	public void  calcolaTotale() {
		
        double valoreSlider = sNumKebab.getValue();
		double totale;
		totale=0;
	
		if (cCarne.isSelected()){
			totale = totale + 4;
		}if(cFormaggio.isSelected()) {
			totale = totale + 1;
		}if(cPomodoro.isSelected()){
			totale = totale + 1;
		}if(cSalsa.isSelected()){
			totale = totale + 0.5;
		}if(cCipolla.isSelected()){
			totale = totale + 0.5;
		}
		
		if(valoreSlider>1) {
			lTotale.setText("il costo dei tuoi kebab sarà: " + totale*valoreSlider + "€");
		}else {
			lTotale.setText("il costo del tuo kebab sarà: " + totale*valoreSlider + "€");
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}