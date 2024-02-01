package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Faccia extends Application {


	public void start(Stage finestra) throws Exception{
		
		Pane quadro = new Pane();
		
		Circle faccia = new Circle (100);
		Circle occhioDx = new Circle (20);
		Circle occhioSx = new Circle (20);
		Circle occhioDxInt = new Circle (15);
		Circle occhioSxInt = new Circle (15);
		faccia.setFill(Color.PINK);
		faccia.setFill(Color.PINK);
		occhioDx.setFill(Color.WHITE);
		occhioSx.setFill(Color.WHITE);
		occhioSx.setCenterX(100);
		occhioSx.setCenterY(50);
		occhioDx.setCenterX(175);
		occhioDx.setCenterY(50);
		occhioDxInt.setFill(Color.BLUE);
		occhioSxInt.setFill(Color.BLUE);
		occhioSxInt.setCenterX(100);
		occhioSxInt.setCenterY(50);
		occhioDxInt.setCenterX(175);
		occhioDxInt.setCenterY(50);
		faccia.setCenterX(140);
		faccia.setCenterY(100);
		Line boccaDx = new Line (100, 160, 140, 140);
		Line boccaSx = new Line (180, 160, 140, 140);
		boccaDx.setStroke(Color.RED);
		boccaDx.setStrokeWidth(3);
		boccaSx.setStroke(Color.RED);
		boccaSx.setStrokeWidth(3);
		
		quadro.getChildren().add(faccia);
		quadro.getChildren().add(boccaDx);
		quadro.getChildren().add(boccaSx);
		quadro.getChildren().add(occhioSx);
		quadro.getChildren().add(occhioDx);
		quadro.getChildren().add(occhioSxInt);
		quadro.getChildren().add(occhioDxInt);


		

		



		Scene scena = new Scene(quadro, 220, 100);
		finestra.setTitle("Faccia");
		finestra.setScene(scena);
		finestra.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}