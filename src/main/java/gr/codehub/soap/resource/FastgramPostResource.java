package gr.codehub.soap.resource;

import gr.codehub.soap.model.FastgramPost;
import gr.codehub.soap.service.FastgramService;
import gr.codehub.soap.service.FastgramServiceImpl;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("postPath")
public class FastgramPostResource {

    private FastgramService fastgramService = new FastgramServiceImpl();

    // http://localhost:8080/fastgramPath/appPath/postPath/getall
    @PermitAll
    @GET
    @Path("findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FastgramPost> findAll() {
        List<FastgramPost> posts = fastgramService.findAll();
        return posts;
    }

    // http://localhost:8080/fastgramPath/appPath/postPath/create
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFastgramPost(FastgramPost post) {
        System.out.println("Received FastgramPostOld: " + post);
        fastgramService.savePost(post);
        return Response.ok(post).build();
    }

}
