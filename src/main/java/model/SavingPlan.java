package model;

import java.sql.Date;

public class SavingPlan {

	private int id;
	private double goal;
	private double balance;
	private double total;
	private Date date;
	private int fee;
	private double interest;
	private int idUser;

	public SavingPlan(){}

	public SavingPlan(int id, double goal, double balance, double total,Date date, int fee, double interest, int idUser) {
		this.id = id;
		this.goal = goal;
		this.balance = balance;
		this.total = total;
		this.date = date;
		this.fee = fee;
		this.interest = interest;
		this.idUser = idUser;
	}
}