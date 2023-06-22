package org.ejavaexample.gateway.jwt.payload.response;

import jakarta.validation.constraints.NotBlank;

public class MessageResponse {
  
  @NotBlank
  private String message;


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
