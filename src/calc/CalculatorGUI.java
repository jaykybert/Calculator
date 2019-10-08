package calc;

import java.io.File;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class CalculatorGUI extends Application {

	Label output;
	String operation = "";
	
	StringBuilder numberString; // Concatenate the entered numbers.
	StringBuilder outputText;	// Entire equation displayed on label.
	
	File cssFile = new File("style.css");

	public static void main(String[] args) {
		launch(args);
	}

	
	private int getNumber() {
		// Exception occurs if operation button is pressed when no numbers have been entered.
		try {
			return Integer.parseInt(numberString.toString());
		}
		catch(NumberFormatException e) { 
			return 0;
		}
	}
	
	private void updateOutputText(String s) {
		if(s.contentEquals("c")) // Clear output text.
			outputText.setLength(0);
		else
			outputText.append(s);
	}
	
	public void start(Stage stage) {
		stage.setTitle("Calculator");
		stage.setWidth(400);
		stage.setHeight(500);

		FlowPane root = new FlowPane(Orientation.VERTICAL);
		
		numberString = new StringBuilder("");
		outputText = new StringBuilder("");

		GridPane mainPad = new GridPane();
		
		mainPad.setHgap(5);
		mainPad.setVgap(5);
		
		output = new Label("");

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
		
		//CSS
		scene.getStylesheets().clear();
		scene.getStylesheets().add("file:///" + cssFile.getAbsolutePath().replace("\\", "/"));


		// Event Handling
		b0.setOnAction((actionEvent) -> {
			numberString.append("0");
			updateOutputText("0");
			output.setText(outputText.toString());

		});

		b1.setOnAction((actionEvent) -> {
			numberString.append("1");
			updateOutputText("1");
			output.setText(outputText.toString());

		});

		b2.setOnAction((actionEvent) -> {
			numberString.append("2");
			updateOutputText("2");
			output.setText(outputText.toString());

		});

		b3.setOnAction((actionEvent) -> {
			numberString.append("3");
			updateOutputText("3");
			output.setText(outputText.toString());

		});

		b4.setOnAction((actionEvent) -> {
			numberString.append("4");
			updateOutputText("4");
			output.setText(outputText.toString());

		});

		b5.setOnAction((actionEvent) -> {
			numberString.append("5");
			updateOutputText("5");
			output.setText(outputText.toString());

		});

		b6.setOnAction((actionEvent) -> {
			numberString.append("6");
			updateOutputText("6");
			output.setText(outputText.toString());
		});

		b7.setOnAction((actionEvent) -> {
			numberString.append("7");
			updateOutputText("7");
			output.setText(outputText.toString());

		});

		b8.setOnAction((actionEvent) -> {
			numberString.append("8");
			updateOutputText("8");
			output.setText(outputText.toString());

		});

		b9.setOnAction((actionEvent) -> {
			numberString.append("9");
			updateOutputText("9");
			output.setText(outputText.toString());

		});

		bC.setOnAction((actionEvent) -> {
			updateOutputText("c"); // PASS A SPECIFIC VALUE - CHECK IT INSIDE UPDATEOUTPUTTEXT. IF TRUE, RESET STRINGBUILDER (ALSO RESET THE NUMBERSTRING).
			output.setText(outputText.toString());

		});

		bE.setOnAction((actionEvent) -> {
			updateOutputText("=");
			output.setText(outputText.toString());

		});
		
		bA.setOnAction((actionEvent) -> {
			
			getNumber();
			updateOutputText(" + ");
			output.setText(outputText.toString());
			operation = "addition";

		});
		
		bS.setOnAction((actionEvent) -> {
			getNumber();
			updateOutputText(" - ");
			output.setText(outputText.toString());
			operation = "subtraction";

		});

		bD.setOnAction((actionEvent) -> {
			getNumber();
			updateOutputText(" / ");
			output.setText(outputText.toString());
			operation = "division";

		});

		bM.setOnAction((actionEvent) -> {
			getNumber();
			updateOutputText(" * ");
			output.setText(outputText.toString());
			operation = "multiplication";

		});




		stage.setScene(scene);
		stage.show();
	}
	

}
