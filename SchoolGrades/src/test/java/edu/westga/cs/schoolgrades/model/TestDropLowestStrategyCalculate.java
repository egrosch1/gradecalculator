package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDropLowestStrategyCalculate {
    private DropLowestStrategy dropLowestStrategy;
    private GradeCalculationStrategy childStrategyMock;
    private static final double DELTA = 0.001;
    private Grade grade0;
    private Grade grade1;
    private Grade grade2;
    private List<Grade> grades;

    @BeforeEach
    public void setUp() throws Exception {
        grade0 = mock(Grade.class);
        grade1 = mock(Grade.class);
        grade2 = mock(Grade.class);

        grades = new ArrayList<Grade>();

        childStrategyMock = mock(GradeCalculationStrategy.class);
        dropLowestStrategy = new DropLowestStrategy(childStrategyMock);
    }

//    @Test
//    public void shouldNotAllowNullGradesList() {
//        dropLowestStrategy.calculate(null);
//        verifyNoInteractions(childStrategyMock);
//    }

    @Test
    public void shouldNotDropLowestIfGradesListIsEmpty() {
        dropLowestStrategy.calculate(grades);
        verifyNoInteractions(childStrategyMock);
    }

    @Test
    public void shouldNotDropLowestIfGradesListHasOneElement() {
        grades.add(grade0);
        dropLowestStrategy.calculate(grades);
        verify(childStrategyMock).calculate(grades);
    }

    @Test
    public void canDropWhenLowestIsFirst() {
        grades.add(grade0);
        grades.add(grade1);
        grades.add(grade2);
        dropLowestStrategy.calculate(grades);
        verify(childStrategyMock).calculate(Arrays.asList(grade1, grade2));
    }

    @Test
    public void canDropWhenLowestIsLast() {
        grades.add(grade1);
        grades.add(grade2);
        grades.add(grade0);
        dropLowestStrategy.calculate(grades);
        verify(childStrategyMock).calculate(Arrays.asList(grade1, grade2));
    }

    @Test
    public void canDropWhenLowestIsInMiddle() {
        grades.add(grade1);
        grades.add(grade0);
        grades.add(grade2);
        dropLowestStrategy.calculate(grades);
        verify(childStrategyMock).calculate(Arrays.asList(grade1, grade2));
    }

    @Test
    public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
        grades.add(grade1);
        grades.add(grade0);
        grades.add(grade2);
        grades.add(grade0);
        dropLowestStrategy.calculate(grades);
        verify(childStrategyMock).calculate(Arrays.asList(grade1, grade2, grade0));
    }
}
