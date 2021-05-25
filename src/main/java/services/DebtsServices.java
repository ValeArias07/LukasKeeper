package services;

import com.google.gson.Gson;
import model.Debt;
import providers.DebtProvider;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;

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

	@GET
	@Path("list")
	public Response getList() {return null;  }

	@GET
	@Path("delete")
	public Response deleteItem(@QueryParam("id") int id) {
		return null;
	}
}