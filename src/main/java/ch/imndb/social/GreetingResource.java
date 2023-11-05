package ch.imndb.social;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/call-fb")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        try {
            StartFB.runFB();
            return "run success";
        } catch (InterruptedException e) {
            return "error " + e;
        }
    }
}
