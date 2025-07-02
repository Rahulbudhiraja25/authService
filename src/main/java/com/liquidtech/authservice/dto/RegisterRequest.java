/**
 * RegisterRequest - Auto-generated class
 *
 * @Author: @RahulBudhiraja
 * @Created: 7/1/2025
 */

package com.liquidtech.authservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotEmpty(message = "Email cannot be empty")
    public String email;
    @NotEmpty(message = "Password cannot be empty")
    public String password;
    @NotEmpty(message = "Please confirm your password")
    public String confirmPassword;
    @NotEmpty(message = "Please enter your username")
    public String username;
    @NotEmpty(message = "Please enter your email")
    public String phone;
    @NotEmpty(message = "Role cannot be null")
    public String role;
}
