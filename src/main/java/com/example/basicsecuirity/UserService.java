package com.example.basicsecuirity;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(User user) {
        String encodePassword = passwordEncoder.encode(user.getPassword());
        User newUser = new User(user.getUserName(), encodePassword);
        userRepository.save(newUser);
    }
}
