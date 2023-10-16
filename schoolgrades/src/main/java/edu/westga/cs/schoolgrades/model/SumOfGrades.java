/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * 
 */
public class SumOfGrades extends CompositeGrade{

	 private List<Grade> grades;

	    public SumOfGrades(List<Grade> grades) {
	        this.grades = grades;
	    }

    @Override
    public double getCalculatedGrade() {
        double sum = 0;
        for (Grade currentGrade : grades) {
            sum += currentGrade.getValue();
        }
        return sum;
    }
}
