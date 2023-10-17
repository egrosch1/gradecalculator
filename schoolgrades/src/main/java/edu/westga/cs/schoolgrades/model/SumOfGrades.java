package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * SumOfGrades class which extends the CompositeGrade for the purpose of getting the sum of a list of grades
 * @author Emily Estrada
 * @version October 2023
 */
public class SumOfGrades extends CompositeGrade {

	public SumOfGrades(List<Grade> grades) {
		super();
		for (Grade grade : grades) {
			this.addGrade(grade);
		}
	}

	@Override
	public double getCalculatedGrade() {
		double sum = 0;
		for (Grade currentGrade : this.getGrades()) {
			sum += currentGrade.getValue();
		}
		return sum;
	}
}

