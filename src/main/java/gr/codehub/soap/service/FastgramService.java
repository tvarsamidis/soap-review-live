package gr.codehub.soap.service;

import gr.codehub.soap.model.FastgramPost;
import java.util.List;

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
