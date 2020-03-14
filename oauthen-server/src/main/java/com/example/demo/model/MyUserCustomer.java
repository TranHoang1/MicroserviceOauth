package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserCustomer extends User implements UserDetails {

	public MyUserCustomer(User user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authoritis = new ArrayList<>();
		super.getRoles().forEach(authanRole -> {
			authoritis.add(new SimpleGrantedAuthority(authanRole.getName()));
			authanRole.getPermissions().forEach(permiss -> {
				authoritis.add(new SimpleGrantedAuthority(permiss.getName()));
			});
		});
		return authoritis;
	}

	@Override
	public String getPassword() {
		return super.getPassWord();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.isCredentialsNonExpired();
	}

	@Override
	public String getUsername() {
		return super.getusername();
	}

}
