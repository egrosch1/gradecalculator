package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestSimpleGradeValue {

	@Test
	public void testSimpleGradeGetValue() {
		SimpleGrade simpleGrade = new SimpleGrade();
		simpleGrade.setValue(80);
		assertEquals(simpleGrade.getValue(), 80);
	}
	
}
