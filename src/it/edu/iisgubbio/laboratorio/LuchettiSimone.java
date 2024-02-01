package it.edu.iisgubbio.laboratorio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LuchettiSimone extends Application {
	
	Label lInserisciNumeri = new Label();
	Label lCalcolaSommaNumeriReali = new Label();
	Label lCalcolaQuantiNumeriPrimi = new Label();
	Label lCalcolaDisposizioniSemplici = new Label();
	Label lRisultato = new Label();
	TextField cPrimoNumero = new TextField();
	TextField cSecondoNumero = new TextField();
	Button pCalcolaSommaNumeriReali = new Button();
	Button pCalcolaQuantiNumeriPrimi = new Button();
	Button pCalcolaDisposizioniSemplici = new Button();
	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lInserisciNumeri.setText("Inserisci Numeri:");
		lCalcolaSommaNumeriReali.setText("Calcola somma numeri reali");
		lCalcolaQuantiNumeriPrimi.setText("Calcola quanti numeri primi");
		lCalcolaDisposizioniSemplici.setText("Calcola disposizioni semplici");
		pCalcolaSommaNumeriReali.setText("Calcola");
		pCalcolaQuantiNumeriPrimi.setText("Calcola");
		pCalcolaDisposizioniSemplici.setText("Calcola");
		griglia.add(lInserisciNumeri, 0, 0);
		griglia.add(lCalcolaSommaNumeriReali, 0, 1);
		griglia.add(lCalcolaQuantiNumeriPrimi, 0, 2);
		griglia.add(lCalcolaDisposizioniSemplici, 0, 3);
		griglia.add(lRisultato, 0, 4, 3, 1);
		griglia.add(cPrimoNumero, 1, 0);
		griglia.add(cSecondoNumero, 2, 0);
		griglia.add(pCalcolaSommaNumeriReali, 1, 1);
		griglia.add(pCalcolaQuantiNumeriPrimi, 1, 2);
		griglia.add(pCalcolaDisposizioniSemplici, 1, 3);
		pCalcolaSommaNumeriReali.setOnAction(e -> calcolaSomma());
		pCalcolaQuantiNumeriPrimi.setOnAction(e -> calcolaQuanti());
		pCalcolaDisposizioniSemplici.setOnAction(e -> calcolaDisposizioni());

		
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setId("gridpane-spazio");


		
		
		Scene scena = new Scene(griglia, 500, 200);

		finestra.setTitle("Verifica");
		finestra.setScene(scena);
		scena.getStylesheets().add("it/edu/iisgubbio/laboratorio/LuchettiSimone.css");
		finestra.show();
		
	}
	
	
	public void  calcolaSomma() {
		String primoNumeroStr = cPrimoNumero.getText();
		String secondoNumeroStr = cSecondoNumero.getText();
		int primoNumero = Integer.parseInt(primoNumeroStr);
		int secondoNumero = Integer.parseInt(secondoNumeroStr);
		int totale = 0;
		for(int contatore = secondoNumero; contatore<=primoNumero; contatore++) {
			totale += contatore;
		}
		
		lRisultato.setText("La somma dei numeri reali compresi nell'intervallo " + primoNumero + " - " + secondoNumero + " è: " + totale);
		
	}
	
	public void  calcolaQuanti() {
		String primoNumeroStr = cPrimoNumero.getText();
		String secondoNumeroStr = cSecondoNumero.getText();
		int primoNumero = Integer.parseInt(primoNumeroStr);
		int secondoNumero = Integer.parseInt(secondoNumeroStr);
		int contaDiv = 0;
		int contaNumeriPrimi = 0;
		for(int numeroDaControllare = secondoNumero; numeroDaControllare <= primoNumero; numeroDaControllare++) {
			for(int contatore = 1; contatore <= numeroDaControllare; contatore++) {
				if(numeroDaControllare%contatore==0) {
					contaDiv += 1;
				}					
			}
			
			if(contaDiv == 2) {
				contaNumeriPrimi += 1;	
			}
			contaDiv = 0;
		}
		
		lRisultato.setText("Il numero di numeri reali compresi nell'intervallo " + primoNumero + " - " + secondoNumero + " è: " + contaNumeriPrimi);
	}

	public void  calcolaDisposizioni() {
		String primoNumeroStr = cPrimoNumero.getText();
		String secondoNumeroStr = cSecondoNumero.getText();
		int primoNumero = Integer.parseInt(primoNumeroStr);
		int secondoNumero = Integer.parseInt(secondoNumeroStr);
		int fattorialePrimoNumero = 1;
		int fattorialePrimoNumeroMenoSecondoNumero = 1;
		int disposizioni = 0;
		for(int contatore = 1; contatore <= primoNumero; contatore++) {
			fattorialePrimoNumero = fattorialePrimoNumero*contatore;
		}
		
		for(int contatore = 1; contatore <= primoNumero - secondoNumero; contatore++) {
			fattorialePrimoNumeroMenoSecondoNumero = fattorialePrimoNumeroMenoSecondoNumero*contatore;
		}
		
		disposizioni = fattorialePrimoNumero/fattorialePrimoNumeroMenoSecondoNumero;
		lRisultato.setText("Le disposizioni sono: " + disposizioni);
		
	}
		

	public static void main(String[] args) {
		launch(args);
	}
}