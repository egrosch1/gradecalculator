
package edu.westga.cs.schoolgrades.model;

/**
 * 
 */
public class AverageOfGrades extends CompositeGrade{

	public AverageOfGrades() {
		super();
	}

	public void addGrade(Grade grade) {
		this.getGrades().add(grade);
	}

	@Override
	public double getCalculatedGrade() {
		if (getGrades().isEmpty()) {
			return 0.0; // Return 0 if there are no grades to calculate the average
		}

		double sum = 0;
		for (Grade grade : getGrades()) {
			sum += grade.getValue();
		}

		return sum / getGrades().size(); // Calculate the average
	}
}
