package services;

import model.Fee;
import model.SavingPlan;
import model.User;
import providers.SavingPlanProvider;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

@Path("savings")
public class SavingServices {

	@POST
	@Consumes("application/json")
	@Path("addPlan")
	public Response addPlan(@QueryParam("email") String email, SavingPlan Saving) {
		try {
			SavingPlanProvider provider = new SavingPlanProvider();
			UserProvider userProvider = new UserProvider();
			User user = userProvider.getUser(email);
			if(user == null) throw new Exception();
			Saving.setIdUser(user.getId());
			provider.addSavingPlan(Saving);
			return  Response
					.ok()
					.header("Access-Control-Allow-Origin","*")
					.build();
		} catch (Exception throwables) {
			throwables.printStackTrace();
			return  Response
					.status(500)
					.header("Access-Control-Allow-Origin","*")
					.build();
		}

	}

	@POST
	@Consumes("application/json")
	@Path("addSaving")
	public Response addSaving(@QueryParam("email") String email, Fee fee) {
		return null;
	}

	@GET
	@Path("comparation")
	public Response getComparation(@QueryParam("type") String type) {
		return null;
	}

	@GET
	@Produces("application/json")
	@Path("list")
	public Response getList(@QueryParam("email") String email) {
		try {
			SavingPlanProvider provider = new SavingPlanProvider();
			return  Response
					.status(200)
					.entity(provider.getAllSavingPlans(email))
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
	@Path("delete")
	public Response deleteItem(@QueryParam("email") String email) {
		return null;
	}

	@GET
	@Path("balance")
	public Response balance() {
		return null;
	}

	@GET
	@Produces("application/json")
	@Path("getPlanNames")
	public Response getPlanList(@QueryParam("email") String email) {
		try {
			SavingPlanProvider provider = new SavingPlanProvider();
			return  Response
					.status(200)
					.entity(provider.getAllSavingPlansNames(email))
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
}
