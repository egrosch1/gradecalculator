package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Test the CompositeGrade information using SumOfGrades and SimpleGrades
 * @author Emily Estrada
 * @version October 2023
 */
public class TestCompositeGrade {

	@Test
	public void testSumOfGradesWithEmptyList() {
		SumOfGrades sumOfGrades = new SumOfGrades(new ArrayList<>());
		assertEquals(0.0, sumOfGrades.getCalculatedGrade(), 0.001);
	}

	@Test
	public void testSumOfGradesWithSingleGrade() {
		List<Grade> grades = new ArrayList<>();
		SimpleGrade grade = new SimpleGrade();
		grade.setValue(90); 
		grades.add(grade);
		SumOfGrades sumOfGrades = new SumOfGrades(grades);
		assertEquals(90.0, sumOfGrades.getCalculatedGrade(), 0.001);
	}

	@Test
	public void testAverageOfGradesWithEmptyList() {
		AverageOfGrades averageOfGrades = new AverageOfGrades();
		assertEquals(0.0, averageOfGrades.getCalculatedGrade(), 0.001);
	}

	@Test
	public void testAverageOfGradesWithSingleGrade() {
		AverageOfGrades averageOfGrades = new AverageOfGrades();
		SimpleGrade grade = new SimpleGrade();
		grade.setValue(80); 
		averageOfGrades.addGrade(grade);
		assertEquals(80.0, averageOfGrades.getCalculatedGrade(), 0.001);
	}

	@Test
	public void testAddGradeAndGetGrades() {
		CompositeGrade compositeGrade = new SumOfGrades(new ArrayList<>());
		SimpleGrade grade = new SimpleGrade();
		grade.setValue(90);
		compositeGrade.addGrade(grade);
		List<Grade> grades = compositeGrade.getGrades();
		assertEquals(1, grades.size());
		assertEquals(90.0, grades.get(0).getValue(), 0.001);
	}
}


