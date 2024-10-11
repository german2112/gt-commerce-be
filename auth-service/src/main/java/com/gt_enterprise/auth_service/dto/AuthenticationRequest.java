package com.gt_enterprise.auth_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
    
}
