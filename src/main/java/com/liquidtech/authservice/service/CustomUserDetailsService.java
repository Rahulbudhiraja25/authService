/**
 * CustomUserDetailsService - Auto-generated class
 *
 * @Author: @RahulBudhiraja
 * @Created: 6/29/2025
 */

package com.liquidtech.authservice.service;

import com.liquidtech.authservice.model.User;
import com.liquidtech.authservice.repository.UserRepository;
import com.liquidtech.authservice.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with given email"+ email));
        return new CustomUserDetails(user);
    }
}
