package org.nettoall.orca.mvc.repository;

import org.nettoall.orca.mvc.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    Customer findById(long id);

    // Customer findByUser(User user);
}
