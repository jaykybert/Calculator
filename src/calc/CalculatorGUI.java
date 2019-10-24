package calc;

import java.io.File;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.geometry.*;

public class CalculatorGUI extends Application {

	Label output = new Label("");
	StringBuilder numberString = new StringBuilder(""); // Concatenate the entered numbers.
	String lastAction = "";
	
	// Parsing the equation.
	ScriptEngineManager sem = new ScriptEngineManager();
	ScriptEngine se = sem.getEngineByName("JavaScript");

	Double sum = 0.0;

	// Keyboard input for keys that require shift-press.
	KeyCombination keyPlus = new KeyCodeCombination(KeyCode.EQUALS, KeyCodeCombination.SHIFT_DOWN);
	KeyCombination keyMult = new KeyCodeCombination(KeyCode.DIGIT8, KeyCodeCombination.SHIFT_DOWN);

	File cssFile = new File("style.css");

	public static void main(String[] args) {
		launch(args);
	}

	
	private double evaluateNumber(String s) {	
		try {
			// Cast to Double if any of the numbers or the sum contain a decimal. Otherwise return Integer.	
			if ((s.contains(".")) || se.eval(s).toString().contains(".")) return (Double) se.eval(s);
			else return (Integer) se.eval(s);
		}
		catch(ScriptException e) {
			return 0.0;
		}
	}


	public void start(Stage stage) {
		stage.setTitle("Calculator");
		stage.setMinHeight(400);
		stage.setMaxHeight(400);
		stage.setMinWidth(300);
		stage.setMaxWidth(300);

		FlowPane root = new FlowPane(Orientation.VERTICAL);
		GridPane mainPad = new GridPane();
		mainPad.setHgap(2);
		mainPad.setVgap(2);
		mainPad.setPadding(new Insets(10, 10, 10, 10));
		mainPad.setAlignment(Pos.CENTER);

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
		Button bR = new Button("R"); // Remove (last entry)
		Button bE = new Button("="); // Equals
		Button bA = new Button("+"); // Addition
		Button bS = new Button("-"); // Subtraction
		Button bD = new Button("/"); // Division
		Button bM = new Button("*"); // Multiplication
		Button bP = new Button("."); // Decimal Point

		mainPad.add(b1, 1, 0);
		mainPad.add(b2, 2, 0);
		mainPad.add(b3, 3, 0);
		mainPad.add(bA, 4, 0);
		
		mainPad.add(bC, 0, 1);
		mainPad.add(b4, 1, 1);
		mainPad.add(b5, 2, 1);
		mainPad.add(b6, 3, 1);
		mainPad.add(bS, 4, 1);
		
		mainPad.add(bR, 0, 2);
		mainPad.add(b7, 1, 2);
		mainPad.add(b8, 2, 2);
		mainPad.add(b9, 3, 2);
		mainPad.add(bD, 4, 2);
		
		mainPad.add(bP, 1, 3);
		mainPad.add(b0, 2, 3);
		mainPad.add(bE, 3, 3);
		mainPad.add(bM, 4, 3);

		Scene scene = new Scene(root, 300, 400);
		root.getChildren().addAll(output, mainPad);
		scene.getStylesheets().clear();
		scene.getStylesheets().add("file:///" + cssFile.getAbsolutePath().replace("\\", "/"));
		stage.setScene(scene);
		stage.show();

		// Event Handling
		b0.setOnAction((actionEvent) -> {
			numberString.append("0");
			output.setText(numberString.toString());
			lastAction = "number";

		});

		b1.setOnAction((actionEvent) -> {
			numberString.append("1");
			output.setText(numberString.toString());
			lastAction = "number";

		});

		b2.setOnAction((actionEvent) -> {
			numberString.append("2");
			output.setText(numberString.toString());
			lastAction = "number";

		});

		b3.setOnAction((actionEvent) -> {
			numberString.append("3");
			output.setText(numberString.toString());
			lastAction = "number";

		});

		b4.setOnAction((actionEvent) -> {
			numberString.append("4");
			output.setText(numberString.toString());
			lastAction = "number";

		});

		b5.setOnAction((actionEvent) -> {
			numberString.append("5");
			output.setText(numberString.toString());
			lastAction = "number";
		});

		b6.setOnAction((actionEvent) -> {
			numberString.append("6");
			output.setText(numberString.toString());
			lastAction = "number";
		});

		b7.setOnAction((actionEvent) -> {
			numberString.append("7");
			output.setText(numberString.toString());
			lastAction = "number";

		});

		b8.setOnAction((actionEvent) -> {
			numberString.append("8");
			output.setText(numberString.toString());
			lastAction = "number";

		});

		b9.setOnAction((actionEvent) -> {
			numberString.append("9");
			output.setText(numberString.toString());
			lastAction = "number";

		});

		bC.setOnAction((actionEvent) -> {
			// Reset everything.
			numberString.setLength(0);
			sum = 0.0;
			output.setText(numberString.toString());
			lastAction = "";

		});
		
		bR.setOnAction((actionEvent) -> {
			// Remove the last entry.
			if(numberString.length() > 0)
				numberString.deleteCharAt(numberString.length() - 1);
				
			output.setText(numberString.toString());
			lastAction = "number";
		});
		

		bE.setOnAction((actionEvent) -> {
			if(lastAction.contentEquals("number")) {
				try {
					sum = evaluateNumber(numberString.toString());
					numberString.replace(0, numberString.length(), sum.toString());
					lastAction = "equals";
				}
				catch(NullPointerException e) {	
				}
			}
			output.setText(numberString.toString());
		});

		bA.setOnAction((actionEvent) -> {
			if(lastAction.contentEquals("number")|lastAction.contentEquals("equals")) {
				numberString.append("+");
				lastAction = "operation";
			}
			else if(lastAction.contentEquals("operation")) {
				numberString.replace(numberString.length() - 1, numberString.length(), "+");
				lastAction = "operation";
			}
			output.setText(numberString.toString());
		});

		bS.setOnAction((actionEvent) -> {
			if(lastAction.contentEquals("number")|lastAction.contentEquals("equals")) {
				numberString.append("-");
				lastAction = "operation";
			}
			// Don't replace the previous operation, just append a minus sign (allowing for negative numbers).
			else if(lastAction.contentEquals("operation")) {
				numberString.append("-");
				lastAction = "operation";
			}
			output.setText(numberString.toString());
		});

		bD.setOnAction((actionEvent) -> {
			if(lastAction.contentEquals("number")|lastAction.contentEquals("equals")) {
				numberString.append("/");
				lastAction = "operation";
			}
			else if(lastAction.contentEquals("operation")) {
				numberString.replace(numberString.length() - 1, numberString.length(), "/");
				lastAction = "operation";
			}
			
			output.setText(numberString.toString());
		});

		bM.setOnAction((actionEvent) -> {
			if(lastAction.contentEquals("number")|lastAction.contentEquals("equals")) {
				numberString.append("*");
				lastAction = "operation";
			}
			else if(lastAction.contentEquals("operation")) {
				numberString.replace(numberString.length() - 1, numberString.length(), "*");
				lastAction = "operation";
			}
			
			output.setText(numberString.toString());
		});
		
		bP.setOnAction((actionEvent) -> {
		if(lastAction.contentEquals("number")) {
			numberString.append(".");
			lastAction = "decimal";
		}
		output.setText(numberString.toString());		
		});

		// Keyboard Support
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.DIGIT0 | key.getCode() == KeyCode.NUMPAD0) b0.fire();
			else if(key.getCode() == KeyCode.DIGIT1 | key.getCode() == KeyCode.NUMPAD1) b1.fire();
			else if(key.getCode() == KeyCode.DIGIT2 | key.getCode() == KeyCode.NUMPAD2) b2.fire();
			else if(key.getCode() == KeyCode.DIGIT3 | key.getCode() == KeyCode.NUMPAD3) b3.fire();
			else if(key.getCode() == KeyCode.DIGIT4 | key.getCode() == KeyCode.NUMPAD4) b4.fire();
			else if(key.getCode() == KeyCode.DIGIT5 | key.getCode() == KeyCode.NUMPAD5) b5.fire();
			else if(key.getCode() == KeyCode.DIGIT6 | key.getCode() == KeyCode.NUMPAD6) b6.fire();		
			else if(key.getCode() == KeyCode.DIGIT7 | key.getCode() == KeyCode.NUMPAD7) b7.fire();
			else if(keyMult.match(key)) bM.fire(); // Must come before b8, otherwise b8 fires.
			else if(key.getCode() == KeyCode.DIGIT8 | key.getCode() == KeyCode.NUMPAD8)b8.fire();
			else if(key.getCode() == KeyCode.DIGIT9 | key.getCode() == KeyCode.NUMPAD9) b9.fire();
			else if(keyPlus.match(key)) bA.fire();
			else if(key.getCode() == KeyCode.MINUS) bS.fire();
			else if(key.getCode() == KeyCode.SLASH) bD.fire();
			else if(key.getCode() == KeyCode.EQUALS) bE.fire();
			else if(key.getCode() == KeyCode.PERIOD) bP.fire();
			else if(key.getCode() == KeyCode.DELETE | key.getCode() == KeyCode.C) bC.fire();
			else if(key.getCode() == KeyCode.BACK_SPACE | key.getCode() == KeyCode.R) bR.fire();
		});
	}
}
