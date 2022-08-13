package com.springboot.customermanagment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id){
        return customerService.getCustomerById(id);

    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer( @PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomerById(id, customer);
    }



}
