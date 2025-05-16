package com.example.demo.service;

import com.example.demo.repo.FakeRepoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UserServiceTests {

    @Autowired
    private UserServiceImpl userService; // Use concrete class to access resetIdCounter

    @Autowired
    private FakeRepoInterface fakeRepo;

    @BeforeEach
    void setUp() {
        // Reset ID counter
        UserServiceImpl.resetIdCounter();
        // Clear all users from repository
        while (fakeRepo.findUserById(1) != null) {
            fakeRepo.deleteUser(1);
        }
        // Ensure no users remain with higher IDs
        for (long i = 2; fakeRepo.findUserById(i) != null; i++) {
            fakeRepo.deleteUser(i);
        }
    }

    @Test
    void testAddUser() {
        userService.addUser("John", "Doe");
        String name = fakeRepo.findUserById(1);
        assertEquals("John", name);
    }

    @Test
    void testGetUser() {
        fakeRepo.insertUser(1, "Jane", "Smith");
        userService.getUser(1);
        String name = fakeRepo.findUserById(1);
        assertEquals("Jane", name);
    }

    @Test
    void testRemoveUser() {
        fakeRepo.insertUser(1, "Bob", "Johnson");
        userService.removeUser(1);
        String name = fakeRepo.findUserById(1);
        assertNull(name);
    }

    @Test
    void testAddDuplicateUser() {
        userService.addUser("Alice", "Brown");
        userService.addUser("Alice", "Brown");
        String name = fakeRepo.findUserById(1);
        assertEquals("Alice", name);
        String name2 = fakeRepo.findUserById(2);
        assertEquals("Alice", name2);
    }

    @Test
    void testGetNonExistentUser() {
        userService.getUser(999);
        String name = fakeRepo.findUserById(999);
        assertNull(name);
    }

    @Test
    void testInvalidInput() {
        userService.addUser("", "");
        String name = fakeRepo.findUserById(1);
        assertEquals("", name);
    }
}