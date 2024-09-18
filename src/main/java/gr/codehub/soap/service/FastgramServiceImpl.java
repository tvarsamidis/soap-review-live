package gr.codehub.soap.service;

import gr.codehub.soap.model.FastgramPost;
import gr.codehub.soap.repository.FastgramRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService(endpointInterface = "gr.codehub.soap.service.FastgramService")
public class FastgramServiceImpl implements FastgramService {

    private static final FastgramRepository fastgramRepository;

    static {
        fastgramRepository = new FastgramRepository();
    }

    @WebMethod
    @Override
    public FastgramPost findPostById(int id) {
        return fastgramRepository.findPostById(id);
    }

    @WebMethod
    @Override
    public FastgramPost findPostByMaxViews() {
        return fastgramRepository.findPostByMaxViews();
    }

    @WebMethod
    @Override
    public List<FastgramPost> findPostsByUser(String user) {
        return fastgramRepository.findPostsByUser(user);
    }

    @WebMethod
    @Override
    public List<FastgramPost> findPostsByContent(String content) {
        return fastgramRepository.findPostsByContent(content);
    }

    @WebMethod
    @Override
    public FastgramPost savePost(FastgramPost currency) {
        return fastgramRepository.savePost(currency);
    }

    @WebMethod
    @Override
    public FastgramPost deletePostById(int id) {
        return fastgramRepository.deletePostById(id);
    }

    @WebMethod
    @Override
    public FastgramPost undeletePostById(int id) {
        return fastgramRepository.undeletePostById(id);
    }
}
