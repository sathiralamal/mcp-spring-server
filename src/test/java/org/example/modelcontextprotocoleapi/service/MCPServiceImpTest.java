package org.example.modelcontextprotocoleapi.service;

import org.example.modelcontextprotocoleapi.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MCPServiceImpTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private MCPServiceImp mcpServiceImp;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetGetAllUserTool_ShouldReturnJsonArrayOfUsers() {
        // 1. Create a list of User objects
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("Test User 1");
        user1.setExperience("Testing");
        // Note: id, email, password, phone, jobDescription will be null by default
        users.add(user1);

        User user2 = new User();
        user2.setName("Test User 2");
        user2.setExperience("Java Development");
        // Note: id, email, password, phone, jobDescription will be null by default
        users.add(user2);

        // 2. Stub the getAllUsers() method of the mocked UserService
        when(userService.getAllUsers()).thenReturn(users);

        // 3. Call getAllUserTool()
        String result = mcpServiceImp.getAllUserTool();

        // 4. Assert that the returned string is correctly formatted JSON
        // Fields ordered alphabetically: email, experience, id, jobDescription, name, password, phone
        String expectedJson = "[{" +
                "\"email\":null," +
                "\"experience\":\"Testing\"," +
                "\"id\":null," +
                "\"jobDescription\":null," +
                "\"name\":\"Test User 1\"," +
                "\"password\":null," +
                "\"phone\":null" +
                "},{" +
                "\"email\":null," +
                "\"experience\":\"Java Development\"," +
                "\"id\":null," +
                "\"jobDescription\":null," +
                "\"name\":\"Test User 2\"," +
                "\"password\":null," +
                "\"phone\":null" +
                "}]";
        assertEquals(expectedJson, result);
    }

    @Test
    public void testGetGetAllUserTool_WhenNoUsers_ShouldReturnEmptyJsonArray() {
        // 1. Create an empty list of User objects
        List<User> users = new ArrayList<>();

        // 2. Stub the getAllUsers() method of the mocked UserService to return an empty list
        when(userService.getAllUsers()).thenReturn(users);

        // 3. Call getAllUserTool()
        String result = mcpServiceImp.getAllUserTool();

        // 4. Assert that the returned string is an empty JSON array
        String expectedJson = "[]";
        assertEquals(expectedJson, result);
    }
}
