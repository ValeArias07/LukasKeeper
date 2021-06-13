package services;

import com.google.gson.Gson;
import model.Category;
import model.ChangeInAsset;
import model.Debt;
import providers.CategoryProvider;
import providers.ChangesInAssetsProvider;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

@Path("incomes")
public class IncomeServices{

	@POST
	@Consumes("application/json")
	@Path("add")
	public Response add(@QueryParam("email") String email,  String income) {
		try {
			Gson gson = new Gson();

			ChangeInAsset incomeObj=gson.fromJson(income, ChangeInAsset.class);
			UserProvider user = new UserProvider();
			int idUser = (user.getUser(email)).getId();
			incomeObj.setUserId(idUser);
			incomeObj.settingsCategory();

			ChangesInAssetsProvider provider = new ChangesInAssetsProvider();
			provider.addChangeInAsset(incomeObj);

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
	@Path("addCategory")
	public Response addCategory(String category) {
		try {
			Gson gson = new Gson();
			Category categoryObj=gson.fromJson(category, Category.class);
			CategoryProvider provider = new CategoryProvider();
			provider.addCategory(categoryObj);
			return  Response
					.status(200)
					.header("Access-Control-Allow-Origin","*")
					.build();
		} catch (SQLException throwables) {
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
					.entity(provider.getAllMonthIncomes(email, date))
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