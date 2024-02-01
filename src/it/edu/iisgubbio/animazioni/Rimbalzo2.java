package it.edu.iisgubbio.animazioni;

import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

public class Rimbalzo2 extends Application{
	Circle pallino = new Circle(10);
	double x = 150;
	double y= 0;
	boolean destra = true;
	boolean giù = true;
	double numeroCasuale = 0;



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
			x ++;
		} 
		if(giù) {
			y ++;
		}
		if(x>=300) {
			numeroCasuale = (Math.random()*0.4)+0.8;
			destra = false;
		}
		if(y>=200) {
			numeroCasuale = (Math.random()*0.4)+0.8;
			giù = false;
		}
		if(destra == false) {
			x -= numeroCasuale;
		}
		if(giù == false) {
			y -= numeroCasuale;
		}
		if(x<=0) {
			numeroCasuale = (Math.random()*0.4)+0.8;
			destra = true;
		}
		if(y<=0) {
			numeroCasuale = (Math.random()*0.4)+0.8;
			giù = true;
		}
		pallino.setCenterX(x);
		pallino.setCenterY(y);
	}

	public static void main(String args[]){
		launch();
	}
}