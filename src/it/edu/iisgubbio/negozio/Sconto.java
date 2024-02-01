package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Sconto extends Application {
	
	Label lPrezzoPanino = new Label();
	Label lNumeroPanini = new Label();
	Label lSconto = new Label();
	Label lTotale = new Label();
	TextField cPrezzoPanino = new TextField();
	TextField cNumeroPanini = new TextField();
	TextField cSconto = new TextField();
	RadioButton rScontoNessuno = new RadioButton();
	RadioButton rSconto10 = new RadioButton();
	RadioButton rSconto20 = new RadioButton();
	Button pCalcolaTotale = new Button();
	ToggleGroup tSconti = new ToggleGroup();
	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lPrezzoPanino.setText("Prezzo Panino");
		lNumeroPanini.setText("Numero Panini");
		lSconto.setText("Sconto(%)");
		pCalcolaTotale.setText("Calcola Totale");
		rScontoNessuno.setText("Nessuno");
		rSconto10.setText("10%");
		rSconto20.setText("20%");
		griglia.add(lPrezzoPanino, 0, 0);
		griglia.add(lNumeroPanini, 0, 1);
		griglia.add(rScontoNessuno, 0, 2);
		griglia.add(rSconto10, 0, 3);
		griglia.add(rSconto20, 0, 4);
		griglia.add(pCalcolaTotale, 0, 5, 2, 1);
		griglia.add(lTotale, 0, 6, 2, 1);
		griglia.add(cPrezzoPanino, 1, 0);
		griglia.add(cNumeroPanini, 1, 1);
		pCalcolaTotale.setOnAction(e -> calcolaTotale());
		pCalcolaTotale.setMaxWidth(250);
		lTotale.setMaxWidth(250);
		rScontoNessuno.setToggleGroup(tSconti);
		rSconto10.setToggleGroup(tSconti);
		rSconto20.setToggleGroup(tSconti);
		rSconto10.setSelected(true);


		
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia);

		finestra.setTitle("Sconto");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	
	public void  calcolaTotale() {
		
		String prezzoPaninoStr;
		String numeroPaniniStr;
		Double prezzoPanino, numeroPanini, totale, sconto;
		prezzoPaninoStr = cPrezzoPanino.getText();
		numeroPaniniStr = cNumeroPanini.getText();
		prezzoPanino = Double.parseDouble(prezzoPaninoStr);
		numeroPanini = Double.parseDouble(numeroPaniniStr);
		totale = prezzoPanino*numeroPanini;
		if (rScontoNessuno.isSelected()){
			sconto = 0.0;
		}else if(rSconto10.isSelected()) {
			sconto = ((prezzoPanino*numeroPanini)*10)/100;
		}else {
			sconto = ((prezzoPanino*numeroPanini)*20)/100;
		}
		
		lTotale.setText("totale " + (totale-sconto) + "€");

	}

	public static void main(String[] args) {
		launch(args);
	}
}