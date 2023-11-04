package edu.westga.cs.schoolgrades.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class GradeController {
    @FXML
    private ListView<Integer> quizInput;
    @FXML
    private TextField quizSubtotalField;
    @FXML
    private VBox quizResultBox;
    
    @FXML
    private ListView<Integer> homeworkInput;
    @FXML
    private TextField homeworkSubtotalField;
    @FXML
    private VBox homeworkResultBox;
    
    @FXML
    private ListView<Integer> examInput;
    @FXML
    private TextField examSubtotalField;
    @FXML
    private VBox examResultBox;
    
    @FXML
    private TextField finalGradeField;
    @FXML
    private Button recalculateButton;

    @FXML
    private void initialize() {
    }

    @FXML
    private void recalculateButtonAction() {
    }
}
