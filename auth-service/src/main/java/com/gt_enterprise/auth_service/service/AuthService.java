package com.gt_enterprise.auth_service.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gt_enterprise.auth_service.dto.AuthenticationRequest;
import com.gt_enterprise.auth_service.dto.AuthenticationResponse;
import com.gt_enterprise.auth_service.dto.RegisterRequest;
import com.gt_enterprise.auth_service.entity.User;
import com.gt_enterprise.auth_service.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(registerRequest.getPassword()));
        user.setRole(User.Role.USER);

        userRepository.save(user);

        return new AuthenticationResponse("User registered Successfully ");
    }
    

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
    
        User user =  userRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        if(bCryptPasswordEncoder.matches(authenticationRequest.getPassword() ,user.getPassword())) {
            return new AuthenticationResponse("Authentication Successful");
        } else {
            throw new RuntimeException("Invalid Credentials");
        }
    }
}



    
