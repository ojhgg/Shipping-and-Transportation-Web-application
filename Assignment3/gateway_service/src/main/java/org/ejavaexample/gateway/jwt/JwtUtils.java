package org.ejavaexample.gateway.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//import edu.bjtu.rest.security.services.UserDetailsImpl;
//import io.jsonwebtoken.*;

@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

public boolean isInvalid(String token) {
	// TODO Auto-generated method stub
	return false;
}

}
