package gr.codehub.soap.repository;

import java.util.List;
import java.util.Optional;

public interface RepositoryInterface_NOT_USED<T, K> {
      Optional<T> findById(K id) ;
      List<T> findAll() ;
      Optional<T> save(T t) ;
      boolean deleteById(K id);
}