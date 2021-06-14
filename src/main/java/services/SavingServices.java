package services;

import model.Fee;
import model.SavingPlan;
import model.User;
import providers.FeeProvider;
import providers.SavingPlanProvider;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

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
	public Response addSaving(Fee fee) {
		try {
			FeeProvider provider = new FeeProvider();
			fee.setDate(new Date());
			provider.addFee(fee);
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

	@DELETE
	@Path("deletePlan")
	public Response deletePlan(@QueryParam("id") int id) {
		try {
			SavingPlanProvider provider = new SavingPlanProvider();
			provider.deleteById(id);
			return  Response
					.ok()
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

	@DELETE
	@Path("deleteSaving")
	public Response deleteSaving(@QueryParam("id") int id) {
		try {
			FeeProvider provider = new FeeProvider();
			provider.deleteById(id);
			return  Response
					.ok()
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

	@GET
	@Produces("application/json")
	@Path("getAllFeeSavingPlan")
	public Response getAllFeeGivingAnPlan(@QueryParam("savingPlan") int savingPlan) {
		try {
			FeeProvider provider = new FeeProvider();
			return  Response
					.status(200)
					.entity(provider.getAllFee(savingPlan, -1))
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
	@Produces("application/json")
	@Path("getAllFeeSavings")
	public Response getAllFeeSavings() {
		try {
			FeeProvider provider = new FeeProvider();
			return  Response
					.status(200)
					.entity(provider.getAllSavingsFee())
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
