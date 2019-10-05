package calc;

import javafx.application.*;	// Run
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
		stage.setWidth(400);
		stage.setHeight(500);

		FlowPane root = new FlowPane(Orientation.VERTICAL);


		GridPane mainPad = new GridPane();
		
		mainPad.setHgap(50);
		mainPad.setVgap(78);


		// Consider setting the button height/width and remove scaling.
		// Size can be done using external CSS.
		Scale upScale = new Scale(3, 4);

		// Buttons
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
		Button bC = new Button("C"); // Clear 
		Button bE = new Button("="); // Equals
		Button bA = new Button("+"); // Addition
		Button bS = new Button("-"); // Subtraction
		Button bD = new Button("/"); // Division
		Button bM = new Button("*"); // Multiplication

		// Scale the buttons.
		
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
		bC.getTransforms().add(upScale);
		bE.getTransforms().add(upScale);
		bA.getTransforms().add(upScale);
		bS.getTransforms().add(upScale);
		bD.getTransforms().add(upScale);
		bM.getTransforms().add(upScale);
		 
		output = new Label("Test");

		mainPad.add(b1, 0, 0);
		mainPad.add(b2, 1, 0);
		mainPad.add(b3, 2, 0);
		mainPad.add(bA, 3, 0);
		
		mainPad.add(b4, 0, 1);
		mainPad.add(b5, 1, 1);
		mainPad.add(b6, 2, 1);
		mainPad.add(bS, 3, 1);
		
		mainPad.add(b7, 0, 2);
		mainPad.add(b8, 1, 2);
		mainPad.add(b9, 2, 2);
		mainPad.add(bD, 3, 2);
		
		mainPad.add(bC, 0, 3);
		mainPad.add(b0, 1, 3);
		mainPad.add(bE, 2, 3);
		mainPad.add(bM, 3, 3);
		
		Scene scene = new Scene(root, 500, 500);

		root.getChildren().addAll(output, mainPad);


		// Event Handling
		b0.setOnAction((actionEvent) -> {
			output.setText("0 Placeholder");

		});

		b1.setOnAction((actionEvent) -> {
			output.setText("1 Placeholder");

		});

		b2.setOnAction((actionEvent) -> {
			output.setText("2 Placeholder");

		});

		b3.setOnAction((actionEvent) -> {
			output.setText("3 Placeholder");

		});

		b4.setOnAction((actionEvent) -> {
			output.setText("4 Placeholder");

		});

		b5.setOnAction((actionEvent) -> {
			output.setText("5 Placeholder");

		});

		b6.setOnAction((actionEvent) -> {
			output.setText("6 Placeholder");

		});

		b7.setOnAction((actionEvent) -> {
			output.setText("7 Placeholder");

		});

		b8.setOnAction((actionEvent) -> {
			output.setText("8 Placeholder");

		});

		b9.setOnAction((actionEvent) -> {
			output.setText("9 Placeholder");

		});

		bC.setOnAction((actionEvent) -> {
			output.setText("Clear Function");

		});

		bE.setOnAction((actionEvent) -> {
			output.setText("Equals Function");

		});
		
		bA.setOnAction((actionEvent) -> {
			output.setText("Addition Function");

		});
		
		bS.setOnAction((actionEvent) -> {
			output.setText("Subtraction Function");

		});

		bD.setOnAction((actionEvent) -> {
			output.setText("Division Function");

		});

		bM.setOnAction((actionEvent) -> {
			output.setText("Multiplication Function");

		});



		stage.setScene(scene);
		stage.show();
	}
}
