package model;


import java.util.Date;

public class ChangeInAsset {

	public static final int NULL_NUMBER = 2;

	private int id;
	private double value;
	private String description;
	private Date date;
	private String frequency;
	private int idCategory;
	private int idUserCategory;
	private int idDefaultCategory;
	private int idUser;
	private String sDate;

	public ChangeInAsset(){}

	public ChangeInAsset(double value, String date ) {
		this.value = value;
		this.sDate = date;
	}

	public ChangeInAsset(int id, double value, String description, Date date, String frequency, int idDefaultCategory, int idUserCategory, int idUser) {
		this.id = id;
		this.value = value;
		this.description = description;
		this.date = date;
		this.frequency = frequency;
		this.idUserCategory = idUserCategory;
		this.idDefaultCategory = idDefaultCategory;
	}

	public ChangeInAsset(double value, String description, Date date, String frequency,int idCategory, int idUser) {
		this.value = value;
		this.description = description;
		this.date = date;
		this.frequency = frequency;
		this.idCategory = idCategory;
		this.idUser = idUser;
	}

	public void settingsCategory(){

		if(idCategory>90000000){
			this.idDefaultCategory=idCategory;
			this.idUserCategory=2 ;
		}else{
			this.idUserCategory=idCategory;
			this.idDefaultCategory = 2;
		}
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

	public void setUserId(int idUser){
		this.idUser=idUser;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	@Override
	public String toString() {
		return "ChangeInAsset{" +
				"id=" + id +
				", value=" + value +
				", description='" + description + '\'' +
				", date=" + date +
				", frequency='" + frequency + '\'' +
				", idUserCategory=" + idUserCategory +
				", idDefaultCategory=" + idDefaultCategory +
				", idUser=" + idUser +
				'}';
	}
}