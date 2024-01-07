package org.nettoall.orca.mvc.controller;

import org.nettoall.orca.mvc.model.User;
import org.nettoall.orca.mvc.repository.CustomerRepository;
import org.nettoall.orca.mvc.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class MyRestController {

    private final UserRepository userRepository;

    private final CustomerRepository customerRepository;

    public MyRestController(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        return this.userRepository.findById(userId).get();
    }

//    @GetMapping("/{userId}/customers")
//    public List<Customer> getUsercustomers(@PathVariable Long userId) {
//        return this.userRepository.findById(userId).map(this.customerRepository::findByUser).get();
//    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        this.userRepository.deleteById(userId);
    }
}
