package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Triangolo extends Application {
	
	Pane pQuadro = new Pane();
	Label lNumero = new Label();
	TextField cNumero = new TextField();
	Button bVai = new Button();


	public void start(Stage finestra) throws Exception{
		
		GridPane griglia = new GridPane();
		lNumero.setText("numero:");
		bVai.setText("Vai!");
		griglia.add(lNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(bVai, 2, 0);
		griglia.add(pQuadro, 0, 3, 3, 1);
		bVai.setOnAction(e -> vai());
		pQuadro.setMinHeight(300);
		pQuadro.setMinWidth(300);
		
		Scene scena = new Scene(griglia, 220, 100);
		finestra.setTitle("Triangolo");
		finestra.setScene(scena);
		finestra.show();

	}
	
	public void vai() {
		String numeroPalliniStr = cNumero.getText();
		int numeroPallini = Integer.parseInt(numeroPalliniStr);
		if(numeroPallini>10) {
			cNumero.setText("max 10 pallini");
		}
		for(int contatoreX = 20; contatoreX <= numeroPallini*20; contatoreX+=20) {
			for(int contatoreY = 20; contatoreY <= numeroPallini*20; contatoreY+=20) {
				Circle pallino = new Circle (10);
				pQuadro.getChildren().add(pallino);
				pallino.setCenterY(contatoreY);
				pallino.setCenterX(contatoreX);
			}
			numeroPallini--;
		}	
	}

	public static void main(String[] args) {
		launch(args);
	}
}