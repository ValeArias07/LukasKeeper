package services;

import com.google.gson.Gson;
import model.ChangeInAsset;
import providers.CacheProvider;
import providers.ChangesInAssetsProvider;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

@Path("expenses")
public class ExpensesServices {

	@POST
	@Consumes("application/json")
	@Path("add")
	public Response add(@QueryParam("email") String email, String expense) {
		try {
			Gson gson = new Gson();
			UserProvider user = new UserProvider();

			ChangeInAsset expenseObj=gson.fromJson(expense, ChangeInAsset.class);
			ChangesInAssetsProvider provider = new ChangesInAssetsProvider();
			expenseObj.setNegativeValue();
			expenseObj.settingsCategory();
			int idUser = (user.getUser(email)).getId();
			expenseObj.setUserId(idUser);

			provider.addChangeInAsset(expenseObj);
			//Añadir expense a cache
			CacheProvider cacheProvider = new CacheProvider();
			cacheProvider.updateExpenseCache(expenseObj);
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

	@DELETE
	@Path("delete/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") int id){

		try {
			ChangesInAssetsProvider provider = new ChangesInAssetsProvider();
			ChangeInAsset expense = provider.findById(id);
			provider.deleteById(id);

			CacheProvider cacheProvider = new CacheProvider();
			cacheProvider.updateExpenseCache(expense);
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
	@Path("list")
	public Response getList(@QueryParam("email") String email) {
		try {
			ChangesInAssetsProvider provider = new ChangesInAssetsProvider();
			ArrayList<ChangeInAsset> list = provider.getAllExpenses(email);
			return Response.ok()
					.entity(list)
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
	@Produces("application/json")
	@Path("getMonthlyData")
	public Response getData(@QueryParam("email") String email, @QueryParam("date") String date) {
		try {
			ChangesInAssetsProvider provider = new ChangesInAssetsProvider();
			return  Response
					.status(200)
					.entity(provider.getAllMonthExpenses(email, date))
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