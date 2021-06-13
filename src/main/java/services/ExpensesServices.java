package services;

import com.google.gson.Gson;
import model.ChangeInAsset;
import providers.ChangesInAssetsProvider;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;

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

	@GET
	@Path("list")
	public Response getList() {return null;  }

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