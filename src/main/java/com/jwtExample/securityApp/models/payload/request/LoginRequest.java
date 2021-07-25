package com.jwtExample.securityApp.models.payload.request;

import lombok.Data;

@Data
public class LoginRequest {

	String username;
	
	String password;
}
