package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Kebab2 extends Application {
	
	ComboBox<String> cbCarne = new ComboBox<>();
	ComboBox<String> cbVerdure = new ComboBox<>();
	ComboBox<String> cbSalse = new ComboBox<>();
	Label lTotale = new Label();
	Label lCarne = new Label();
	Label lContorno = new Label();
	Label lSalse = new Label();
	Label lPrezzoCarne = new Label();
	Label lPrezzoContorno = new Label();
	Label lPrezzoSalse = new Label();
	Button pCalcolaTotale = new Button();

	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		cbCarne.getItems().add("Pollo");
		cbCarne.getItems().add("Maiale");
		cbCarne.getItems().add("Vitello");
		cbCarne.getItems().add("Tofu");
		cbVerdure.getItems().add("Insalata");
		cbVerdure.getItems().add("Cipolla");
		cbVerdure.getItems().add("Pomodoro");
		cbVerdure.getItems().add("Carota");
		cbSalse.getItems().add("Mayonese");
		cbSalse.getItems().add("Piccante");
		cbSalse.getItems().add("Yogurt");
		cbSalse.getItems().add("Tzatziki");
		pCalcolaTotale.setText("Totale");
		cbCarne.setOnAction(e -> calcolaPrezzoCarne());
		cbVerdure.setOnAction(e -> calcolaPrezzoVerdure());
		cbSalse.setOnAction(e -> calcolaPrezzoSalse());
		lCarne.setText("Carne");
		lContorno.setText("Contorno");
		lSalse.setText("Salse");
		lPrezzoCarne.setText("3€");
		lPrezzoContorno.setText("0,5€");
		lPrezzoSalse.setText("0,5€");
		griglia.add(lPrezzoCarne, 1, 1);
		griglia.add(lPrezzoContorno, 1, 3);
		griglia.add(lPrezzoSalse, 1, 5);
		griglia.add(lCarne, 0, 0);
		griglia.add(lContorno, 0, 2);
		griglia.add(lSalse, 0, 4);
		griglia.add(cbCarne, 0, 1);
		griglia.add(cbVerdure, 0, 3);
		griglia.add(cbSalse, 0, 5);
		griglia.add(pCalcolaTotale, 0, 6);
		griglia.add(lTotale, 0, 7);
		pCalcolaTotale.setOnAction(e -> calcolaTotale());
		cbCarne.getSelectionModel().select(0);
		cbVerdure.getSelectionModel().select(0);
		cbSalse.getSelectionModel().select(0);

		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia,200,250);

		finestra.setTitle("Kebab");
		finestra.setScene(scena);
		finestra.show();
				
	}
	
	
	public void  calcolaTotale() {
		
		String valoreCarne = cbCarne.getValue();
		String valoreVerdure = cbVerdure.getValue();
		String valoreSalse = cbSalse.getValue();

		double totale;
		totale=1;
		
		switch(valoreCarne) {
		case "Maiale":
			totale += 2.5;
			break;
		case "Vitello":
			totale += 4;
			break;
		default:
			totale += 3;
		}
		
		
		switch(valoreVerdure) {
		case "Insalata":
		case "Cipolla":
			totale += 0.5;
			break;
		default:
			totale += 1;
		}
		
		
		switch(valoreSalse) {
		case "Piccante":
			totale += 1;
			break;
		default:
			totale += 0.5;
		}
		
		lTotale.setText(totale + "€");
	}
	
	public void calcolaPrezzoCarne() {
		String valoreCarne = cbCarne.getValue();
		switch(valoreCarne) {
		case "Maiale":
			lPrezzoCarne.setText("2,5€");
			break;
		case "Vitello":
			lPrezzoCarne.setText("4€");
			break;
		default:
			lPrezzoCarne.setText("3€");
			
		}
	}
		
	public void calcolaPrezzoVerdure() {
		String valoreVerdure = cbVerdure.getValue();
		switch(valoreVerdure) {
		case "Insalata":
		case "Cipolla":
			lPrezzoContorno.setText("0,5€");
			break;
		default:
			lPrezzoContorno.setText("1€");
			
		}
	}
	
	public void calcolaPrezzoSalse() {
		String valoreSalse = cbSalse.getValue();
		switch(valoreSalse) {
		case "Piccante":
			lPrezzoSalse.setText("1€");
			break;
		default:
			lPrezzoSalse.setText("0,5€");
			
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}