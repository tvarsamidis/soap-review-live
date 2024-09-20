package gr.codehub.soap.repository;

import gr.codehub.soap.model.FastgramPost;
import java.util.List;


public interface FastgramRepository {

    FastgramPost deletePostById(int id);

    List<FastgramPost> findAllPosts();

    FastgramPost findPostById(int id);

    FastgramPost findPostByMaxViews();

    List<FastgramPost> findPostsByContent(String content);

    List<FastgramPost> findPostsByUser(String user);

    FastgramPost savePost(FastgramPost post);

    FastgramPost undeletePostById(int id);
    
}
