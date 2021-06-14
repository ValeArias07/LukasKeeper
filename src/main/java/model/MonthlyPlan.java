package model;

public class MonthlyPlan {

	private int id;
	private double total;
	private double budget;
	private boolean hasAlert;
	private double spendingPercentage;
	private int idUser;

	public MonthlyPlan(){}

	public MonthlyPlan(double budget, boolean hasAlert, double spendingPercentage, int idUser) {
		this.budget = budget;
		this.hasAlert = hasAlert;
		this.spendingPercentage = spendingPercentage;
		this.idUser = idUser;
	}

	public MonthlyPlan(int id, double budget, boolean hasAlert, double spendingPercentage, int idUser) {
		this.id = id;
		this.budget = budget;
		this.hasAlert = hasAlert;
		this.spendingPercentage = spendingPercentage;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public boolean isHasAlert() {
		return hasAlert;
	}

	public void setHasAlert(boolean hasAlert) {
		this.hasAlert = hasAlert;
	}

	public double getSpendingPercentage() {
		return spendingPercentage;
	}

	public void setSpendingPercentage(double spendingPercentage) {
		this.spendingPercentage = spendingPercentage;
	}

	public int getIdUser() {
		return idUser;
	}
}