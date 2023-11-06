package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWeightedGradeGetValue {

	private static final double DELTA = 0.001;
	private WeightedGrade weightedGrade;
	private SimpleGrade simpleGrade;
	
	@BeforeEach
	public void setup() {
		this.simpleGrade = new SimpleGrade(100);
	}
	
	@Test
	public void shouldApplyZeroWeight() {
		this.weightedGrade = new WeightedGrade(this.simpleGrade, 0);
		assertEquals(0, this.weightedGrade.getValue(), DELTA);
	}
	
	@Test
	public void shouldApplyWeightOfOne() {
		this.weightedGrade = new WeightedGrade(this.simpleGrade, 1);
		assertEquals(100, this.weightedGrade.getValue(), DELTA);
	}
	
	@Test
	public void shouldApplyWeightBetweenZeroAndOne() {
		this.weightedGrade = new WeightedGrade(this.simpleGrade, 0.5);
		assertEquals(50, this.weightedGrade.getValue(), DELTA);
	}

}
