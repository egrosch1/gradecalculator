package edu.westga.cs.schoolgrades.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
	private ListView<Grade> examInput;
	private ObservableList<Grade> examGrades;
	@FXML
	private TextField quizSubtotalField;

	@FXML
	private TextField homeworkSubtotalField;

	@FXML 
	private TextField examSubtotalField;

	@FXML
	private TextField finalGradeField;


	private GradeCalculationStrategy quizCalculationStrategy;
	private GradeCalculationStrategy homeworkCalculationStrategy;
	private GradeCalculationStrategy examCalculationStrategy;



	@FXML
	private void initialize() {
		this.quizGrades = FXCollections.observableArrayList();
		this.quizInput.setItems(this.quizGrades);
		this.quizInput.setCellFactory(param -> new GradeListCell());

		this.homeworkGrades = FXCollections.observableArrayList();
		this.homeworkInput.setItems(this.homeworkGrades);
		this.homeworkInput.setCellFactory(param -> new GradeListCell());

		this.examGrades = FXCollections.observableArrayList();
		this.examInput.setItems(this.examGrades);
		this.examInput.setCellFactory(param -> new GradeListCell());

		this.homeworkCalculationStrategy = new DropLowestStrategy(new AverageOfGradesStrategy());
		this.quizCalculationStrategy = new SumOfGradesStrategy();
		this.examCalculationStrategy = new AverageOfGradesStrategy();

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
	            int gradeValue = Integer.parseInt(input);
	            if (gradeValue < 0 || gradeValue > 100) {
	                throw new IllegalArgumentException("Grade should be between 0 and 100.");
	            }
	            Grade grade = new SimpleGrade(gradeValue);
	            this.quizGrades.add(grade);
	            this.updateQuizSubtotal();
	        } catch (NumberFormatException e) {
	            this.showErrorDialog("Invalid Input", "Please enter a positive number.");
	        } catch (IllegalArgumentException e) {
	            this.showErrorDialog("Invalid Grade", e.getMessage());
	        }
	    });
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
	            int gradeValue = Integer.parseInt(input);
	            if (gradeValue < 0 || gradeValue > 100) {
	                throw new IllegalArgumentException("Grade should be between 0 and 100.");
	            }
	            Grade grade = new SimpleGrade(gradeValue);
	            this.homeworkGrades.add(grade);
	            this.updateHomeworkSubtotal();
	        } catch (NumberFormatException e) {
	            this.showErrorDialog("Invalid Input", "Please enter a positive number.");
	        } catch (IllegalArgumentException e) {
	            this.showErrorDialog("Invalid Grade", e.getMessage());
	        }
	    });
	}

	@FXML
	private void addExamGrade() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Add Exam Grade");
		dialog.setHeaderText(null);
		dialog.setContentText("Enter exam grade:");
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(input -> {
			try {
				int gradeValue = Integer.parseInt(input);
				if (gradeValue < 0 || gradeValue > 100) {
					throw new IllegalArgumentException("Grade should be between 0 and 100.");
				}
				Grade grade = new SimpleGrade(gradeValue);
				this.examGrades.add(grade);
				this.updateExamSubtotal();
			} catch (NumberFormatException e) {
				this.showErrorDialog("Invalid Input", "Please enter a positive number.");
			} catch (IllegalArgumentException e) {
				this.showErrorDialog("Invalid Grade", e.getMessage());
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

	@FXML
	private void updateExamSubtotal() {
		double subtotal = this.examCalculationStrategy.calculate(this.examGrades);
		this.examSubtotalField.setText(String.valueOf(subtotal));
	}

	@FXML
	private void recalculateButtonAction() {	
		if (this.quizGrades.isEmpty() || this.homeworkGrades.isEmpty() || this.examGrades.isEmpty()) {
			this.showErrorDialog("Error", "All grade categories must have grades entered.");
			return;

		}
		double quizSubtotal = Double.parseDouble(this.quizSubtotalField.getText());
		double homeworkSubtotal = Double.parseDouble(this.homeworkSubtotalField.getText());
		double examSubtotal = Double.parseDouble(this.examSubtotalField.getText());

		double finalGrade = 0.2 * quizSubtotal + 0.3 * homeworkSubtotal + 0.5 * examSubtotal;
		this.finalGradeField.setText(String.valueOf(finalGrade));
	}

	private void showErrorDialog(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

}
