package com.gt_enterprise.auth_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {

    private String jwtToken;

    public AuthenticationResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

}
