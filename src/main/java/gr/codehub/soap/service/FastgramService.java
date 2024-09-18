package gr.codehub.soap.service;

import gr.codehub.soap.model.FastgramPost;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface FastgramService {
    @WebMethod
    FastgramPost findPostById(int id);

    @WebMethod
    FastgramPost findPostByMaxViews();

    @WebMethod
    List<FastgramPost> findPostsByUser(String user);

    @WebMethod
    List<FastgramPost> findPostsByContent(String user);

    @WebMethod
    FastgramPost savePost(FastgramPost post);

    @WebMethod
    FastgramPost deletePostById(int id);
    
    @WebMethod
    FastgramPost undeletePostById(int id);
}
