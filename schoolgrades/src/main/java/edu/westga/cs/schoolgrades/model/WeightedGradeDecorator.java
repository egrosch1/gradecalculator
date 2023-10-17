package edu.westga.cs.schoolgrades.model;

/**
 * Decorator WeightedGradeDecorator for the purpose of given weight to different grades
 * @author Emily Estrada
 * @version October 16, 2023
 */
public class WeightedGradeDecorator implements Grade {

	private Grade grade;
	private double weight;

	/**
	 * Constructor for the WeightedGradeDecorator
	 * @param grade the grade 
	 * @param weight how much the grade is worth
	 */
	public WeightedGradeDecorator(Grade grade, double weight) {
		this.grade = grade;
		this.weight = weight;
	}

	/**
	 *Overridden getValue method to ensure that the value includes the weight of the grade
	 */
	@Override
	public double getValue() {
		return this.grade.getValue() * this.weight;

	}

	/**
	 * Setter for the Weight
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
