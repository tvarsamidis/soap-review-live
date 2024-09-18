package gr.codehub.soap.repository;

import gr.codehub.soap.model.FastgramPost;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import lombok.NoArgsConstructor;

@Named("FastRepoDb")
@RequestScoped
@NoArgsConstructor
public class FastgramRepositoryDbImpl implements FastgramRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    
    @Override
    public FastgramPost deletePostById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<FastgramPost> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FastgramPost findPostById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FastgramPost findPostByMaxViews() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<FastgramPost> findPostsByContent(String content) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<FastgramPost> findPostsByUser(String user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FastgramPost savePost(FastgramPost post) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FastgramPost undeletePostById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
