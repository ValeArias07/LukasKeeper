package services;

import javax.ws.rs.*;

@Path("category")
public class UserServices {

	@POST
	@Path("signin")
	public String addNewUser(String user) {
		return "";
	}

	@PUT
	@Path("edit")
	public String editProfile(String user) {
		return "";
	}

	@GET
	@Path("forgotpassword")
	public String setTemporaryPassword(@QueryParam("email") String email) {
		return "";
	}

	@GET
	@Path("login")
	public String getToken(String user) {
		return "";
	}

}