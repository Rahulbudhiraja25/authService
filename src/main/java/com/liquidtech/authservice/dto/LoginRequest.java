/**
 * LoginRequest - Auto-generated class
 *
 * @Author: @RahulBudhiraja
 * @Created: 7/1/2025
 */

package com.liquidtech.authservice.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {

    @NotNull(message="Email cannot be null")
    public String email;

    @NotNull(message = "password cannot be empty")
    public String password;
}
