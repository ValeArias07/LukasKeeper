package services;

import com.google.gson.Gson;
import model.User;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;

@Path("category")
public class UserServices {

	@POST
	@Consumes("application/json")
	@Path("signup")
	public Response addNewUser(String user) {
		try {
		Gson gson = new Gson();
		UserProvider userProvider= new UserProvider();
		User userObj= gson.fromJson(user,User.class);
		userProvider.addUser(userObj);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin","*")
				.build();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return Response
				.status(200)
				.header("Access-Control-Allow-Origin","*")
				.build();
	}

	@PUT
	@Consumes("application/json")
	@Path("edit")
	public Response editProfile(String user) {

		try {
			Gson gson = new Gson();
			UserProvider userProvider= new UserProvider();
			User userObj= gson.fromJson(user,User.class);
			userProvider.updateUser(userObj);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

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


	@GET
	@Produces("application/json")
	@Path("checkEmail")
	public String getUser(@QueryParam("email") String email) {
		String json="";
		try {
			UserProvider userProvider= new UserProvider();
			User user=userProvider.getUser(email);
			Gson gson = new Gson();
			json=gson.toJson(user);
			return json;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return json;
	}

}