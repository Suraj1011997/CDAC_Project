package com.app.services;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.pojos.Login;

public class CustomLoginDetails implements UserDetails {
	
	private Login login;

	public CustomLoginDetails(Login login) {
		super();
		this.login = login;
	}

	@Override
	public String toString() {
		return "CustomLoginDetails [Login=" + login + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(login.getUser().role), new SimpleGrantedAuthority(login.getAdmin().role));		
	}

	@Override
	public String getPassword() { return login.getPassword(); }

	@Override
	public String getUsername() { return login.getUsername(); }

	@Override
	public boolean isAccountNonExpired() { return true; }

	@Override
	public boolean isAccountNonLocked() { return true; }

	@Override
	public boolean isCredentialsNonExpired() { return true; }

	@Override
	public boolean isEnabled() { return true; }
}