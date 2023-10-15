package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestSimpleGradeValue {

	@Test
	public void TestSimpleGradeGetValue() {
		SimpleGrade simpleGrade = new SimpleGrade();
		simpleGrade.setValue(80);
		assertEquals(simpleGrade.getValue(), 80);
	}
	
	public void TestSimpleGradeGetValueIfChanged() {
		SimpleGrade simpleGrade = new SimpleGrade();
		simpleGrade.setValue(80);
		simpleGrade.setValue(90);
		assertEquals(simpleGrade.getValue(), 90);
	}
}
