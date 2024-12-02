package com.lms.service.impl;

import com.lms.model.User;
import com.lms.repository.UserRepository;
import com.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /*@Override
    public User createUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }*/
    @Override
    public void createUser(String name, String surname , String username, String password, String role, ZonedDateTime createdDate) {
        if (role == null || role.isEmpty()) {
            role = "ROLE_USER"; // Default to ROLE_USER if no role is provided
        }

        // Ensure the role is either ROLE_USER or ROLE_ADMIN
        if (!role.equals("ROLE_USER") && !role.equals("ROLE_ADMIN")) {
            throw new IllegalArgumentException("Invalid role. Must be either 'ROLE_USER' or 'ROLE_ADMIN'.");
        }

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role); // Set the provided role
        user.setCreatedDate(createdDate);
        userRepository.save(user);
    }
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
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
            existingUser.setName(user.getName());
            existingUser.setSurname(user.getSurname());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
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
