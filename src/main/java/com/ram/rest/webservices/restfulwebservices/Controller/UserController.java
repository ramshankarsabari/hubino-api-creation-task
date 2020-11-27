/**
 * 
 */
package com.ram.rest.webservices.restfulwebservices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ram.rest.webservices.restfulwebservices.Entity.Users;
import com.ram.rest.webservices.restfulwebservices.Others.AuthenticationRequest;
import com.ram.rest.webservices.restfulwebservices.Others.AuthenticationResponse;
import com.ram.rest.webservices.restfulwebservices.Repository.UserRepository;
import com.ram.rest.webservices.restfulwebservices.Service.AddressFetchAndStoreService;
import com.ram.rest.webservices.restfulwebservices.Service.MyUserDetailsService;
import com.ram.rest.webservices.restfulwebservices.Utils.JwtUtil;

/**
 * @author Ram shankar
 *
 */
@RestController
@RequestMapping(path="/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressFetchAndStoreService addressFetchAndStoreService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@GetMapping(path="/list")
	public List<Users> listAllUsers() {
		List<Users> result = userRepository.findAll();
		return result;
	}
	
	@PostMapping("/register")
	public Users registerUser(@RequestBody Users users) {
		Users result = userRepository.save(users);
		return result;	
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> updateUser(@RequestParam(value="param1", required=true) String user_id,
			@RequestParam(value="param2", required=true) String ipaddr) {
		addressFetchAndStoreService.doUpdateAddress(Long.parseLong(user_id),ipaddr);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (Exception e) {
			throw new Exception("Incorrect username or password", e);
		}
		UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		String jwt = jwtTokenUtil.generateToken(userDetails.getUsername());
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
