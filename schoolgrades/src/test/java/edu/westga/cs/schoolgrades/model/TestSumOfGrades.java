package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestSumOfGrades {

    @Test
    public void testEmptyGradesList() {
        List<Grade> grades = new ArrayList<>();
        SumOfGrades sumOfGrades = new SumOfGrades(grades);
        assertEquals(0.0, sumOfGrades.getCalculatedGrade(), 0.001);
    }

    @Test
    public void testSingleGrade() {
        List<Grade> grades = new ArrayList<>();
        grades.add(new Grade() {
            @Override
            public double getValue() {
                return 90.0;
            }
        });
        SumOfGrades sumOfGrades = new SumOfGrades(grades);
        assertEquals(90.0, sumOfGrades.getCalculatedGrade(), 0.001);
    }

    @Test
    public void testMultipleGrades() {
        List<Grade> grades = new ArrayList<>();
        grades.add(new Grade() {
            @Override
            public double getValue() {
                return 80.0;
            }
        });
        grades.add(new Grade() {
            @Override
            public double getValue() {
                return 85.0;
            }
        });
        grades.add(new Grade() {
            @Override
            public double getValue() {
                return 95.0;
            }
        });
        SumOfGrades sumOfGrades = new SumOfGrades(grades);
        assertEquals(260.0, sumOfGrades.getCalculatedGrade(), 0.001);
    }
}
