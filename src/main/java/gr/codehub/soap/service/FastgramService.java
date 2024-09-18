package gr.codehub.soap.service;

import gr.codehub.soap.model.FastgramPost;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface FastgramService {
    
    List<FastgramPost> findAll();
    
    FastgramPost findPostById(int id);

    FastgramPost findPostByMaxViews();

    List<FastgramPost> findPostsByUser(String user);

    List<FastgramPost> findPostsByContent(String user);

    FastgramPost savePost(FastgramPost post);

    FastgramPost deletePostById(int id);
    
    FastgramPost undeletePostById(int id);
}
