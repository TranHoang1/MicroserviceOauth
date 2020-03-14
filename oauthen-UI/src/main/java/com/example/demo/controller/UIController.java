package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.tokenaccess.AcessToken;

import Models.Customer;

@Controller
@EnableOAuth2Sso
public class UIController extends WebSecurityConfigurerAdapter {

	@Autowired
	RestTemplate restTemplate;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
	}

	@RequestMapping(value = "/")
	public String getIndex() {
		return "home";
	}

	@RequestMapping(value = "/source")
	public String getSource() {
		return "source";
	}

	@RequestMapping(value = "/customers")
	public String getCustomer(Model model) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", AcessToken.getAccessToken());
		HttpEntity<Customer> httpEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<Customer[]> customerEntity = restTemplate.exchange("http://localhost:8181/services/customers",HttpMethod.GET, httpEntity, Customer[].class);
		model.addAttribute("customers", customerEntity.getBody());

		return "source";
	}

}
