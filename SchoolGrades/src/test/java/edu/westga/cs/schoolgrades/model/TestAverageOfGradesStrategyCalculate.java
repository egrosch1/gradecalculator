package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class TestAverageOfGradesStrategyCalculate {

    private static final double DELTA = 0.001;
    private Grade grade0;
    private Grade grade1;
    private Grade grade2;
    private List<Grade> grades;
    private AverageOfGradesStrategy strategy;

    @BeforeEach
    public void setup() {
        grade0 = mock(Grade.class);
        grade1 = mock(Grade.class);
        grade2 = mock(Grade.class);

        when(grade0.getValue()).thenReturn(10.0);
        when(grade1.getValue()).thenReturn(20.0);
        when(grade2.getValue()).thenReturn(30.0);

        grades = new ArrayList<>();
        strategy = new AverageOfGradesStrategy();
    }

    @Test
    public void shouldNotAllowNullGradesList() {
        assertThrows(IllegalArgumentException.class, () ->{ 
            strategy.calculate(null);
        });
    }

    @Test
    public void shouldGiveZeroIfNoGrades() {
        assertEquals(0, strategy.calculate(grades), DELTA);
    }

    @Test
    public void shouldCalculateAverageOfOneGrade() {
        grades.add(grade0);
        assertEquals(10.0, strategy.calculate(grades), DELTA);
    }

    @Test
    public void shouldCalculateAverageOfManyGrades() {
        grades.add(grade0);
        grades.add(grade1);
        grades.add(grade2);
        assertEquals(20.0, strategy.calculate(grades), DELTA);
    }
}
