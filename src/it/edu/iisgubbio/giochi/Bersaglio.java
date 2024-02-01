package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Bersaglio extends Application{
	
	
	Circle pallinoRosso = new Circle(15);
	Label lPunteggio = new Label("0");
	int x = 150;
	int y= 0;
	boolean verde = false;
	boolean rosso = false;
	Pane quadro = new Pane();
	int punteggio = 0;



	public void start(Stage finestra) throws Exception {
		quadro.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> gestore(e));
		
		pallinoRosso.setFill(Color.RED);
		quadro.getChildren().add(pallinoRosso);
		quadro.getChildren().add(lPunteggio);
		lPunteggio.setLayoutX(250);
		lPunteggio.setLayoutY(0);

		Timeline timeline = new Timeline(new KeyFrame(
				Duration.seconds(1),
				x -> aggiornaTimer()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		Scene scene = new Scene(quadro,500,500);
		finestra.setTitle("Rimbalzo"); 
		finestra.setScene(scene);
		finestra.show();

	}

	public void gestore(MouseEvent e){
		double distanzaPunto = Math.sqrt((e.getX()-pallinoRosso.getCenterX())*(e.getX()-pallinoRosso.getCenterX())+((e.getY()-pallinoRosso.getCenterY())*(e.getY()-pallinoRosso.getCenterY())));
		System.out.println(distanzaPunto);
	
		if(distanzaPunto < pallinoRosso.getRadius()) {
			punteggio += 1;
			lPunteggio.setText(""+ punteggio);
			
		}

	}
	
	public void aggiornaTimer(){	

		pallinoRosso.setCenterX(Math.random()*485);
		pallinoRosso.setCenterY(Math.random()*485);


	}
	

	public static void main(String args[]){
		launch();
	}
}