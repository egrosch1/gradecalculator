package edu.westga.cs.schoolgrades.model;

/**
 * AverageOfGrades Class which extends the CompositeGrade abstract class for the purpose of getting the average of a list of grades
 * @author Emily Estrada
 * @version October 2023
 */
public class AverageOfGrades extends CompositeGrade {

	public AverageOfGrades() {
		super();
	}

	public void addGrade(Grade grade) {
		this.getGrades().add(grade);
	}

	@Override
	public double getCalculatedGrade() {
		if (getGrades().isEmpty()) {
			return 0.0; 
		}

		double sum = 0;
		for (Grade grade : getGrades()) {
			sum += grade.getValue();
		}

		return sum / getGrades().size();
	}
}
