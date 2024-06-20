package com.phyex0.elasticsearch.service;

import com.phyex0.elasticsearch.exception.UserAlreadyExistException;
import com.phyex0.elasticsearch.exception.UserNotFoundException;
import com.phyex0.elasticsearch.model.User;
import com.phyex0.elasticsearch.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(UUID id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Given ID : [%s] is not found", id)));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User createUser(User user) {
        if (Objects.nonNull(user.getId())) {
            Optional<User> byId = userRepository.findById(user.getId());
            if (byId.isPresent()) {
                throw new UserAlreadyExistException(String.format("This user with ID [%s] is already exists.", byId.get().getId()));
            }
        }
        user = userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public String deleteUser(UUID id) {
        userRepository.deleteById(id);
        return String.format("User is deleted with ID [%s]", id);
    }

    @Override
    public List<User> getUserByFilter(LocalDate localDate) {
        return userRepository.getByDateFilter(localDate.toString());
    }
}
