package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Pallini extends Application {


	public void start(Stage finestra) throws Exception{
		
		Pane quadro = new Pane();
		boolean alterna = true;

		for(int contatoreX = 20; contatoreX <= 120; contatoreX+=20) {
			for(int contatoreY = 20; contatoreY <= 120; contatoreY+=20) {
				Circle pallino = new Circle (10);
				if(alterna) {
					pallino.setFill(Color.RED);
				} else {
					pallino.setFill(Color.BROWN);

				}
				int controlloCond1 = contatoreX/20;
				int controlloCond2 = contatoreY/20;
				if (controlloCond1%2 != 0 && controlloCond2 != 0) {
					alterna = !alterna;
				}
				quadro.getChildren().add(pallino);
				pallino.setCenterY(contatoreY);
				pallino.setCenterX(contatoreX);
			
			}
		}

		Scene scena = new Scene(quadro, 220, 100);
		finestra.setTitle("Pallini");
		finestra.setScene(scena);
		finestra.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}