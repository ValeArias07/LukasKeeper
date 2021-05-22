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

	@PUT
	@Consumes("application/json")
	@Path("edit")
	public Response editProfile(String user) {

		Gson gson = new Gson();
		UserProvider userProvider= new UserProvider();
		User userObj= gson.fromJson(user,User.class);
		userProvider.updateUser(userObj);

		return Response
				.status(200)
				.header("Access-Control-Allow-Origin","*")
				.build();
	}

	@GET
	@Path("forgotpassword/{email}")
	public String setTemporaryPassword(@PathParam("email") String email) {

		return "";
	}

	@GET
	@Path("login")
	public String getToken(String user) {
		return "";
	}

}