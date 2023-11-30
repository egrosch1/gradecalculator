package edu.westga.cs.schoolgrades.model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy mockStrategy;

	private Grade grade2;
	private Grade grade1;
	private Grade grade0;

	@BeforeEach
	public void setUp() {
		this.mockStrategy = mock(GradeCalculationStrategy.class);

		this.grade2 = mock(Grade.class);
		this.grade0 = mock(Grade.class);
		this.grade1 = mock(Grade.class);

		when(this.grade2.getValue()).thenReturn(30.0);
		when(this.grade0.getValue()).thenReturn(20.0);
		when(this.grade1.getValue()).thenReturn(10.0);

		this.dropLowestStrategy = new DropLowestStrategy(this.mockStrategy);
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> {
			dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		List<Grade> emptyList = Arrays.asList();
		this.dropLowestStrategy.calculate(emptyList);
		verify(this.mockStrategy).calculate(emptyList);
	}

	@Test
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		List<Grade> singleGradeList = Arrays.asList(this.grade0);
		this.dropLowestStrategy.calculate(singleGradeList);
		verify(this.mockStrategy).calculate(singleGradeList);
	}

	@Test
	public void dropsFirstGradeIfLowest() {
		List<Grade> grades = Arrays.asList(this.grade1, this.grade0, this.grade2);
		this.dropLowestStrategy.calculate(grades);

		List<Grade> expectedGrades = Arrays.asList(this.grade0, this.grade2);
		verify(this.mockStrategy).calculate(expectedGrades);
	}

	@Test
	public void dropsLastGradeIfLowest() {
		List<Grade> grades = Arrays.asList(this.grade0, this.grade2, this.grade1);
		this.dropLowestStrategy.calculate(grades);

		List<Grade> expectedGrades = Arrays.asList(this.grade0, this.grade2);
		verify(this.mockStrategy).calculate(expectedGrades);
	}

	@Test
	public void dropsMiddleGradeIfLowest() {
		List<Grade> gradesList = Arrays.asList(this.grade0, this.grade1, this.grade2);
		this.dropLowestStrategy.calculate(gradesList);

		List<Grade> expectedList = Arrays.asList(this.grade0, this.grade2);
		verify(this.mockStrategy).calculate(expectedList);
	}

	@Test
	public void dropsOneLowestGradeWhenMultiplePresent() {
		List<Grade> gradesList = Arrays.asList(this.grade0, this.grade1, this.grade2, this.grade1);
		this.dropLowestStrategy.calculate(gradesList);

		List<Grade> expectedList = Arrays.asList(this.grade0, this.grade2, this.grade1);
		verify(this.mockStrategy).calculate(expectedList);
	}
}
