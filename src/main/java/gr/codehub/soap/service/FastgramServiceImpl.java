package gr.codehub.soap.service;

import gr.codehub.soap.model.FastgramPost;
import gr.codehub.soap.repository.FastgramRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(endpointInterface = "gr.codehub.soap.service.FastgramService")
public class FastgramServiceImpl implements FastgramService {

    private static final FastgramRepository fastgramRepository;
    
    static {
        fastgramRepository = new FastgramRepository();
    }
    
    @WebMethod
    @Override
    public FastgramPost findPostById(Integer id) {
        return fastgramRepository.findPostById(id);
    }

}
