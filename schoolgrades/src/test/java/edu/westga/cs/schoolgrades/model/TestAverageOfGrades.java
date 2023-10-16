package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TestAverageOfGrades {

    private AverageOfGrades averageGrades;

    @Before
    public void setUp() {
        averageGrades = new AverageOfGrades();
    }

    @Test
    public void testEmptyGradesList() {
        assertEquals(0.0, averageGrades.getCalculatedGrade(), 0.001);
    }

    @Test
    public void testSingleGrade() {
        Grade grade = new Grade() {
            @Override
            public double getValue() {
                return 90.0;
            }
        };
        averageGrades.addGrade(grade);
        assertEquals(90.0, averageGrades.getCalculatedGrade(), 0.001);
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

        for (Grade grade : grades) {
            averageGrades.addGrade(grade);
        }
        
        assertEquals(86.67, averageGrades.getCalculatedGrade(), 0.01);
    }
}
