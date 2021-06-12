package services;

import model.Fee;
import model.SavingPlan;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("savings")
public class SavingServices{

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
	public Response getList() {return null;  }

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

}