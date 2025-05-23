package org.example.modelcontextprotocoleapi.service;

import org.example.modelcontextprotocoleapi.model.User;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MCPServiceImp implements MCPService{

    @Autowired
    UserService userService;

    @Tool(description = "Get all user")
    public String getAllUserTool() {
        List<User> users = userService.getAllUsers();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            System.err.println("Error converting users to JSON: " + e.getMessage());
            return "[]"; // Fallback to an empty JSON array string
        }
    }
}
