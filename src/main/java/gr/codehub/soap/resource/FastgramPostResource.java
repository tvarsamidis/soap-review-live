package gr.codehub.soap.resource;

import gr.codehub.soap.model.FastgramPost;
import gr.codehub.soap.service.FastgramService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.inject.Named;
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

    @Inject
    @Named("FastService")
    private FastgramService fastgramService;

    // http://localhost:8080/fastgramPath/appPath/postPath/getall
    @PermitAll
    @GET
    @Path("/findallposts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FastgramPost> findAllPosts() {
        List<FastgramPost> posts = fastgramService.findAllPosts();
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
