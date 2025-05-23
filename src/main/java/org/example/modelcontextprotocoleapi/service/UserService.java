package org.example.modelcontextprotocoleapi.service;

import org.example.modelcontextprotocoleapi.model.User;

import java.util.List;

public interface UserService {

     User createUser(User user);

     User getUserById(Long id);

     List<User> getAllUsers();
}
