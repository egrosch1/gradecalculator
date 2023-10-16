package edu.westga.cs.schoolgrades.model;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * 
 */
public class TestWeightedGradeDecoratorWorks {

	@Test
	public void testDecorateSimpleGradeWith50PercentWeight() {
		SimpleGrade simpleGrade = new SimpleGrade();
		simpleGrade.setValue(90); 
		WeightedGradeDecorator weightedGrade = new WeightedGradeDecorator(simpleGrade, 0.5); 

		assertEquals(45.0, weightedGrade.getValue(), 0.001); 
	}

	@Test
	public void testDecorateSimpleGradeWith25PercentWeight() {
		SimpleGrade simpleGrade = new SimpleGrade();
		simpleGrade.setValue(80); 
		WeightedGradeDecorator weightedGrade = new WeightedGradeDecorator(simpleGrade, 0.25); 

		assertEquals(20.0, weightedGrade.getValue(), 0.001); 
	}

	@Test
	public void testDecorateSimpleGradeWith100PercentWeight() {
		SimpleGrade simpleGrade = new SimpleGrade();
		simpleGrade.setValue(70); 
		WeightedGradeDecorator weightedGrade = new WeightedGradeDecorator(simpleGrade, 1.0);

		assertEquals(70.0, weightedGrade.getValue(), 0.001); 
	}

	@Test
	public void testDecorateSimpleGradeWithZeroWeight() {
		SimpleGrade simpleGrade = new SimpleGrade();
		simpleGrade.setValue(85); 
		WeightedGradeDecorator weightedGrade = new WeightedGradeDecorator(simpleGrade, 0.0);

		assertEquals(0.0, weightedGrade.getValue(), 0.001); 
	}

}
