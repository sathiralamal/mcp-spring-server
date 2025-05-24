package org.example.modelcontextprotocoleapi.service;

import org.example.modelcontextprotocoleapi.model.User;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestMpcServiceImp implements TestMpcService {

    @Autowired
    private UserService userService;

    @Override
    @Tool(description = "Get all user names")
    public String getUserNames() {
        List<User> users = userService.getAllUsers();
        if (users == null || users.isEmpty()) {
            return "No users found.";
        }
        return users.stream()
                .map(User::getName)
                .collect(Collectors.joining(", "));
    }
}
