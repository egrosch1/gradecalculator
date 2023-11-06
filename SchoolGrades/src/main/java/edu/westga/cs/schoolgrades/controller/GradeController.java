package edu.westga.cs.schoolgrades.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Optional;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeListCell;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;

public class GradeController {

    @FXML
    private ListView<Grade> quizInput;
    private ObservableList<Grade> quizGrades;

    @FXML
    private TextField quizSubtotalField;

    @FXML
    private void initialize() {
        this.quizGrades = FXCollections.observableArrayList();
        this.quizInput.setItems(this.quizGrades);
        this.quizInput.setCellFactory(param -> new GradeListCell());
    }

    @FXML
    private void addQuizGrade() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Quiz Grade");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter quiz grade:");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(input -> {
            try {
                double gradeValue = Double.parseDouble(input);
                Grade grade = new SimpleGrade(gradeValue);
                this.quizGrades.add(grade);
                updateSubtotal();
            } catch (NumberFormatException e) {
                
            }
        });
    }

    @FXML
    private void recalculateButtonAction() {
        updateSubtotal();
    }

    @FXML
    private void updateSubtotal() {
        double subtotal = calculateTotal(this.quizGrades);
        this.quizSubtotalField.setText(String.valueOf(subtotal));
    }

    private double calculateTotal(List<Grade> grades) {
        double sum = 0;
        for (Grade grade : grades) {
            sum += grade.getValue();
        }
        return sum;
    }

}
