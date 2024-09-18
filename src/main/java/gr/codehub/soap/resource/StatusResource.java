package gr.codehub.soap.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("statusPath")
public class StatusResource {

    @PermitAll  // ping, public documentation
    @GET
    @Path("pingPath")
    @Produces(MediaType.TEXT_PLAIN)
    // @Consumes("Application/json")
    // http://localhost:8080/fastgramPath/appPath/statusPath/pingPath
    public Response ping() {
        return Response
                .ok("ping Fastgram app ok!")
                .build();
    }
}
