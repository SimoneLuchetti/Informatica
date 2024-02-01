package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Nuotatori extends Application {

	TextField cNumeroVasche = new TextField();
	TextField cTempo = new TextField();
	TextField cCoach = new TextField();
	Label lNumeroVasche = new Label();
	Label lTempo= new Label();
	Label lRisultato= new Label();
	Label lCoach= new Label();
	Label lElenca= new Label();
	Button pCreaVettore = new Button();
	Button pInserisciTempo = new Button();
	Button pContaPessimi = new Button();
	Button pElenca = new Button();

	int tempi[];
	int numeroTempi;
	int posizione;



	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lNumeroVasche.setText("Inserisci Numero Vasche:");
		lTempo.setText("Inserisci Tempo:");
		lCoach.setText("Inserisci Tempo Coach:");
		pCreaVettore.setText("Crea Vettore");
		pInserisciTempo.setText("Inserisci Tempo");
		pContaPessimi.setText("Conta Pessimi");
		pElenca.setText("Elenca");
		griglia.add(lNumeroVasche, 0, 0);
		griglia.add(lTempo, 0, 1);
		griglia.add(lCoach, 0, 2);
		griglia.add(lRisultato, 0, 6, 2, 1);
		griglia.add(cCoach, 1, 2);
		griglia.add(cNumeroVasche, 1, 0);
		griglia.add(cTempo, 1, 1);
		griglia.add(pCreaVettore, 0, 3, 2, 1);
		griglia.add(pInserisciTempo, 0, 4, 2, 1);
		griglia.add(pContaPessimi, 0, 5, 2, 1);
		griglia.add(pElenca, 0, 7, 2, 1);
		griglia.add(lElenca, 0, 8, 2, 1);
		pCreaVettore.setOnAction(e -> creaVettore());
		pInserisciTempo.setOnAction(e -> inserisciTempo());
		pContaPessimi.setOnAction(e -> contaPessimi());
		pElenca.setOnAction(e -> elenca());
		pCreaVettore.setMinWidth(300);
		pInserisciTempo.setMinWidth(300);
		pContaPessimi.setMinWidth(300);
		pElenca.setMinWidth(300);
		lRisultato.setMinWidth(300);
		lElenca.setMinWidth(300);


		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));


		Scene scena = new Scene(griglia,320,300);

		finestra.setTitle("Nuotatori");
		finestra.setScene(scena);
		finestra.show();

	}


	public void  creaVettore() {

		String numeroTempiStr = cNumeroVasche.getText();
		numeroTempi = Integer.parseInt(numeroTempiStr);
		posizione = 0;
		tempi = new int [numeroTempi];
	}

	public void inserisciTempo() {
		if(posizione < numeroTempi) { 
			int t = Integer.parseInt(cTempo.getText());
			tempi[posizione] = t;
			posizione++;
			cTempo.setText("");
		}
	}

	public void contaPessimi() {
		int contatore = 0;
		int coach = Integer.parseInt(cCoach.getText());
		for(int indice = 0; indice < tempi.length; indice++) {
			if(tempi[indice] > coach) {
				contatore++;
			}
		}
		lRisultato.setText("" + contatore);
	}
	
	public void elenca() {
		String elencaStr = "";
		for(int indice = 0; indice < tempi.length; indice++) {
			if(elencaStr.equals("")) {	
				elencaStr += tempi[indice];
			}else {
				elencaStr += ", " + tempi[indice];
			}
		}
		lElenca.setText(elencaStr);
	}

	public static void main(String[] args) {
		launch(args);
	}
}