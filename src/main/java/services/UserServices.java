package services;

import com.google.gson.Gson;
import model.Cache;
import model.User;
import providers.CacheProvider;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;

@Path("user")
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
			//Añadir un cache para este usuario
			User userCache = userProvider.getUser(userObj.getEmail());
			CacheProvider cacheProvider = new CacheProvider();
			Cache cache = new Cache(0, 0, 0, 0, userCache.getId(), 0);
			cacheProvider.addCache(cache);
			return Response
					.status(200)
					.header("Access-Control-Allow-Origin","*")
					.build();

		} catch (SQLException | ParseException throwables) {
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

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("login")
	public boolean verifyUser(String user) {
		Gson gson = new Gson();
		boolean check=false;
		try {
			UserProvider userProvider= new UserProvider();
			User usertoVerify= gson.fromJson(user,User.class);
			User userRegisteredInDB=userProvider.getUser(usertoVerify.getEmail());

			String password=userRegisteredInDB.getPassword();

			if(password.equals(usertoVerify.getPassword())){
				return true;
			}else{
				return false;
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return check;
	}


	@GET
	@Produces("application/json")
	@Path("checkEmail")
	public boolean getComprobation(@QueryParam("email") String email) {
		boolean check=false;
		try {
			UserProvider userProvider= new UserProvider();
			User user=userProvider.getUser(email);
			if(user==null){
				return true;
			}else{
				return false;
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return check;
	}

	@GET
	@Produces("application/json")
	@Path("getUserInfo")
	public String getUser(@QueryParam("email") String email) {
		String json="";
		try {
			UserProvider userProvider= new UserProvider();
			User user=userProvider.getUser(email);
			Gson gson = new Gson();
			json=gson.toJson(user);
			System.out.println(json);
			System.out.println(email);
			return json;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return json;
	}

	@GET
	@Produces("application/json")
	@Path("getNameAndPhoto")
	public String getNameAndPhoto(@QueryParam("email") String email){
		String json="";
		try {
			UserProvider userProvider= new UserProvider();
			User user=userProvider.getUser(email);
			Gson gson = new Gson();
			json=gson.toJson(user.getName());
			return json;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return json;
	}
}