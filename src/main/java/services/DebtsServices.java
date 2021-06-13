package services;

import com.google.gson.Gson;
import db.DBConnection;
import model.Debt;
import model.User;
import providers.DebtProvider;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

@Path("debts")
public class DebtsServices {

	@POST
	@Consumes("application/json")
	@Path("add")
	public Response add(@QueryParam("email") String email, String debt) {
		try {
			Gson gson = new Gson();
			UserProvider user = new UserProvider();
			Debt debtObj=gson.fromJson(debt, Debt.class);
			DebtProvider provider = new DebtProvider();
			System.out.println(debt);
			System.out.println(email);
			int idUser = (user.getUser(email)).getId();
			debtObj.setIdUser(idUser);
			provider.addDebt(debtObj);
			return  Response
					.status(200)
					.header("Access-Control-Allow-Origin","*")
					.build();
		} catch (SQLException | ParseException throwables) {
			throwables.printStackTrace();
			return  Response
					.status(500)
					.header("Access-Control-Allow-Origin","*")
					.build();
		}

	}

	@GET
	@Path("balance")
	public Response balance() {
		return null;
	}

	@GET
	@Path("timeline")
	public Response getTimeline() {
		return null;
	}

	@GET
	@Path("comparation")
	public Response getComparation(@QueryParam("type") String type) {
		return null;
	}

	@GET
	@Path("indicator")
	public Response getIndicators() {
		return null;
	}

	@POST
	@Consumes("application/json")
	@Path("list")
	public Response getList(User user) {
		try {
			DebtProvider provider = new DebtProvider();
			ArrayList<Debt> debts = provider.getAllDebts(user.getEmail());
			return Response.ok(debts)
					.header("Content-Type","application/json")
					.build();
		} catch (SQLException | ParseException exception) {
			exception.printStackTrace();
			return Response
					.status(500)
					.entity(new String("Operación Fallida"))
					.header("Content-Type","application/json")
					.build();
		}
	}

	@GET
	@Path("delete")
	public Response deleteItem(@QueryParam("id") int id) {
		return null;
	}
	@GET
	@Produces("application/json")
	@Path("getMonthlyData")
	public Response getData(@QueryParam("email") String email, @QueryParam("date") String date) {
		try {
			DebtProvider provider = new DebtProvider();
			return  Response
					.status(200)
					.entity(provider.getAllMonthDebts(email, date))
					.header("Access-Control-Allow-Origin","*")
					.build();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return  Response
					.status(500)
					.header("Access-Control-Allow-Origin","*")
					.build();
		} catch (ParseException e) {
			e.printStackTrace();
			return  Response
					.status(500)
					.header("Access-Control-Allow-Origin","*")
					.build();
		}
	}

}