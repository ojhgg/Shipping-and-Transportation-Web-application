package com.param;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class LoginParam implements Serializable {
    String username;
    String password;
}
