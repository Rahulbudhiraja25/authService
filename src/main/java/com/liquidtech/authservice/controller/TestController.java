/**
 * TestController - Auto-generated class
 *
 * @Author: @RahulBudhiraja
 * @Created: 7/2/2025
 */

package com.liquidtech.authservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @GetMapping("/api/user/profile")
    public ResponseEntity<String> profile() {
        return ResponseEntity.ok("You are authenticated!");
    }

    @GetMapping("/api/admin")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("You are adminly authenticated!");
    }

}
