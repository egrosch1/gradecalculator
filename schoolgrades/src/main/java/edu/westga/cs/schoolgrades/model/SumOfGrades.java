/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

/**
 * 
 */
public class SumOfGrades extends CompositeGrade{

	@Override
	public double getCalculatedGrade() {
		double sum = 0;
		for (Grade currentGrade : getGrades()) {
			sum += currentGrade.getValue();
		}
			
		return sum;
	}

	
}
