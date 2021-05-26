package model;

public class Category {

	private int id;
	private String name;
	private String type;
	private int idUser;

	public Category(){}

	public Category(String name, String type, int idUser) {
		this.name = name;
		this.type = type;
		this.idUser = idUser;
	}

	public Category(int id, String name, String type, int idUser) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.idUser = idUser;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getType() {
		return type;
	}
}