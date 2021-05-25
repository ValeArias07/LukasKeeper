package model;


import java.util.Date;

public class ChangeInAsset {

	private int id;
	private double value;
	private String description;
	private Date date;
	private String frequency;
	private int idUserCategory;
	private int idDefaultCategory;
	private int idUser;

	public ChangeInAsset(){}

	public ChangeInAsset(int id, double value, String description, Date date, String frequency, int idUserCategory, int idDefaultCategory, int idUser) {
		this.id = id;
		this.value = value;
		this.description = description;
		this.date = date;
		this.frequency = frequency;
		this.idUserCategory = idUserCategory;
		this.idDefaultCategory = idDefaultCategory;
		this.idUser = idUser;
	}

	public ChangeInAsset(double value, String description, Date date, String frequency, int idUserCategory, int idDefaultCategory, int idUser) {
		this.value = value;
		this.description = description;
		this.date = date;
		this.frequency = frequency;
		this.idUserCategory = idUserCategory;
		this.idDefaultCategory = idDefaultCategory;
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

	public int getIdUserCategory() {
		return idUserCategory;
	}

	public int getIdDefaultCategory()  { return idDefaultCategory; }

	public int getIdUser() {
		return idUser;
	}

	public void setNegativeValue(){
		this.value *= (-1);
	}
}