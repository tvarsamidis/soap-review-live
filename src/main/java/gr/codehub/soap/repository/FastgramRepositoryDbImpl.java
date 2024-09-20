package gr.codehub.soap.repository;

import gr.codehub.soap.model.ClassWithId;
import gr.codehub.soap.model.FastgramPost;
import gr.codehub.soap.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.NoArgsConstructor;

@Named("FastRepoDb")
@ApplicationScoped
@NoArgsConstructor
public class FastgramRepositoryDbImpl implements FastgramRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static boolean shownRepositoryInfo = false;

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
    public FastgramPost savePost(FastgramPost postFromService) {
        showRepositoryInfo();
        //User user = saveEntity(postFromService.getUser());
        //postFromService.setUser(user);
        FastgramPost postInDb = saveEntity(postFromService);
        return postInDb;
    }

    @Transactional
    public <T extends ClassWithId, Serializable> T saveEntity(T entity) {
        showRepositoryInfo();
        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            T userInDb = entityManager.merge(entity);
            entity = userInDb;
        }
        return entity;
    }

    @Override
    public FastgramPost undeletePostById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void showRepositoryInfo() {
        if (!shownRepositoryInfo) {
            System.out.println("This is the FastgramRepositoryDbImpl");
        }
        shownRepositoryInfo = true;
    }
}
