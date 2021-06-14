package model;

import java.sql.Date;

public class Income {

	private int id;
	private double value;
	private Date date;
	private String description;
	private String frequency;
	private String idCategory;
	private int idUser;

	public Income(){}

	public Income(int id, double value, String description, Date date, String frequency, String idCategory, int idUser) {
		this.id = id;
		this.value = value;
		this.description = description;
		this.date = date;
		this.frequency = frequency;
		this.idCategory = idCategory;
		this.idUser = idUser;
	}
	

}