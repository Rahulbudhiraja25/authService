/**
 * UserRepository - Auto-generated interace
 *
 * @Author: @RahulBudhiraja
 * @Created: 6/29/2025
 */

package com.liquidtech.authservice.repository;

import com.liquidtech.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
