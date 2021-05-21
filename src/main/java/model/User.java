package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	private String name;
	private String lastName;
	private Date dateOfBirth;
	private String email;
	private String password;
	private String bank;
	private String occupation;

	public User(){}

	public User(String email, String password){
		this.email = email;
		this.password = password;
	}

	public User(String name, String lastName, String dateOfBirth, String email, String password, String bank, String occupation) throws ParseException {
		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = format.parse(dateOfBirth);
		this.email = email;
		this.password = password;
		this.bank = bank;
		this.occupation = occupation;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getBank() {
		return bank;
	}

	public String getOccupation() {
		return occupation;
	}
}