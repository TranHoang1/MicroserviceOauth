package com.example.demo.service;

import java.util.List;

import Models.Customer;

public interface IService {
	Customer Save(Customer cs);

	List<Customer> findAllCustommer();

	Customer findById(int id);

}
