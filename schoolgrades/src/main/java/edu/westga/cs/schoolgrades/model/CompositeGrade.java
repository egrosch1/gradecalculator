/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public abstract class CompositeGrade implements Grade, CalculationStrategy {
	
	private List<Grade> grades = new ArrayList<Grade>();
	
	/**
	 * @return the grades
	 */
	protected List<Grade> getGrades() {
		return grades;
	}

	private double value;
	
	public void addGrade(Grade grade) {
		this.grades.add(grade);
	}
	
	/**
	 * Getter for value
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
}
