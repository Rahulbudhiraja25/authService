/**
 * TestController - Auto-generated class
 *
 * @Author: @RahulBudhiraja
 * @Created: 7/2/2025
 */

package com.liquidtech.authservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @GetMapping("/api/user/profile")
    public ResponseEntity<String> profile() {
        return ResponseEntity.ok("You are authenticated!");
    }
}
