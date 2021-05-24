package model;

import java.util.Date;

public class SavingPlan {

	private int id;
	private double goal;
	private double balance;
	private double total;
	private Date date;
	private int monthlyFee;
	private int idUser;

	public SavingPlan(){}

	public SavingPlan(double goal, double balance, double total,Date date, int monthlyFee, int idUser) {
		this.goal = goal;
		this.balance = balance;
		this.total = total;
		this.date = date;
		this.monthlyFee = monthlyFee;
		this.idUser = idUser;
	}

	public SavingPlan(int id, double goal, double balance, double total,Date date, int monthlyFee, int idUser) {
		this.id = id;
		this.goal = goal;
		this.balance = balance;
		this.total = total;
		this.date = date;
		this.monthlyFee = monthlyFee;
		this.idUser = idUser;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public double getGoal() {
		return goal;
	}

	public double getBalance() {
		return balance;
	}

	public double getTotal() {
		return total;
	}

	public Date getDate() {
		return date;
	}

	public int getMonthlyFee() {
		return monthlyFee;
	}

	public int getIdUser() {
		return idUser;
	}
}