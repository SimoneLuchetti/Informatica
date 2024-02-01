package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Triangoli extends Application {

	Label lTipo = new Label();
	TextField cLato1 = new TextField();
	TextField cLato2 = new TextField();
	TextField cLato3 = new TextField();
	Button pTrovaTipo = new Button();

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		pTrovaTipo.setText("Trova Tipo");
		griglia.add(cLato1, 0, 0);
		griglia.add(cLato2, 1, 0);
		griglia.add(cLato3, 2, 0);
		griglia.add(pTrovaTipo, 0, 1, 3, 1);
		griglia.add(lTipo, 0, 2, 3, 1);
		pTrovaTipo.setOnAction(e -> trovaTipo());
		pTrovaTipo.setMinWidth(500);
		lTipo.setMinWidth(500);
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));


		Scene scena = new Scene(griglia);

		finestra.setTitle("Triangoli");
		finestra.setScene(scena);
		finestra.show();

	}

	public void  trovaTipo() {

		String lato1Str;
		String lato2Str;
		String lato3Str;
		String rettangolo;
		rettangolo = "";
		double lato1, lato2, lato3;
		lato1Str = cLato1.getText();
		lato2Str = cLato2.getText();
		lato3Str = cLato3.getText();
		lato1 = Double.parseDouble(lato1Str);
		lato2 = Double.parseDouble(lato2Str);
		lato3 = Double.parseDouble(lato3Str);

		if(lato1 < lato2+lato3 && lato2 < lato1+lato3 && lato3 < lato2+lato1) {
			if ((lato3*lato3)==(lato1*lato1)+(lato2*lato2) || (lato2*lato2)==(lato3*lato3)+(lato1*lato1) || (lato1*lato1)==(lato3*lato3)+(lato2*lato2)) {
				rettangolo = " e rettangolo";
			}if (lato1 == lato2 && lato2 == lato3){
				lTipo.setText("Il triangolo è equilatero" + rettangolo);
			}else if(lato1 != lato2 && lato2 != lato3 && lato1 != lato3) {
				lTipo.setText("Il triangolo è scaleno" + rettangolo);
			}else {
				lTipo.setText("Il triangolo è isoscele" + rettangolo);
			}
		}else {
			lTipo.setText("La Figura non è un triangolo" + rettangolo);
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}