package com.jwtExample.securityApp.models.payload.response;

import lombok.Data;

@Data
public class TokenRefreshResponse {

	private String accessToken;
	
	private String type;
	
	private String refreshToken;
	
	
	
	public TokenRefreshResponse(String accessToken, String refreshToken) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.type = "Bearer";
	}
	
}
