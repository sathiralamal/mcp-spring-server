package org.example.modelcontextprotocoleapi.service;

import org.example.modelcontextprotocoleapi.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TestMpcServiceImpTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private TestMpcServiceImp testMpcServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUserNames_shouldReturnCommaSeparatedNames_whenUsersExist() {
        // Arrange
        User user1 = new User();
        user1.setName("Alice");
        User user2 = new User();
        user2.setName("Bob");
        User user3 = new User();
        user3.setName("Charlie");
        List<User> users = Arrays.asList(user1, user2, user3);
        when(userService.getAllUsers()).thenReturn(users);

        // Act
        String result = testMpcServiceImp.getUserNames();

        // Assert
        assertEquals("Alice, Bob, Charlie", result);
    }

    @Test
    void getUserNames_shouldReturnEmptyString_whenNoUsersExist() { // Corrected based on implementation
        // Arrange
        when(userService.getAllUsers()).thenReturn(Collections.emptyList());

        // Act
        String result = testMpcServiceImp.getUserNames();

        // Assert
        assertEquals("No users found.", result); // Corrected expected result
    }

    @Test
    void getUserNames_shouldReturnEmptyString_whenUserServiceReturnsNull() { // Corrected based on implementation
        // Arrange
        when(userService.getAllUsers()).thenReturn(null);

        // Act
        String result = testMpcServiceImp.getUserNames();

        // Assert
        assertEquals("No users found.", result); // Corrected expected result
    }

    @Test
    void getUserNames_shouldHandleSingleUser() {
        // Arrange
        User user1 = new User();
        user1.setName("David");
        List<User> users = Collections.singletonList(user1);
        when(userService.getAllUsers()).thenReturn(users);

        // Act
        String result = testMpcServiceImp.getUserNames();

        // Assert
        assertEquals("David", result);
    }
}
