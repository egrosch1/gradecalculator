package edu.westga.cs.schoolgrades.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class TestAverageOfGradesStrategyCalculate {

	private static final double DELTA = 0.001;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;
	
	private List<Grade> grades;
	
	private AverageOfGradesStrategy strategy;
	
	@BeforeEach
	public void setup() {
		this.grade0 = new SimpleGrade(10);
		this.grade1 = new SimpleGrade(20);
		this.grade2 = new SimpleGrade(30);
		
		this.grades = new ArrayList<Grade>();
		
		this.strategy = new AverageOfGradesStrategy();
	}
	
	@Test
	public  void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, ()-> { 
			this.strategy.calculate(null);
		});
	}
	
	@Test
	public void shouldGiveZeroIfNoGrades() {
		assertEquals(0, this.strategy.calculate(this.grades), DELTA);
	}
	
	@Test
	public void shouldCalculateAverageOfOneGrades() {
		this.grades.add(this.grade0);
		assertEquals(this.grade0.getValue(), this.strategy.calculate(this.grades), DELTA);
	}

	@Test
	public void shouldCalculateSumOManyGrades() {
		this.grades.add(this.grade0);
		this.grades.add(this.grade1);
		this.grades.add(this.grade2);
		assertEquals(20, this.strategy.calculate(this.grades), DELTA);
	}

}
