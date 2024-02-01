package it.edu.iisgubbio.animazioni;

import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

public class Rimbalzo extends Application{
	
	Circle pallino = new Circle(10);
	int x = 150;
	int y= 0;
	boolean destra = true;
	boolean giu = true;


	public void start(Stage finestra) throws Exception {
		Pane quadro = new Pane();
		quadro.getChildren().add(pallino);


		Timeline timeline = new Timeline(new KeyFrame(
				Duration.millis(10),
				x -> aggiornaTimer()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

		Scene scene = new Scene(quadro,300,200);
		finestra.setTitle("Rimbalzo"); 
		finestra.setScene(scene);
		finestra.show();
		
	}

	public void aggiornaTimer(){
		
		if(destra) {
			x++;
		}
		if(giu) {
			y++;
		}
		if(x==300) {
			destra = false;
		}
		if(y==200) {
			giu = false;
		}
		if(destra == false) {
			x--;
		}
		if(giu == false) {
			y--;
		}
		if(x==0) {
			destra = true;
		}
		if(y==0) {
			giu = true;
		}
		pallino.setCenterX(x);
		pallino.setCenterY(y);
	}

	public static void main(String args[]){
		launch();
	}
}