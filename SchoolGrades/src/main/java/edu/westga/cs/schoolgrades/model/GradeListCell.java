package edu.westga.cs.schoolgrades.model;

import javafx.scene.control.ListCell;

public class GradeListCell extends ListCell<Grade> {

    @Override
    protected void updateItem(Grade grade, boolean empty) {
        super.updateItem(grade, empty);
        if (empty || grade == null) {
            setText(null);
        } else {
            setText(String.valueOf(grade.getValue()));
        }
    }
}
