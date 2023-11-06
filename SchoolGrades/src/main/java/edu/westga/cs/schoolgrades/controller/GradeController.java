package edu.westga.cs.schoolgrades.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Optional;

import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculationStrategy;
import edu.westga.cs.schoolgrades.model.GradeListCell;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;

public class GradeController {

    @FXML
    private ListView<Grade> quizInput;
    private ObservableList<Grade> quizGrades;

    @FXML
    private ListView<Grade> homeworkInput;
    private ObservableList<Grade> homeworkGrades;
    
    @FXML
    private TextField quizSubtotalField;

    @FXML
    private TextField homeworkSubtotalField;
    
    private GradeCalculationStrategy quizCalculationStrategy;
    private GradeCalculationStrategy homeworkCalculationStrategy;
    


    @FXML
    private void initialize() {
        this.quizGrades = FXCollections.observableArrayList();
        this.quizInput.setItems(this.quizGrades);
        this.quizInput.setCellFactory(param -> new GradeListCell());
        
        this.homeworkGrades = FXCollections.observableArrayList();
        this.homeworkInput.setItems(this.homeworkGrades);
        this.homeworkInput.setCellFactory(param -> new GradeListCell());
        
        this.homeworkCalculationStrategy = new DropLowestStrategy(new AverageOfGradesStrategy());
        this.quizCalculationStrategy = new SumOfGradesStrategy();

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
                this.updateQuizSubtotal();
            } catch (NumberFormatException e) {
            }
        });
    }

    @FXML
    private void recalculateButtonAction() {
    	
    }
    
    @FXML
    private void addHomeworkGrade() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Homework Grade");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter homework grade:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(input -> {
            try {
                double gradeValue = Double.parseDouble(input);
                Grade grade = new SimpleGrade(gradeValue);
                this.homeworkGrades.add(grade);
                this.updateHomeworkSubtotal();
            } catch (NumberFormatException e) {
            }
        });
    }
    @FXML
    private void updateHomeworkSubtotal() {
        double subtotal = this.homeworkCalculationStrategy.calculate(this.homeworkGrades);
        this.homeworkSubtotalField.setText(String.valueOf(subtotal));
    }
    
    @FXML
    private void updateQuizSubtotal() {
        double subtotal = this.quizCalculationStrategy.calculate(this.quizGrades);
        this.quizSubtotalField.setText(String.valueOf(subtotal));
    }

  

}
