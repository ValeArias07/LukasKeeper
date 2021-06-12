package services;

import model.Fee;
import model.SavingPlan;
import providers.SavingPlanProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;

@Path("savings")
public class SavingServices {

	@POST
	@Consumes("application/json")
	@Path("addPlan")
	public Response addPlan(@QueryParam("email") String email, SavingPlan Saving) {
		return null;
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
	@Path("list")
	public Response getList() {
		return null;
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
