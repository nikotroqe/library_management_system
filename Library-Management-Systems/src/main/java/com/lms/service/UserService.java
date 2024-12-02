package com.lms.service;

import com.lms.model.User;

import java.time.ZonedDateTime;
import java.util.List;

public interface UserService {
    //User createUser(User user);
    void createUser(String name, String surname, String username, String password, String role,ZonedDateTime createdDate);
    List<User> getAllUser();
    User getUserById(long userId);
    User updatedUser(long userId, User user);
    void deleteUserById(Long userId);



}
