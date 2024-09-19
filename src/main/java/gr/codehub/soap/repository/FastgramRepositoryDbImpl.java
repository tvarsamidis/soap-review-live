package gr.codehub.soap.repository;

import gr.codehub.soap.model.FastgramPost;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.NoArgsConstructor;

@Named("FastRepoDb")
@ApplicationScoped
//@NoArgsConstructor
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

    @Transactional
    @Override
    public FastgramPost savePost(FastgramPost post) {
       if (post.getId() == null) {
        entityManager.persist(post);
       } else {
           post = entityManager.merge(post);
       }
       return post;
    }

    @Override
    public FastgramPost undeletePostById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
