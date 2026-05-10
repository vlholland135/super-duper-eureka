/**
 * Holland, Victoria
 * CIS 505 - Intermediate Java Programming
 * Bellevue University
 * Assignment 8.2 - HollandEnhancedFutureValueApp
 *
 * This JavaFX application extends the Module 7 FutureValueApp by adding
 * dedicated private methods for clearing the form and computing results,
 * and by delegating the future value calculation to the FinanceCalculator
 * utility class. A date label is populated at calculation time to indicate
 * when the result was produced.
 *
 * Module 8 additions:
 *   clearFormFields() resets all input and output controls to their defaults.
 *   calculateResults() reads user input, calls FinanceCalculator, and displays
 *   the formatted result alongside today's date.
 *   getTodaysDate() returns the current date formatted as MM/dd/yyyy.
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

import java.text.SimpleDateFormat;
import java.util.Date;

public class HollandEnhancedFutureValueApp extends Application {

    // Input fields for monthly payment amount and annual interest rate
    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();

    // Output area for the computed future value result
    private TextArea taFutureValue = new TextArea();

    // Labels for field identifiers, formatting hint, and calculation date
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblYears = new Label("Years:");
    private Label lblFutureValueDate = new Label("");

    // Dropdown for selecting the investment term in years
    private ComboBox<Integer> cboYears = new ComboBox<>();

    // Action buttons wired to clearFormFields and calculateResults
    private Button btnClear = new Button("Clear");
    private Button btnCalculate = new Button("Calculate");

    /**
     * Builds and displays the primary application window. Layout mirrors the
     * Module 7 GridPane structure with the addition of a date label row above
     * the results TextArea.
     *
     * @param primaryStage the top-level window provided by the JavaFX runtime
     */
    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Populate the years dropdown with values 1 through 30
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

        // Date label sits above the results TextArea
        pane.add(lblFutureValueDate, 0, 5, 2, 1);

        pane.add(taFutureValue, 0, 6, 2, 1);
        taFutureValue.setEditable(false);

        // Wire button events to the private handler methods per assignment spec
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());

        Scene scene = new Scene(pane, 350, 320);
        primaryStage.setTitle("Holland Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Resets all form controls to their empty or default state. The monthly
     * payment and interest rate TextFields are cleared, the years ComboBox
     * returns to its first selection, and both the results TextArea and the
     * date label are set to empty strings per the assignment specification.
     */
    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        taFutureValue.setText("");
        lblFutureValueDate.setText("");
        cboYears.setValue(0);
    }

    /**
     * Reads the values entered by the user, delegates the computation to
     * FinanceCalculator.calculateFutureValue(), and displays the result in
     * the TextArea. The date label is updated to reflect when the calculation
     * was performed. Output uses 2 leading spaces for the label line and
     * 4 leading spaces for the indented dollar value, consistent with the
     * CIS 505 output formatting guidelines.
     */
    private void calculateResults() {
        try {
            double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText().trim());
            double interestRate = Double.parseDouble(txtInterestRate.getText().trim());
            int years = cboYears.getValue();

            double futureValue = FinanceCalculator.calculateFutureValue(
                    monthlyPayment, interestRate, years);

            // Update the date label to show when this result was calculated
            lblFutureValueDate.setText("Calculation as of " + getTodaysDate());

            // Display the result with required output indentation
            taFutureValue.setText("  Future Value\n    $" + String.format("%,.2f", futureValue));

        } catch (NumberFormatException ex) {
            taFutureValue.setText("  Please enter valid numeric values.");
            lblFutureValueDate.setText("");
        }
    }

    /**
     * Returns today's date formatted as MM/dd/yyyy using SimpleDateFormat.
     * The returned string is appended to the lblFutureValueDate label after
     * each successful calculation.
     *
     * @return today's date as a formatted String
     */
    private String getTodaysDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(new Date());
    }

    /**
     * Application entry point. Invokes the JavaFX launch mechanism.
     *
     * @param args command-line arguments, not used by this application
     */
    public static void main(String[] args) {
        launch(args);
    }
}
