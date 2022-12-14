package kg.megacom.springEmployee.services;

import java.util.List;
import java.util.Optional;

public interface BaseService <T> {
    T save (T t);
    T findById(Long id);
    List<T> findAll();
}
