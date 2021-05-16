package model;

public class Cache {

	private double monthlyBalance;
	private double savingBalance;
	private double expendingBalance;
	private double debtsBalance;

	public Cache() {}

	public Cache(double monthlyBalance, double savingBalance, double expendingBalance, int debtsBalance) {
		this.monthlyBalance = monthlyBalance;
		this.savingBalance = savingBalance;
		this.expendingBalance = expendingBalance;
		this.debtsBalance = debtsBalance;
	}
}