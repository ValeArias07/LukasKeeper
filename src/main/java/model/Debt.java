package model;

import java.util.Date;

public class Debt {

	private int id;
	private double value;
	private String description;
	private Date date;
	private int fee;
	private double interest;
	private int idUser;

	public Debt(){}

	public Debt(double value, String description, Date date, int fee, double interest, int idUser) {
		this.value = value;
		this.description = description;
		this.date=date;
		this.fee = fee;
		this.interest = interest;
		this.idUser = idUser;
	}

	public Debt(int id, double value, String description, Date date, int fee, double interest, int idUser) {
		this.id = id;
		this.value = value;
		this.description = description;
		this.date=date;
		this.fee = fee;
		this.interest = interest;
		this.idUser = idUser;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public double getValue() {
		return value;
	}

	public Date getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public int getFee() {
		return fee;
	}

	public double getInterest() {
		return interest;
	}

	public int getIdUser() {
		return idUser;
	}
}