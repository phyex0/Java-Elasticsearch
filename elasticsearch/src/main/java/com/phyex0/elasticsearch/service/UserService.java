package com.phyex0.elasticsearch.service;

import com.phyex0.elasticsearch.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);

    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(User user);

    String deleteUser(UUID id);

    List<User> getUserByFilter(LocalDate localDate);
}
