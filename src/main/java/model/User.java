package model;

import java.sql.Date;

public class User {

	private int id;
	private String name;
	private String lastName;
	private Date dateOfbirth;
	private String email;
	private String password;
	private String bank;
	private String occupation;
	private int idMonthlyPlan;

	public User(){}

	public User(String name, String password){
		this.name = name;
		this.password = password;
	}

	public User(int id, String name, String lastName, Date dateOfbirth, String email, String password, String bank, String occupation, int idMonthlyPlan) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.dateOfbirth = dateOfbirth;
		this.email = email;
		this.password = password;
		this.bank = bank;
		this.occupation = occupation;
		this.idMonthlyPlan = idMonthlyPlan;
	}
}