package model;

public class MonthlyPlan {

	private int id;
	private double goal;
	private double budget;
	private boolean hasAlert;
	private double spendingPercentage;

	public MonthlyPlan(){}

	public MonthlyPlan(int id, double goal, double budget, boolean hasAlert, double spendingPercentage) {
		this.id = id;
		this.goal = goal;
		this.budget = budget;
		this.hasAlert = hasAlert;
		this.spendingPercentage = spendingPercentage;
	}
}