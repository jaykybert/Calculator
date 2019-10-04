package calc;

import javafx.application.*;	// Run
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*; // Components
import javafx.scene.transform.*;
import javafx.event.*;
import javafx.geometry.*;

public class CalculatorGUI extends Application {
	
	Label output;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		stage.setTitle("Calculator");
		stage.setWidth(500);
		stage.setHeight(500);
		

		GridPane numberPad = new GridPane();
		numberPad.setHgap(50);
		numberPad.setVgap(76);


		Scale upScale = new Scale(3, 4);
	
		// Number Buttons
		Button b0 = new Button("0");
		Button b1 = new Button("1");
		Button b2 = new Button("2");
		Button b3 = new Button("3");
		Button b4 = new Button("4");
		Button b5 = new Button("5");
		Button b6 = new Button("6");
		Button b7 = new Button("7");
		Button b8 = new Button("8");
		Button b9 = new Button("9");

		// Scale the buttons.
		/*
		b0.getTransforms().add(upScale);
		b1.getTransforms().add(upScale);
		b2.getTransforms().add(upScale);
		b3.getTransforms().add(upScale);
		b4.getTransforms().add(upScale);
		b5.getTransforms().add(upScale);
		b6.getTransforms().add(upScale);
		b7.getTransforms().add(upScale);
		b8.getTransforms().add(upScale);
		b9.getTransforms().add(upScale);
		*/
		output = new Label("");
		
		numberPad.add(b1, 0, 0);
		numberPad.add(b2, 1, 0);
		numberPad.add(b3, 2, 0);
		numberPad.add(b4, 0, 1);
		numberPad.add(b5, 1, 1);
		numberPad.add(b6, 2, 1);
		numberPad.add(b7, 0, 2);
		numberPad.add(b8, 1, 2);
		numberPad.add(b9, 2, 2);
		numberPad.add(b0, 1, 3);
		Scene scene = new Scene(numberPad, 500, 500);
		
	
		// Event Handling
		b1.setOnAction((actionEvent) -> output.setText("One"));
		
		
		stage.setScene(scene);
		stage.show();
	}
}
