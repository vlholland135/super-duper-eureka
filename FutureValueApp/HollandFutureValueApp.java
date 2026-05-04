
/**
 * Holland, Victoria
 * CIS 505 - Intermediate Java Programming
 * Bellevue University
 * Assignment 7.2 - FutureValueApp
 *
 * This program builds a JavaFX GUI application that calculates
 * the future value of a monthly investment over a given number
 * of years at a specified annual interest rate.
 */

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HollandFutureValueApp extends Application {

    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();
    private TextArea taFutureValue = new TextArea();

    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblYears = new Label("Years:");
    private Label lblOutput = new Label("");

    private ComboBox<Integer> cboYears = new ComboBox<>();

    private Button btnClear = new Button("Clear");
    private Button btnCalculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        for (int i = 1; i <= 30; i++) {
            cboYears.getItems().add(i);
        }
        cboYears.getSelectionModel().selectFirst();

        lblInterestRateFormat.setTextFill(Color.RED);

        pane.add(lblMonthlyPayment, 0, 0);
        pane.add(txtMonthlyPayment, 1, 0);

        pane.add(lblInterestRate, 0, 1);
        pane.add(txtInterestRate, 1, 1);

        pane.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);

        pane.add(lblYears, 0, 3);
        pane.add(cboYears, 1, 3);

        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalculate);
        pane.add(actionBtnContainer, 1, 4);

        pane.add(lblOutput, 0, 5);
        pane.add(taFutureValue, 0, 6, 2, 1);
        taFutureValue.setEditable(false);

        btnCalculate.setOnAction(e -> calculateFutureValue());
        btnClear.setOnAction(e -> clearFields());

        Scene scene = new Scene(pane, 350, 300);
        primaryStage.setTitle("Holland Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateFutureValue() {
        try {
            double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText().trim());
            double annualRate = Double.parseDouble(txtInterestRate.getText().trim());
            int years = cboYears.getValue();

            double monthlyRate = annualRate / 100 / 12;
            int numMonths = years * 12;

            double futureValue = monthlyPayment
                    * ((Math.pow(1 + monthlyRate, numMonths) - 1) / monthlyRate);

            taFutureValue.setText("  Future Value\n    $" + String.format("%,.2f", futureValue));

        } catch (NumberFormatException ex) {
            taFutureValue.setText("  Please enter valid numeric values.");
        }
    }

    private void clearFields() {
        txtMonthlyPayment.clear();
        txtInterestRate.clear();
        cboYears.getSelectionModel().selectFirst();
        taFutureValue.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
