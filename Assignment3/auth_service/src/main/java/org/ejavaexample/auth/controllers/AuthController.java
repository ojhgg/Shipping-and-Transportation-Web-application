package org.ejavaexample.auth.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ejavaexample.auth.entity.ERole;
import org.ejavaexample.auth.entity.Role;
import org.ejavaexample.auth.entity.User;
import org.ejavaexample.auth.payload.request.LoginRequest;
import org.ejavaexample.auth.payload.request.SignupRequest;
import org.ejavaexample.auth.payload.request.ValidJwtRequest;
import org.ejavaexample.auth.payload.response.JwtResponse;
import org.ejavaexample.auth.payload.response.MessageResponse;
import org.ejavaexample.auth.repository.RoleRepository;
//import org.ejavaexample.auth.repository.UsrRepository;
import org.ejavaexample.auth.service.UserService;
import org.ejavaexample.auth.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  //@Autowired
  RoleRepository roleRepository;

  @Autowired
  JwtUtils jwtUtils;
  
  @Autowired
  UserService userservice;
  
  //@Autowired
  //@Qualifier("encoder")
  BCryptPasswordEncoder encoder;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

//    Authentication authentication = authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//    SecurityContextHolder.getContext().setAuthentication(authentication);

	try {
		//encoder = new BCryptPasswordEncoder();
		User user = userservice.getUser(loginRequest.getUsername(), loginRequest.getPassword());
		//User user = luser.get();
		if (user != null) {
			String jwt = jwtUtils.generateJwtToken(user.getUsername());
		    List<String> roles = user.getRoles().stream()
		            .map(item -> item.getName().toString())
		            .collect(Collectors.toList());
	
		    return ResponseEntity.ok(new JwtResponse(jwt, 
	                user.getId(), 
	                user.getUsername(), 
	                user.getEmail(), 
	                roles));	
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Error: User Not Found!"));

	}
	catch(Exception e){
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Error: User Not Found!"));
	}
	
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userservice.userExist(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

//    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//      return ResponseEntity
//          .badRequest()
//          .body(new MessageResponse("Error: Email is already in use!"));
//    }

    // Create new user's account
	encoder = new BCryptPasswordEncoder();

    User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = userservice.roleExist(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = userservice.roleExist(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "mod":
          Role modRole = userservice.roleExist(ERole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        default:
          Role userRole = userservice.roleExist(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userservice.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  
  @PostMapping("/isjwtok")
  public ResponseEntity<?> validatejwt(@Valid @RequestBody ValidJwtRequest jwtRequest) {

//    Authentication authentication = authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//    SecurityContextHolder.getContext().setAuthentication(authentication);

	//try {
		boolean isok = jwtUtils.validateJwtToken(jwtRequest.getJwt());
		if (isok)
			return ResponseEntity.ok(new MessageResponse("True"));	
		 
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("False")); 
//	}
//	catch(Exception e){
//		ResponseEntity.status(401).body(new MessageResponse("Error: UserName Not Found!"));
//	}
//	return null;

  }

  
}
