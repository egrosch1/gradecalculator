package edu.westga.cs.schoolgrades.model;

public class WeightedGradeDecorator implements Grade {

	private Grade grade;
	private double weight;

	public WeightedGradeDecorator(Grade grade, double weight) {
		this.grade = grade;
		this.weight = weight;
	}

	@Override
	public double getValue() {
		return this.grade.getValue() * this.weight;

	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
