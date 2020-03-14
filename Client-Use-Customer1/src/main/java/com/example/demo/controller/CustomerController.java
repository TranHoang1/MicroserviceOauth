package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IService;

import Models.Customer;

@RestController
@RequestMapping("/services")
public class CustomerController {

	@Autowired
	IService service;

	@PostMapping("/customer")
	@PreAuthorize("hasAuthority('create_profile')")
	public Customer save(@RequestBody Customer customer) {
		return service.Save(customer);
	}

	@GetMapping("/customers")
	public List<Customer> getAll() {
		return service.findAllCustommer();
	}

	@GetMapping("/customer")
	public Customer getOne(@RequestParam int id) {
		return service.findById(id);
	}

}
