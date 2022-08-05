package com.springBoot.ticketBooking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.springBoot.ticketBooking.model.UserModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wrapper implements UserDetails {
	
	String ROLE_PREFIX = "ROLE_";
	private UserModel user;

    public Wrapper(UserModel user) {
        this.user = user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        
		 authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + getUsertype()));
         
        return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getUserpassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}
	
	public String getUsertype() {
		// TODO Auto-generated method stub
		return user.getUsertype();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
