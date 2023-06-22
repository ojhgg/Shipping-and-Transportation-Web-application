package org.ejavaexample.auth.payload.request;

import jakarta.validation.constraints.NotBlank;

public class ValidJwtRequest {
	@NotBlank
  private String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
