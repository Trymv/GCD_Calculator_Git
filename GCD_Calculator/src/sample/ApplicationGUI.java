package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class is the graphical user interface for a greatest common divisor calculator.
 * This calculator takes inn two numbers (a, b) and find the greatest common divisor of those two numbers where a >= b.
 *
 * @author TrymV
 * @version 0.1
 */
public class ApplicationGUI extends Application {
    private boolean fieldAHighlighted = true;
    private StringBuilder stringFieldA = new StringBuilder();
    private StringBuilder stringFieldB = new StringBuilder();
    private gcdCalculator greatestCommonDivisor = new gcdCalculator();

    /**
     * Sets up the graphical user interface and handles the button action.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Greatest common divider calculator");

        GridPane calculatorGrid = new GridPane();
        calculatorGrid.setAlignment(Pos.TOP_LEFT);
        calculatorGrid.setHgap(10);
        calculatorGrid.setVgap(10);
        calculatorGrid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(calculatorGrid, 380, 583);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:../StyleSheet/Calculator-icon.png"));
        scene.getStylesheets().add
                (ApplicationGUI.class.getResource("../StyleSheet/CalculatorStyleSheet.css").toExternalForm());

        //Adding text field a
        TextField textFieldA = new TextField();
        textFieldA.setAlignment(Pos.CENTER); //Should be in CSS, but can't get it to work
        calculatorGrid.add(textFieldA, 0, 5, 2, 2);
        textFieldA.setPromptText("a");
        textFieldA.setId("textFieldHighLighted");

        //Adding text field b
        TextField textFieldB = new TextField();
        textFieldB.setAlignment(Pos.CENTER); //Should be in CSS, but can't get it to work
        calculatorGrid.add(textFieldB, 2, 5, 2, 2);
        textFieldB.setPromptText("b");
        textFieldB.setId("textField");

        //Adding text field for the sum
        Label textFieldSum = new Label("");
        textFieldSum.setAlignment(Pos.CENTER); //Should be in CSS, but can't get it to work
        calculatorGrid.add(textFieldSum, 0, 1, 4, 2);
        textFieldSum.setId("textFieldSum");

        //Adding dialog window to show math calculations in.
        Alert mathCalculationDialog = new Alert(Alert.AlertType.INFORMATION);
        mathCalculationDialog.setTitle("Math Calculations");
        mathCalculationDialog.setHeaderText("Greatest common divisor calculations:");

        //Adding dialog window to CSS
        DialogPane dialogPane = mathCalculationDialog.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("../StyleSheet/CalculatorStyleSheet.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");

        //Button A to highlight the a field.
        Button btnA = new Button("a");
        btnA.setId("buttonStyle");
        btnA.setOnAction(e -> {
            fieldAHighlighted = true;
            textFieldA.setId("textFieldHighLighted");
            textFieldB.setId("textField");
        });

        //Button 0 to append 0 on the highlighted field.
        Button btnZero = new Button("0");
        btnZero.setId("buttonStyle");
        btnZero.setOnAction(e -> {
            if(fieldAHighlighted && !this.stringFieldA.toString().isEmpty()) {
                this.stringFieldA.append("0");
                textFieldA.setText(stringFieldA.toString());
            } else if(!fieldAHighlighted && !this.stringFieldB.toString().isEmpty()){
                this.stringFieldB.append("0");
                textFieldB.setText(stringFieldB.toString());
            }
        });

        //Button B to highlight the b field.
        Button btnB = new Button("b");
        btnB.setId("buttonStyle");
        btnB.setOnAction(e -> {
            fieldAHighlighted = false;
            textFieldB.setId("textFieldHighLighted");
            textFieldA.setId("textField");
        });

        //Button =
        Button btnEqual = new Button("=");
        btnEqual.setId("buttonStyle");
        btnEqual.setOnAction(e -> {
            if(textFieldA.getText().matches(".*[0-9]+.*") && textFieldB.getText().matches(".*[0-9]+.*")
                    && textFieldA.getText().length() < 10 && textFieldB.getText().length() < 10) {
                int fieldAValue = Integer.parseInt(textFieldA.getText());
                int fieldBValue = Integer.parseInt(textFieldB.getText());

                if (fieldAValue >= fieldBValue) {
                    textFieldSum.setText(Integer.toString(greatestCommonDivisor.findGCD(fieldAValue, fieldBValue)));
                } else {
                    textFieldSum.setText("ERROR");
                }
            } else {
                textFieldSum.setText("ERROR");
            }
        });

        //Button 1 to append 1 on the highlighted field.
        Button btnOne = new Button("1");
        btnOne.setId("buttonStyle");
        btnOne.setOnAction(e -> {
            if(fieldAHighlighted) {
                this.stringFieldA.append("1");
                textFieldA.setText(stringFieldA.toString());
            } else {
                this.stringFieldB.append("1");
                textFieldB.setText(stringFieldB.toString());
            }
        });

        //Button 2 to append 2 on the highlighted field.
        Button btnTwo = new Button("2");
        btnTwo.setId("buttonStyle");
        btnTwo.setOnAction(e -> {
            if(fieldAHighlighted) {
                this.stringFieldA.append("2");
                textFieldA.setText(stringFieldA.toString());
            } else {
                this.stringFieldB.append("2");
                textFieldB.setText(stringFieldB.toString());
            }
        });

        //Button 3 to append 3 on the highlighted field.
        Button btnThree = new Button("3");
        btnThree.setId("buttonStyle");
        btnThree.setOnAction(e -> {
            if(fieldAHighlighted) {
                this.stringFieldA.append("3");
                textFieldA.setText(stringFieldA.toString());
            } else {
                this.stringFieldB.append("3");
                textFieldB.setText(stringFieldB.toString());
            }
        });

        //Button SM
        Button btnSM = new Button("SM");
        btnSM.setId("buttonStyle");
        btnSM.setOnAction(e -> {
            mathCalculationDialog.setContentText(greatestCommonDivisor.getMathCalculationAsString());
            mathCalculationDialog.showAndWait();
        });

        //Button 4 to append 4 on the highlighted field.
        Button btnFour = new Button("4");
        btnFour.setId("buttonStyle");
        btnFour.setOnAction(e -> {
            if(fieldAHighlighted) {
                this.stringFieldA.append("4");
                textFieldA.setText(stringFieldA.toString());
            } else {
                this.stringFieldB.append("4");
                textFieldB.setText(stringFieldB.toString());
            }
        });

        //Button 5 to append 5 on the highlighted field.
        Button btnFive = new Button("5");
        btnFive.setId("buttonStyle");
        btnFive.setOnAction(e -> {
            if(fieldAHighlighted) {
                this.stringFieldA.append("5");
                textFieldA.setText(stringFieldA.toString());
            } else {
                this.stringFieldB.append("5");
                textFieldB.setText(stringFieldB.toString());
            }
        });

        //Button 6 to append 6 on the highlighted field.
        Button btnSix = new Button("6");
        btnSix.setId("buttonStyle");
        btnSix.setOnAction(e -> {
            if(fieldAHighlighted) {
                this.stringFieldA.append("6");
                textFieldA.setText(stringFieldA.toString());
            } else {
                this.stringFieldB.append("6");
                textFieldB.setText(stringFieldB.toString());
            }
        });

        //Button CE to clear all fields.
        Button btnCE = new Button("CE");
        btnCE.setId("buttonStyle");
        btnCE.setOnAction(e -> {
            stringFieldA.delete(0, stringFieldA.length());
            stringFieldB.delete(0, stringFieldB.length());
            textFieldSum.setText("");
            textFieldA.setText(stringFieldA.toString());
            textFieldB.setText(stringFieldB.toString());
        });

        //Button 7 to append 7 on the highlighted field.
        Button btnSeven = new Button("7");
        btnSeven.setId("buttonStyle");
        btnSeven.setOnAction(e -> {
            if(fieldAHighlighted) {
                this.stringFieldA.append("7");
                textFieldA.setText(stringFieldA.toString());
            } else {
                this.stringFieldB.append("7");
                textFieldB.setText(stringFieldB.toString());
            }
        });

        //Button 8 to append 8 on the highlighted field.
        Button btnEight = new Button("8");
        btnEight.setId("buttonStyle");
        btnEight.setOnAction(e -> {
            if(fieldAHighlighted) {
                this.stringFieldA.append("8");
                textFieldA.setText(stringFieldA.toString());
            } else {
                this.stringFieldB.append("8");
                textFieldB.setText(stringFieldB.toString());
            }
        });

        //Button 9 to append 9 on the highlighted field.
        Button btnNine = new Button("9");
        btnNine.setId("buttonStyle");
        btnNine.setOnAction(e -> {
            if(fieldAHighlighted) {
                this.stringFieldA.append("9");
                textFieldA.setText(stringFieldA.toString());
            } else {
                this.stringFieldB.append("9");
                textFieldB.setText(stringFieldB.toString());
            }
        });

        //Button Erase to erase 1 char on the highlighted field.
        Button btnErase = new Button("<--");
        btnErase.setId("buttonStyle");
        btnErase.setOnAction(e -> {
            if(fieldAHighlighted && this.stringFieldA.length() >= 1) {
                this.stringFieldA.setLength(stringFieldA.length() -1);
                textFieldA.setText(stringFieldA.toString());
            } else if(!fieldAHighlighted && this.stringFieldB.length() >= 1){
                this.stringFieldB.setLength(stringFieldB.length() -1);
                textFieldB.setText(stringFieldB.toString());
            }
        });

        //VBox Row 1
        VBox vbButtonsRowOne = new VBox();
        vbButtonsRowOne.setSpacing(10);
        vbButtonsRowOne.getChildren().addAll(btnSeven, btnFour, btnOne, btnA);
        calculatorGrid.add(vbButtonsRowOne, 0, 10);

        //VBox Row 2
        VBox vbButtonsRowTwo = new VBox();
        vbButtonsRowTwo.setSpacing(10);
        vbButtonsRowTwo.getChildren().addAll(btnEight, btnFive, btnTwo,  btnZero);
        calculatorGrid.add(vbButtonsRowTwo, 1, 10);

        //VBox Row 3
        VBox vbButtonsRowThree = new VBox();
        vbButtonsRowThree.setSpacing(10);
        vbButtonsRowThree.getChildren().addAll(btnNine, btnSix, btnThree, btnB);
        calculatorGrid.add(vbButtonsRowThree, 2, 10);

        //VBox Row 4
        VBox vbButtonsRowFour = new VBox();
        vbButtonsRowFour.setSpacing(10);
        vbButtonsRowFour.getChildren().addAll(btnErase, btnCE, btnSM, btnEqual);
        calculatorGrid.add(vbButtonsRowFour, 3, 10);

        //Adding text: a >= b
        Label abLabel = new Label("      a    >=    b");
        abLabel.setId("abLabel");
        calculatorGrid.add(abLabel, 1, 9, 2, 1);

        //Showing the stage
        primaryStage.show();
        //Makes the button a get focus instead of the text fields
        btnA.requestFocus();
    }
}