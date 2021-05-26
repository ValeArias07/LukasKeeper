package model;

public class Cache {

	private int id;
	private double monthlyBalance;
	private double savingBalance;
	private double expendingBalance;
	private double debtsBalance;
	private int idUser;

	public Cache() {}

	public Cache(int id, double monthlyBalance, double savingBalance, double expendingBalance, double debtsBalance, int idUser) {
		this.id = id;
		this.monthlyBalance = monthlyBalance;
		this.savingBalance = savingBalance;
		this.expendingBalance = expendingBalance;
		this.debtsBalance = debtsBalance;
		this.idUser = idUser;
	}

	public Cache(double monthlyBalance, double savingBalance, double expendingBalance, double debtsBalance, int idUser) {
		this.monthlyBalance = monthlyBalance;
		this.savingBalance = savingBalance;
		this.expendingBalance = expendingBalance;
		this.debtsBalance = debtsBalance;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public double getMonthlyBalance() {
		return monthlyBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public double getExpendingBalance() {
		return expendingBalance;
	}

	public double getDebtsBalance() {
		return debtsBalance;
	}
}