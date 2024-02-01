package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.control.Label;


public class Stecchette extends Application{
	
	final int LARGHEZZA_AREA_GIOCO = 500;
	final int ALTEZZA_AREA_GIOCO = 400;
	final int LARGHEZZA_STECCHETTA = 20;
	final int ALTEZZA_STECCHETTA = 80;
	final int SENSIBILITA = 6;
	Label punteggioSinistra = new Label();
	Label punteggioDestra = new Label();
	Pane quadro = new Pane();
	Circle pallino = new Circle(10);
	Rectangle stecchetta1 = new Rectangle(LARGHEZZA_STECCHETTA, ALTEZZA_STECCHETTA);
	Rectangle stecchetta2 = new Rectangle(LARGHEZZA_STECCHETTA, ALTEZZA_STECCHETTA);
	Line rete = new Line();
	boolean destra = true;
	boolean giù = true;
	boolean delay = false;
	boolean menu = true;
	double numeroCasuale = 0;
	double xPallino = LARGHEZZA_AREA_GIOCO / 2;
	double yPallino = ALTEZZA_AREA_GIOCO / 2;
	int punteggioStecchettaSinistra = 0;
	int punteggioStecchettaDestra = 0;
	Timeline timelineRimbalzo;

	

	public void start(Stage finestra) throws Exception {
		
		Pane quadro = new Pane();
		quadro.getChildren().add(punteggioSinistra);
		quadro.getChildren().add(punteggioDestra);
		quadro.getChildren().add(stecchetta2);
		stecchetta1.setId("coloreStecchettePallina");
		stecchetta2.setId("coloreStecchettePallina");
		pallino.setId("coloreStecchettePallina");
		quadro.getChildren().add(stecchetta1);
		quadro.getChildren().add(stecchetta2);
		quadro.getChildren().add(punteggioSinistra);
		quadro.getChildren().add(punteggioDestra);
		quadro.getChildren().add(rete);
		quadro.setPrefSize(LARGHEZZA_AREA_GIOCO, ALTEZZA_AREA_GIOCO);
		
		
		punteggioSinistra.setLayoutX(125);
		punteggioDestra.setLayoutX(375);
		punteggioSinistra.setLayoutY(0);
		punteggioDestra.setLayoutY(0);
		stecchetta1.setX(10);
		stecchetta1.setY(100);
		stecchetta2.setX(LARGHEZZA_AREA_GIOCO - 10 - LARGHEZZA_STECCHETTA);
		stecchetta2.setY(100);
		rete.setStartX(LARGHEZZA_AREA_GIOCO / 2);
		rete.setStartY(0);
		rete.setEndX(LARGHEZZA_AREA_GIOCO / 2);
		rete.setEndY(ALTEZZA_AREA_GIOCO);
		rete.setId("lineaDiMezzo");
		

		Scene scene = new Scene(quadro);
		finestra.setTitle("PONG"); 
		finestra.setScene(scene);
		finestra.show();
		scene.getStylesheets().add("it/edu/iisgubbio/animazioni/Stile.css");
		
		quadro.getChildren().add(pallino);

		timelineRimbalzo = new Timeline(new KeyFrame(
				Duration.millis(10),
				x -> aggiornaTimerRimbalzo()));
		timelineRimbalzo.setCycleCount(Timeline.INDEFINITE);
		timelineRimbalzo.play();

		scene.setOnKeyPressed(e -> pigiato(e));

		Timeline timelineDelay = new Timeline(new KeyFrame(
				Duration.seconds(2),
				x -> aggiornaTimerDelay()));
		timelineDelay.setCycleCount(Timeline.INDEFINITE);
		timelineDelay.play();

	}
	
	public void aggiornaTimerDelay() {
		if(delay) {
			
			xPallino = LARGHEZZA_AREA_GIOCO / 2;
			yPallino = ALTEZZA_AREA_GIOCO / 2;
			pallino.setVisible(true);
			timelineRimbalzo.play();
			delay = false;

		}
	}

	public void pigiato(KeyEvent evento) {
		
		if(stecchetta2.getY() >= 0) {
		
			if(evento.getCode() == KeyCode.UP ) {
			stecchetta2.setY( stecchetta2.getY() - SENSIBILITA);
			}
		}
		if(stecchetta1.getY() >= 0) {
			if(evento.getText().equals("w") || evento.getText().equals("W")) {
			stecchetta1.setY( stecchetta1.getY() - SENSIBILITA);
			}
		}
		
		if(stecchetta2.getY() <= ALTEZZA_AREA_GIOCO-ALTEZZA_STECCHETTA) {
			
			if(evento.getCode() == KeyCode.DOWN ) {
			stecchetta2.setY( stecchetta2.getY() + SENSIBILITA);
			}
		}
		if(stecchetta1.getY() <= ALTEZZA_AREA_GIOCO-ALTEZZA_STECCHETTA) {

			if(evento.getText().equals("s") || evento.getText().equals("S")) {
			stecchetta1.setY( stecchetta1.getY() + SENSIBILITA);
			}
		}
	}
	
	public void aggiornaTimerRimbalzo(){
			
			if(destra) {
				xPallino ++;
			}
			if(giù) {
				yPallino ++;
			}
			if(xPallino>=LARGHEZZA_AREA_GIOCO) {
				numeroCasuale = (Math.random()*0.5)+0.8;
				destra = false;
				punteggioStecchettaSinistra += 1;
				punteggioSinistra.setText("" + punteggioStecchettaSinistra);
				delay = true;
				destra = (Math.random()>0.5);
				giù = (Math.random()>0.5);
				timelineRimbalzo.pause();
				pallino.setVisible(false);

			}
			if(yPallino>=ALTEZZA_AREA_GIOCO) {
				numeroCasuale = (Math.random()*0.5)+0.8;
				giù = false;
			}
			if(stecchetta1.getY() <= yPallino && yPallino <= stecchetta1.getY() + ALTEZZA_STECCHETTA && stecchetta1.getX() <= xPallino && xPallino <= stecchetta1.getX() + LARGHEZZA_STECCHETTA) {
				numeroCasuale = (Math.random()*0.5)+0.8;
				destra = true;
			}
			if(stecchetta2.getY() <= yPallino && yPallino <= stecchetta2.getY() + ALTEZZA_STECCHETTA && stecchetta2.getX() <= xPallino && xPallino <= stecchetta2.getX() + LARGHEZZA_STECCHETTA) {
				numeroCasuale = (Math.random()*0.5)+0.8;
				destra = false;
			}
			if(destra == false) {
				xPallino -= numeroCasuale;
			}
			if(giù == false) {
				yPallino -= numeroCasuale;
			}
			if(xPallino<=0) {
				numeroCasuale = (Math.random()*0.5)+0.8;
				destra = true;
				punteggioStecchettaDestra += 1;
				punteggioDestra.setText("" + punteggioStecchettaDestra);
				delay = true;
				destra = (Math.random()>0.5);
				giù = (Math.random()>0.5);
				timelineRimbalzo.pause();
				pallino.setVisible(false);
			}
			if(yPallino<=0) {
				numeroCasuale = (Math.random()*0.5)+0.8;
				giù = true;
			}
			pallino.setCenterX(xPallino);
			pallino.setCenterY(yPallino);
		}

	public static void main(String args[]){
		launch();
	}
}