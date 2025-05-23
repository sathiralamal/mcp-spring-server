package org.example.modelcontextprotocoleapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.modelcontextprotocoleapi.model.ErrorResponse;
import org.example.modelcontextprotocoleapi.model.User;
import org.example.modelcontextprotocoleapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController()
@RequestMapping("/user")
public class ExmapleController {
    @Autowired
    UserService userService;

   @GetMapping("/all")
       public ResponseEntity<List<User>> getAllUsers() {
       List<User> users =null;
           try {
               users = userService.getAllUsers();
               if (users.isEmpty()) {
                   org.slf4j.LoggerFactory.getLogger(ExmapleController.class)
                           .info("No users found in the database.");
               } else {
                   org.slf4j.LoggerFactory.getLogger(ExmapleController.class)
                           .info("Fetched {} users from the database.", users.size());
                   return ResponseEntity.ok(users);

               }
           } catch (Exception ex) {
               log.error(ex.getLocalizedMessage());
           }
       return  ResponseEntity.status(500).body(null);
       }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            log.info("User created successfully with ID: {}", createdUser.getId());
            return ResponseEntity.ok(createdUser);
        } catch (Exception ex) {
            log.error("Error creating user: {}", ex.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }
}
