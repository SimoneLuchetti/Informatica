package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.layout.Pane;

public class Ragnatela extends Application {


	public void start(Stage finestra) throws Exception{
		
		Pane quadro = new Pane();

		for(int contatoreX = 0; contatoreX <= 200; contatoreX+=20) {
				Line linea = new Line (0, 0+contatoreX, 200-contatoreX ,0);
				quadro.getChildren().add(linea);
			
		}

		Scene scena = new Scene(quadro, 220, 100);
		finestra.setTitle("Ragnatela");
		finestra.setScene(scena);
		finestra.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}