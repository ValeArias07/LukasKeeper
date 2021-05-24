package model;


import java.util.Date;

public class ChangeInAsset {

	private int id;
	private double value;
	private String description;
	private Date date;
	private String frequency;
	private int idCategory;
	private int idUser;


	public ChangeInAsset(){}

	public ChangeInAsset(int id, double value, String description, Date date, String frequency, int idCategory, int idUser) {
		this.id = id;
		this.value = value;
		this.description = description;
		this.date = date;
		this.frequency = frequency;
		this.idCategory = idCategory;
		this.idUser = idUser;
	}

	public ChangeInAsset(double value, String description, Date date, String frequency, int idCategory, int idUser) {
		this.value = value;
		this.description = description;
		this.date = date;
		this.frequency = frequency;
		this.idCategory = idCategory;
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

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return date;
	}

	public String getFrequency() {
		return frequency;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public int getIdUser() {
		return idUser;
	}
}