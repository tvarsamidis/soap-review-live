package gr.codehub.soap.service;

import gr.codehub.soap.model.FastgramPost;
import gr.codehub.soap.repository.FastgramRepository;
import gr.codehub.soap.repository.FastgramRepositoryDbImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named("FastService")
@RequestScoped
//@SessionScoped
//@RequestScoped
public class FastgramServiceImpl implements FastgramService {

    @Inject
    @Named("FastRepoDb")
    private FastgramRepository fastgramRepository;

    @Override
    public List<FastgramPost> findAll() {
        return fastgramRepository.findAll();
    }

    @Override
    public FastgramPost findPostById(int id) {
        return fastgramRepository.findPostById(id);
    }

    @Override
    public FastgramPost findPostByMaxViews() {
        return fastgramRepository.findPostByMaxViews();
    }

    @Override
    public List<FastgramPost> findPostsByUser(String user) {
        return fastgramRepository.findPostsByUser(user);
    }

    @Override
    public List<FastgramPost> findPostsByContent(String content) {
        return fastgramRepository.findPostsByContent(content);
    }

    @Override
    public FastgramPost savePost(FastgramPost post) {
        return fastgramRepository.savePost(post);
    }

    @Override
    public FastgramPost deletePostById(int id) {
        return fastgramRepository.deletePostById(id);
    }

    @Override
    public FastgramPost undeletePostById(int id) {
        return fastgramRepository.undeletePostById(id);
    }
}
