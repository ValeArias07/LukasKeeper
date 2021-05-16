package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("dashboard")
public class DashServices {

	@GET
	@Path("balance")
	public String getBalance() {
		return "";
	}

	@GET
	@Path("incomes")
	public String getIncomeBalance() {
		return "";
	}

	@GET
	@Path("savings")
	public String getSavingBalance() {
		return "";
	}

	@GET
	@Path("expenses")
	public String getExpensesBalance() {
		return "";
	}

}