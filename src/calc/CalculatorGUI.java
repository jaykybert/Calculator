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

	StringBuilder numberString; // Concatenate the entered numbers.
	StringBuilder outputText;	// Entire equation displayed on label.
	
	String operation; // One of: + - / *
	
	boolean equalsPressed = false;
	
	int num1, num2, sum; // Consider converting to double, allow the user to enter decimal points.
	
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
	
	
	public void start(Stage stage) {
		stage.setTitle("Calculator");
		stage.setMinHeight(400);
		stage.setMaxHeight(400);
		stage.setMinWidth(300);
		stage.setMaxWidth(300);

		FlowPane root = new FlowPane(Orientation.VERTICAL);
		
		numberString = new StringBuilder("");
		outputText = new StringBuilder("");

		GridPane mainPad = new GridPane();
		
		mainPad.setHgap(2);
		mainPad.setVgap(2);
		mainPad.setPadding(new Insets(10, 10, 10, 10));
		mainPad.setAlignment(Pos.CENTER);
		
		output = new Label("");
		output.setAlignment(Pos.CENTER);

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
		
		Scene scene = new Scene(root, 300, 400);
		
		root.getChildren().addAll(output, mainPad);

		scene.getStylesheets().clear();
		scene.getStylesheets().add("file:///" + cssFile.getAbsolutePath().replace("\\", "/"));
		stage.setScene(scene);
		stage.show();


		// Event Handling
		b0.setOnAction((actionEvent) -> {
			numberString.append("0");
			outputText.append("0");
			output.setText(outputText.toString());

		});

		b1.setOnAction((actionEvent) -> {
			numberString.append("1");
			outputText.append("1");
			output.setText(outputText.toString());

		});

		b2.setOnAction((actionEvent) -> {
			numberString.append("2");
			outputText.append("2");
			output.setText(outputText.toString());

		});

		b3.setOnAction((actionEvent) -> {
			numberString.append("3");
			outputText.append("3");
			output.setText(outputText.toString());

		});

		b4.setOnAction((actionEvent) -> {
			numberString.append("4");
			outputText.append("4");
			output.setText(outputText.toString());

		});

		b5.setOnAction((actionEvent) -> {
			numberString.append("5");
			outputText.append("5");
			output.setText(outputText.toString());

		});

		b6.setOnAction((actionEvent) -> {
			numberString.append("6");
			outputText.append("6");
			output.setText(outputText.toString());
		});

		b7.setOnAction((actionEvent) -> {
			numberString.append("7");
			outputText.append("7");
			output.setText(outputText.toString());

		});

		b8.setOnAction((actionEvent) -> {
			numberString.append("8");
			outputText.append("8");
			output.setText(outputText.toString());

		});

		b9.setOnAction((actionEvent) -> {
			numberString.append("9");
			outputText.append("9");
			output.setText(outputText.toString());

		});

		bC.setOnAction((actionEvent) -> {
			// Reset output, number concatenation, and number variables.
			outputText.setLength(0); 
			numberString.setLength(0);
			num1 = num2 = 0;
			output.setText(outputText.toString());
		});

		bE.setOnAction((actionEvent) -> {
			equalsPressed = true;
			num2 = getNumber();
			
			switch(operation) {
			case "+":
				sum = num1 + num2;
				break;
			case "-":
				sum = num1 - num2;
				break;
			case "/":
				sum = num1 / num2;
				break;
			case "*":
				sum = num1 * num2;
			}			
			outputText.append(" = " + sum + " ");
			output.setText(outputText.toString());
			
			num1 = sum; // The first number is now the sum.
			num2 = 0;
		});
		
		bA.setOnAction((actionEvent) -> {
			operation = "+";
			if(equalsPressed) // First number is now the result of the last equation.
				num2 = getNumber();
			else
				num1 = getNumber();
			
			outputText.append("+");
			// Reset the numberString after getting the first number.
			numberString.setLength(0);	
			output.setText(outputText.toString());		
		});
		
		bS.setOnAction((actionEvent) -> {
			operation = "-";
			if(equalsPressed)
				num2 = getNumber();
			else
				num1 = getNumber();
			
			outputText.append("-");
			numberString.setLength(0);
			output.setText(outputText.toString());	
		});

		bD.setOnAction((actionEvent) -> {
			operation = "/";
			if(equalsPressed)
				num2 = getNumber();
			else
				num1 = getNumber();
			
			outputText.append("/");
			numberString.setLength(0);
			output.setText(outputText.toString());
		});

		bM.setOnAction((actionEvent) -> {
			operation = "*";
			if(equalsPressed)
				num2 = getNumber();
			else
				num1 = getNumber();
			
			outputText.append("*");
			numberString.setLength(0);
			output.setText(outputText.toString());
		});
	}
}
