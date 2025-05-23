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
    public void testGetGetAllUserTool_ShouldReturnFormattedStringOfUsers() {
        // 1. Create a list of User objects
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("Test User 1");
        user1.setExperience("Testing");
        users.add(user1);

        User user2 = new User();
        user2.setName("Test User 2");
        user2.setExperience("Java Development");
        users.add(user2);

        // 2. Stub the getAllUsers() method of the mocked UserService
        when(userService.getAllUsers()).thenReturn(users);

        // 3. Call getAllUserTool()
        String result = mcpServiceImp.getAllUserTool();

        // 4. Assert that the returned string is correctly formatted
        String expectedString = "Name: Test User 1, Experience: Testing\n" +
                                "Name: Test User 2, Experience: Java Development\n";
        assertEquals(expectedString, result);
    }
}
