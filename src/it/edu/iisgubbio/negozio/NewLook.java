 package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NewLook extends Application {
	
	CheckBox sCavigliere = new CheckBox();
	CheckBox sBracciali = new CheckBox();
	TextField cKm = new TextField();
	RadioButton rNuoto = new RadioButton();
	RadioButton rBici = new RadioButton();
	RadioButton rCorsa = new RadioButton();
	Label lCalorie = new Label();
	Label lEquipaggiamento = new Label();
	Label lModalità = new Label();
	Label lKm = new Label();
	Button pCalcolaCalorie = new Button();
	ToggleGroup gModalità = new ToggleGroup();
	Image uomoCheCorre = new Image(getClass().getResourceAsStream("UomoCheCorre.png"));
    ImageView uomoCorre= new ImageView(uomoCheCorre);
	Image uomoCheNuota = new Image(getClass().getResourceAsStream("UomoCheNuota.png"));
    ImageView uomoNuota = new ImageView(uomoCheNuota);
    Image uomoInBici = new Image(getClass().getResourceAsStream("UomoInBici.png"));
    ImageView uomoBici = new ImageView(uomoInBici);

	
	public void start(Stage finestra) {

		GridPane griglia = new GridPane();
		lKm.setText("Inserisci KM percorsi");
		rNuoto.setText("Nuoto");
		rBici.setText("Bici");
		rCorsa.setText("Corsa");
		lEquipaggiamento.setText("Equipaggiamento");
		lModalità.setText("Modalità");
		sCavigliere.setText("Cavigliere");
		sBracciali.setText("Bracciali");
		pCalcolaCalorie.setText("Calcola Calorie");
		griglia.add(lKm, 0, 0);
		griglia.add(lModalità, 0, 1);
		griglia.add(rNuoto, 0, 2);
		griglia.add(rBici, 0, 3);
		griglia.add(rCorsa, 0, 4);
		griglia.add(pCalcolaCalorie, 0, 5);
		griglia.add(cKm, 1, 0);
		griglia.add(lEquipaggiamento, 1, 1);
		griglia.add(sBracciali, 1, 2);
		griglia.add(sCavigliere, 1, 3);
		griglia.add(lCalorie, 1, 5);
		pCalcolaCalorie.setOnAction(e -> calcolaCalorie());
		rNuoto.setGraphic(uomoNuota);
		rCorsa.setGraphic(uomoCorre);
		rBici.setGraphic(uomoBici);
		uomoNuota.setFitHeight(30);
		uomoNuota.setPreserveRatio(true);
		uomoCorre.setFitHeight(30);
		uomoCorre.setPreserveRatio(true);
		uomoBici.setFitHeight(30);
		uomoBici.setPreserveRatio(true);
		
		rNuoto.setToggleGroup(gModalità);
		rCorsa.setToggleGroup(gModalità);
		rBici.setToggleGroup(gModalità);
		rNuoto.setSelected(true);

		
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene scena = new Scene(griglia,300,250);

		finestra.setTitle("NewLook");
		finestra.setScene(scena);
		finestra.show();
		
	}
	
	
	public void  calcolaCalorie() {
		
		String kmStr = cKm.getText();
		if(kmStr.equals("")) {
			kmStr = "0";
		}
		double calorie = Double.parseDouble(kmStr);
		
		if(calorie == 0) {
			lCalorie.setText("L'utente non ha percorso alcun Km");
		}else {
			if(rNuoto.isSelected()) {
				calorie = calorie*21;
			}
			if(rCorsa.isSelected()) {
				calorie = calorie*12;
			}
			if(rBici.isSelected()) {
				calorie = calorie*7;
			}
			if(sBracciali.isSelected()) {
				calorie = calorie*1.18;
			}
			if(sCavigliere.isSelected()) {
				calorie = calorie*1.35;
			}
		
		lCalorie.setText("Le calorie bruciate sono: " + calorie + "Kcal");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}