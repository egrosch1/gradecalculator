package edu.westga.cs.schoolgrades.model;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * TestWeightedGradeDecoratorWorks for the purpose of Testing that the weighted grade decorator works as expected
 * @author Emily Estrada
 * @version October 2023
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
	public void testSetWeightAndGetDecoratedValue() {
		SimpleGrade simpleGrade = new SimpleGrade();
		simpleGrade.setValue(80);
		WeightedGradeDecorator weightedGrade = new WeightedGradeDecorator(simpleGrade, 0.25);
		assertEquals(20.0, weightedGrade.getValue(), 0.001);
		weightedGrade.setWeight(0.75);
		assertEquals(60.0, weightedGrade.getValue(), 0.001); 
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
