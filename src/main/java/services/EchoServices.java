package services;

import javax.ws.rs.*;

@Path("echo")
public class EchoServices {

    @GET
    @Path("index")
    public String index() { return "echo"; }
}
