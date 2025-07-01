/**
 * RouterAuthenticationController - Auto-generated class
 *
 * @Author: @RahulBudhiraja
 * @Created: 7/1/2025
 */

package com.liquidtech.authservice.controller;

import com.liquidtech.authservice.dto.LoginRequest;
import com.liquidtech.authservice.model.User;
import com.liquidtech.authservice.repository.UserRepository;
import com.liquidtech.authservice.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/auth/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginRequest.password, user.getPassword())) {
                return jwtUtil.generateToken(loginRequest.email);
            }
        }

        return "Invalid credentials";
    }}


//    @PostMapping("/api/auth/register")
//    public String register(){
//}
