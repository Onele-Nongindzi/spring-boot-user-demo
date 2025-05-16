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
    private UserService userService;

    @Autowired
    private FakeRepoInterface fakeRepo;

    @BeforeEach
    void setUp() {
        // Clear the repository before each test
        while (fakeRepo.deleteUser(1) != null) {
            // Keep deleting until no more users with ID 1
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