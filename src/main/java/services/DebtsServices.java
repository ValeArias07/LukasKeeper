package services;

import com.google.gson.Gson;
import db.DBConnection;
import model.Cache;
import model.Debt;
import model.Fee;
import model.User;
import providers.CacheProvider;
import providers.DebtProvider;
import providers.FeeProvider;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

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
			//Aumenta la deuda en la tabla user_cache
			CacheProvider cacheProvider = new CacheProvider();
			cacheProvider.updateDebtCache(debtObj, true);
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

	@POST
	@Consumes("application/json")
	@Path("addFee")
	public Response addFee(@QueryParam("email") String email,Fee fee) {
		try {
			Gson gson = new Gson();
			FeeProvider provider = new FeeProvider();
			fee.setDate(new Date());
			fee.setIdSavingPlan(0);
			provider.addFee(fee);
			return  Response
					.status(200)
					.header("Access-Control-Allow-Origin","*")
					.build();
		} catch (SQLException e) {
			return  Response
					.status(500)
					.header("Access-Control-Allow-Origin","*")
					.build();
		}
	}

	@GET
	@Produces("application/json")
	@Path("balance")
	public Response balance(@QueryParam("email") String email) {
		try {
			DebtProvider debtProvider = new DebtProvider();
			return  Response
					.status(200)
					.entity(debtProvider.debtBalance(email))
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
					.status(200)
					.header("Access-Control-Allow-Origin","*")
					.build();
		}

	}

	@GET
	@Produces("application/json")
	@Path("list")
	public Response getList(@QueryParam("email") String email) {
		try {
			DebtProvider provider = new DebtProvider();
			ArrayList<Debt> debts = provider.getAllDebts(email);
			return Response.ok()
					.entity(debts)
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

	@DELETE
	@Path("delete/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") int id){

		try {
			DebtProvider provider = new DebtProvider();
			Debt debt = provider.getDebt(id);
			provider.deleteById(id);
			//Restar de cache el eliminado
			CacheProvider cacheProvider = new CacheProvider();
			cacheProvider.updateDebtCache(debt, false);
			return Response
					.ok(new String("Operación Exitosa"))
					.header("Content-Type","application/json")
					.build();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
			return Response
					.status(500)
					.entity(new String("Operación Fallida"))
					.header("Content-Type","application/json")
					.build();
		}
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