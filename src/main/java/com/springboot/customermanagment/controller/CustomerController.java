package com.springboot.customermanagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.customermanagment.model.Customer;
import com.springboot.customermanagment.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
	CustomerService customerService;
	
    @GetMapping("/showCustomers")
    public List <Customer> getAllCustomer(){
        return customerService.getAllDetails();
    }

	@PostMapping("/customers")
	public Customer saveCustomerDetails (@RequestBody Customer customer) {
		
        return customerService.saveCustomer(customer);
		
	}



}
