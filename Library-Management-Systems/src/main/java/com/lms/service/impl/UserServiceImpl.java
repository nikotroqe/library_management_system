package com.lms.service.impl;

import com.lms.model.Book;
import com.lms.model.User;
import com.lms.repository.UserRepository;
import com.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User is not exist with given id: " + userId));
    }

    @Override
    public User updatedUser(long userId, User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setRole(user.getRole());
            existingUser.setName(user.getName());
            existingUser.setSurname(user.getSurname());
            existingUser.setUsername(user.getUsername());
            existingUser.setCreatedDate(user.getCreatedDate());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
