package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class SettaPallini extends Application {


	public void start(Stage finestra) throws Exception{
		
		Pane quadro = new Pane();
		Circle pallinoOrigine = new Circle(15);
		quadro.getChildren().add(pallinoOrigine);
		pallinoOrigine.setLayoutX(200);
		pallinoOrigine.setLayoutY(200);
		int xPallino = 0;
		int yPallino = 0;
		int angolo = 0;
		int raggio = 100;
		int cerchi[] = new int [6];
		for(int indice0 = 0; indice0 < 6; indice0++) {
			
			
		}
		
		
		for(int indice1 = 0; indice1<6; indice1++ ) {
			angolo += 60;
			xPallino = raggio * (int)(Math.cos(angolo));
			yPallino = raggio * (int)(Math.cos(angolo));
			
		}
		
		
		
		
		
		
		
		
		
		
		
		Scene scena = new Scene(quadro, 400, 400);
		finestra.setTitle("Pallini");
		finestra.setScene(scena);
		finestra.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}