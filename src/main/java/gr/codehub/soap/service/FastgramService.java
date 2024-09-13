package gr.codehub.soap.service;

import gr.codehub.soap.model.FastgramPost;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface FastgramService {

    @WebMethod
    FastgramPost findPostById(Integer id);
}
