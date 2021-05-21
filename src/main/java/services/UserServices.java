package services;

import com.google.gson.Gson;
import model.User;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("category")
public class UserServices {

	@POST
	@Consumes("application/json")
	@Path("signup")
	public Response addNewUser(String user) {

		Gson gson = new Gson();
		UserProvider userProvider= new UserProvider();
		User userObj= gson.fromJson(user,User.class);
		userProvider.addUser(userObj);

		return Response
				.status(200)
				.header("Access-Control-Allow-Origin","*")
				.build();
	}


	@POST
	@Consumes("application/json")
	@Path("signin1")
	public void addNewUser1(String user) {
		Gson gson = new Gson();
		UserProvider userProvider= new UserProvider();
		User userObj= gson.fromJson(user,User.class);
		System.out.println(userObj.toString());
	}

	@PUT
	@Path("edit")
	public String editProfile(String user) { return ""; }

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