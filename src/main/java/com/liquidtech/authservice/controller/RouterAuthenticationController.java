/**
 * RouterAuthenticationController - Auto-generated class
 *
 * @Author: @RahulBudhiraja
 * @Created: 7/1/2025
 */

package com.liquidtech.authservice.controller;

import com.liquidtech.authservice.dto.LoginRequest;
import com.liquidtech.authservice.dto.RegisterRequest;
import com.liquidtech.authservice.model.User;
import com.liquidtech.authservice.repository.UserRepository;
import com.liquidtech.authservice.util.JWTUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class RouterAuthenticationController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public Map<String,String> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginRequest.password, user.getPassword())) {
//                return jwtUtil.generateToken(loginRequest.email);
                return Map.of(
                        "Authorization", "Bearer " + jwtUtil.generateToken(loginRequest.getEmail())
                );
            }
        }

        return Map.of("Bad Request", "Invalid credentials");
    }


    @PostMapping("/register")
    public String register(@Valid  @RequestBody RegisterRequest registerRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(registerRequest.email);
        if (optionalUser.isPresent()) {
            return "User already exists";
        }
        else {
            User user = new User();
            user.setEmail(registerRequest.email);
            user.setUsername(registerRequest.username);
            user.setPhoneNumber(registerRequest.phone);
            user.setRole(registerRequest.role);
            String encodedPassword = passwordEncoder.encode(registerRequest.password);
            if(passwordEncoder.matches(registerRequest.confirmPassword, encodedPassword)) {
                user.setPassword(encodedPassword);
                userRepository.save(user);
                return "User has been registered";
            }
            else {
                return "Password doesn't match";
            }
        }


    }
}