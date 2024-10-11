package com.gt_enterprise.auth_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {

    private String message;

    public AuthenticationResponse(String message) {
        this.message = message;
    }
    
}
