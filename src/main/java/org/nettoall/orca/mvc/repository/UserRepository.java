package org.nettoall.orca.mvc.repository;

import org.nettoall.orca.mvc.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
}
