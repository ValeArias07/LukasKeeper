package model;

import java.sql.Date;

public class Expense {

	private int id;
	private double value;
	private String description;
	private Date date;
	private String frequency;
	private String idCategory;
	private int idUser;


	public Expense(){}

	public Expense(int id, double value, String description, Date date, String frequency, String idCategory, int idUser) {
		this.id = id;
		this.value = value;
		this.description = description;
		this.date = date;
		this.frequency = frequency;
		this.idCategory = idCategory;
		this.idUser = idUser;
	}
}