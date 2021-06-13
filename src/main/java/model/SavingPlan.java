package model;

import javax.json.bind.annotation.JsonbDateFormat;
import java.util.Date;

public class SavingPlan {

	private int id;
	private double goal;
	private String description;
	private double totalFee;

	private String date;
	private int monthlyFee;
	private int idUser;
	public SavingPlan() {

	}

	public SavingPlan( String description) {
		this.description = description;
	}
	public SavingPlan(double goal, String description, String date, int monthlyFee, int idUser) {
		this.goal = goal;
		this.description = description;
		this.totalFee = totalFee;
		this.date = date;
		this.monthlyFee = monthlyFee;
		this.idUser = idUser;
	}

	public SavingPlan(int id, double goal, String description, double total, String date, int monthlyFee, int idUser) {
		this.id = id;
		this.goal = goal;
		this.description = description;
		this.totalFee = total;
		this.date = date;
		this.monthlyFee = monthlyFee;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGoal() {
		return goal;
	}

	public void setGoal(double goal) {
		this.goal = goal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}