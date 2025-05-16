package com.example.demo.service;

import com.example.demo.repo.FakeRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final FakeRepoInterface fakeRepo;
    private static long idCounter = 1;

    @Autowired
    public UserServiceImpl(FakeRepoInterface fakeRepo) {
        this.fakeRepo = fakeRepo;
    }

    @Override
    public void addUser(String name, String surname) {
        String addedName = fakeRepo.insertUser(idCounter++, name, surname);
        System.out.println(addedName + " added");
    }

    @Override
    public void removeUser(long id) {
        String removedName = fakeRepo.deleteUser(id);
        if (removedName != null) {
            System.out.println(removedName + " removed");
        }
    }

    @Override
    public void getUser(long id) {
        String name = fakeRepo.findUserById(id);
        if (name != null) {
            System.out.println("hello " + name);
        }
    }

    // Helper method for testing to reset ID counter
    public static void resetIdCounter() {
        idCounter = 1;
    }
}