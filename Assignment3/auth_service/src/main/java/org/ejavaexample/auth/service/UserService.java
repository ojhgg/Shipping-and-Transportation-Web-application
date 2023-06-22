package org.ejavaexample.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.crypto.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.Service;
import org.ejavaexample.auth.entity.Role;
import org.ejavaexample.auth.entity.ERole;
import org.ejavaexample.auth.entity.User;
import org.ejavaexample.auth.repository.RoleRepository;
import org.ejavaexample.auth.repository.UsrRepository;

@Service
public class UserService {
	
    @Autowired
    @Qualifier("usrRepository")
    UsrRepository usrRepository;
    
    @Autowired 
    RoleRepository roleRepository;

    //@Autowired
    //@Qualifier("encoder")
    BCryptPasswordEncoder encoder;
	
	   /* PRODUCT */
    public List<User> getUsers(){
        return usrRepository.findAll();
    }
    
    public User getUser(String username, String password){
    	encoder = new BCryptPasswordEncoder();
    	//String psw_encode = encoder.encode(password);
    	User usr = usrRepository.findByUsername(username).get();
    	if (usr != null) {
    		boolean match = encoder.matches(password, usr.getPassword());
    		if (match) return usr;
    	}
    	
        return null;
    }
    
    public User save(User user){
        return usrRepository.save(user);
    }

    public Boolean userExist(String username) {
    	return usrRepository.existsByUsername(username);
    }
    
    public Optional<Role> roleExist(ERole r) {
    	return roleRepository.findByName(r);
    }
}
