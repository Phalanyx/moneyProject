package com.example.demo.api.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private userRepo userRepo;


    public User getUserById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    public User addUser(@RequestBody User user) {

        if (user.getId() == null || this.getUserById(user.getId()) != null) {
            throw new IllegalArgumentException("User ID is required and must be unique");
        }

        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Boolean deleteUser(Integer id) {
        if (this.getUserById(id) == null) {
            return false;
        }
        userRepo.deleteById(id);
        return true;
    }
}
