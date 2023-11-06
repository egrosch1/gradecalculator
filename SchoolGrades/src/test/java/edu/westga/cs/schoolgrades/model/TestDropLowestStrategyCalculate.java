package edu.westga.cs.schoolgrades.model;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy childStrategy;
	
	private static final double DELTA = 0.001;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;
	
	private List<Grade> grades;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.grade0 = new SimpleGrade(10);
		this.grade1 = new SimpleGrade(20);
		this.grade2 = new SimpleGrade(30);
		
		this.grades = new ArrayList<Grade>();
		
		this.childStrategy = new SumOfGradesStrategy();
		this.dropLowestStrategy = new DropLowestStrategy(this.childStrategy);
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> { 
			this.dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		assertEquals(0, this.dropLowestStrategy.calculate(this.grades), DELTA);
	}
	
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		this.grades.add(this.grade0);
		assertEquals(this.grade0.getValue(), this.dropLowestStrategy.calculate(this.grades), DELTA);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		this.grades.add(this.grade0);
		this.grades.add(this.grade1);
		this.grades.add(this.grade2);
		assertEquals(50, this.dropLowestStrategy.calculate(this.grades), DELTA);
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		this.grades.add(this.grade1);
		this.grades.add(this.grade2);
		this.grades.add(this.grade0);
		assertEquals(50, this.dropLowestStrategy.calculate(this.grades), DELTA);
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		this.grades.add(this.grade1);
		this.grades.add(this.grade0);
		this.grades.add(this.grade2);
		assertEquals(50, this.dropLowestStrategy.calculate(this.grades), DELTA);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		this.grades.add(this.grade1);
		this.grades.add(this.grade0);
		this.grades.add(this.grade2);
		this.grades.add(this.grade0);
		assertEquals(60, this.dropLowestStrategy.calculate(this.grades), DELTA);
	}
}
