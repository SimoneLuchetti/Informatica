package it.edu.iisgubbio.Esercizio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * La mia prima classe
 */
public class CiaoMondo2 extends Application {

	Button bValentina = new Button();

  public void start(Stage finestra) {
	  
    BorderPane principale = new BorderPane();
    
    bValentina.setText("Cane");
    principale.setCenter(bValentina);
    bValentina.setOnAction(e -> esegui());


    Scene scena = new Scene(principale, 300, 250);

    finestra.setTitle("Hello World!");
    finestra.setScene(scena);
    finestra.show();
  }

  public void esegui(){
	  bValentina.setText("rana");
  }
  

  public static void main(String[] args) {
    launch(args);
  }
}