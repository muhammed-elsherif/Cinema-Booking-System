package com.bookingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookingSystem.entity.User;
import com.bookingSystem.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        user.setRole("USER");
        User user1 = new User(null, user.getEmail(), passwordEncoder.encode(user.getPassword()), user.getRole(), user.getFullname());
        return userRepository.save(user1);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail( email);
    }
}

