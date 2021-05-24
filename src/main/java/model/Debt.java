package model;

import java.sql.Date;

public class Debt {

	private int id;
	private double value;
	private Date date;
	private String description;
	private int fee;
	private double interest;
	private int idUser;

	public Debt(){}

	public Debt(double value, Date date, String description, int fee, double interest, int idUser) {
		this.id = id;
		this.value = value;
		this.date=date;
		this.description = description;
		this.fee = fee;
		this.interest = interest;
		this.idUser = idUser;
	}

	public Debt(int id, double value, Date date, String description, int fee, double interest, int idUser) {
		this.id = id;
		this.value = value;
		this.date=date;
		this.description = description;
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