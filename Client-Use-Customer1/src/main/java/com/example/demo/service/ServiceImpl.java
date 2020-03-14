package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CustomerRepository;

import Models.Customer;

@Service
public class ServiceImpl implements IService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer Save(Customer cs) {
		return customerRepository.save(cs);
	}

	@Override
	public List<Customer> findAllCustommer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int id) {
		return customerRepository.findById(id).get();
	}

}
