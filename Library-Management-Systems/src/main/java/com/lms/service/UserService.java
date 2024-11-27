package com.lms.service;

import com.lms.model.User;

public interface UserService {
    User createUser(User user);
    User getUserById(long userId);
    User updatedUser(long userId, User user);
    void deleteUserById(Long userId);
    void registerUser(String username, String password);
}
