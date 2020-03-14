package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.MyUserCustomer;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailsServiceCustomer implements UserDetailsService {

	@Autowired
	private UserRepository userRepositoris;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userDTOAuThen = userRepositoris.findByUsername(username);

		userDTOAuThen.orElseThrow(() -> new UsernameNotFoundException("User or password is wrong !!!"));

		MyUserCustomer myUserService = new MyUserCustomer(userDTOAuThen.get());

		return myUserService;
	}

}
