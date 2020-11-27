package com.ram.rest.webservices.restfulwebservices.Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ram.rest.webservices.restfulwebservices.Entity.Users;
import com.ram.rest.webservices.restfulwebservices.Repository.UserRepository;

public class MyUserDetails implements UserDetails {
	private String username;
	private String password;
	private String role;

	public MyUserDetails(Users users) {
		this.username = users.getName();
		this.password = users.getPassword();
		this.role = users.getRole().getRolename();
	}
	
	public MyUserDetails() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> gauth = new ArrayList<GrantedAuthority>();
		gauth.add(new SimpleGrantedAuthority(role));
		return gauth;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
