package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Class CompositeGrade for the purpose of getting a list of grades and implementing a strategy
 * @author Emily Estrada
 * @version October 2023
 */
public abstract class CompositeGrade implements Grade, CalculationStrategy {
	
	private List<Grade> grades = new ArrayList<Grade>();
	
	/**
	 * @return the grades
	 */
	protected List<Grade> getGrades() {
		return this.grades;
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
		return this.value;
	}
}
