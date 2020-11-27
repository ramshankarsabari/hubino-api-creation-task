/**
 * 
 */
package com.ram.rest.webservices.restfulwebservices.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ram.rest.webservices.restfulwebservices.Entity.Users;
import com.ram.rest.webservices.restfulwebservices.Others.MyUserDetails;
import com.ram.rest.webservices.restfulwebservices.Repository.UserRepository;

/**
 * @author Ram shankar
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Optional<Users> userData = userRepo.findByName(name);
		userData.orElseThrow(() -> new UsernameNotFoundException("Not found : "+name));
		return new MyUserDetails(userData.get());
	}

}
