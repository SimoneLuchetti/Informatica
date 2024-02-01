package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LuchettiSimoneRistorante extends Application {
	
	Label lNumBistecche = new Label();
	Label lPrezzoBistecca = new Label();
	Label lNumBibite = new Label();
	Label lPrezzoBibite = new Label();
	Label lTotale = new Label();
	Label lTotaleOut = new Label();
	TextField cNumBistecche = new TextField();
	TextField cPrezzoBistecca = new TextField();
	TextField cNumBibite = new TextField();
	TextField cPrezzoBibite = new TextField();
	CheckBox sContorni = new CheckBox();
	CheckBox sSconto = new CheckBox();
	Button pCalcolaTotale = new Button();

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lNumBistecche.setText("Numero bistecche:");
		lPrezzoBistecca.setText("Prezzo bistecca:");
		lNumBibite.setText("Numero bibite:");
		lPrezzoBibite.setText("Prezzo bibite:");
		lTotale.setText("Totale:");
		lTotaleOut.setText("??");
		pCalcolaTotale.setText("totale");
		sContorni.setText("Contorni + 1.5€");
		sSconto.setText("sconto 20%");
		griglia.add(lNumBistecche, 0, 0);
		griglia.add(lPrezzoBistecca, 0, 1);
		griglia.add(lNumBibite, 0, 2);
		griglia.add(lPrezzoBibite, 0, 3);
		griglia.add(lTotale, 0, 6);
		griglia.add(cNumBistecche, 1, 0);
		griglia.add(cPrezzoBistecca, 1, 1);
		griglia.add(cNumBibite, 1, 2);
		griglia.add(cPrezzoBibite, 1, 3);
		griglia.add(sContorni, 1, 4);
		griglia.add(sSconto, 1, 5);
		griglia.add(lTotaleOut, 1, 6);
		griglia.add(pCalcolaTotale, 2, 0, 1, 4);
		griglia.setId("gridpane-spazio");
		pCalcolaTotale.setMaxHeight(150);
		lNumBistecche.setId("label-bianca");
		lNumBibite.setId("label-bianca");
		pCalcolaTotale.setOnAction(e -> calcolaTotale());
		Scene scena = new Scene(griglia,350,250);
		scena.getStylesheets().add("it/edu/iisgubbio/verifica/LuchettiSimone.css");

		finestra.setTitle("Griglia");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	
	public void  calcolaTotale() {
		
		String numeroBisteccheStr = cNumBistecche.getText();
		String prezzoBisteccaStr= cPrezzoBistecca.getText();
		String numeroBibiteStr= cNumBibite.getText();
		String prezzoBibiteStr= cPrezzoBibite.getText();
		int numeroBistecche = Integer.parseInt(numeroBisteccheStr);
		int numeroBibite = Integer.parseInt(numeroBibiteStr);
		double prezzoBistecca = Double.parseDouble(prezzoBisteccaStr);
		double prezzoBibite = Double.parseDouble(prezzoBibiteStr);
		double totale;
		
		totale = (numeroBistecche*prezzoBistecca)+(numeroBibite*prezzoBibite);
		
		if(sContorni.isSelected()) {
			totale += 1.5 * numeroBistecche;
		}
		if(sSconto.isSelected()) {
			totale = totale-(totale*20)/100;
		}
		
		lTotaleOut.setText("il costo sarà: " + totale + "€");
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}