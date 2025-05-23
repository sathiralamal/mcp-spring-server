package org.example.modelcontextprotocoleapi.service;

import org.example.modelcontextprotocoleapi.model.User;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MCPServiceImp implements MCPService{

    @Autowired
    UserService userService;

    @Tool(description = "Get all user")
    public String getAllUserTool() {
        List<User> users = userService.getAllUsers();
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append("Name: ").append(user.getName())
                    .append(", Experience: ").append(user.getExperience())
                    .append("\n");
        }
        return sb.toString();
    }
}
