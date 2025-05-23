package org.example.modelcontextprotocoleapi.service;

import org.example.modelcontextprotocoleapi.model.User;
import org.example.modelcontextprotocoleapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    // This class will contain the business logic for user management
    // For example, methods to create, update, delete, and retrieve users
    // You can also add validation and other business rules here
    @Autowired
    private UserRepository userRepository;

    // Example method to create a user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Example method to get a user by ID
    public User getUserById(Long id) {

        User data = userRepository.findById(id).orElse(null);;
        return data;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
