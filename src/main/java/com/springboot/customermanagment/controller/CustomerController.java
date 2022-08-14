package com.springboot.customermanagment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.customermanagment.model.Customer;
import com.springboot.customermanagment.repository.CustomerRepository;
import com.springboot.customermanagment.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
	CustomerService customerService;
	
    @GetMapping("/showCustomers")
    public ResponseEntity <List <Customer>> getAllCustomer(){
    
        try {
			List<Customer> list = customerService.getAllDetails();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
			}
            return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@PostMapping("/customers")
	public ResponseEntity <Customer> saveCustomerDetails (@RequestBody Customer customer) {
		
        //return new ResponseEntity<> (customerService.saveCustomer(customer), HttpStatus.CREATED);
		try {
            return new ResponseEntity<> (customerService.saveCustomer(customer), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

    @GetMapping("/customer/{id}")
    public ResponseEntity <Customer> getCustomer(@PathVariable Long id){
       //return customerService.getCustomerById(id);

        Optional<Customer> customer = customerService.getCustomerById(id);

        if (customer.isPresent()) {
			return new ResponseEntity<Customer>(customer.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}



    @PutMapping("/customerUpdate/{id}")
    public ResponseEntity <Customer> updateCustomer( @PathVariable Long id, @RequestBody Customer customer){
        
        //return customerService.updateCustomerById(id, customer);

        try {
			return new ResponseEntity<Customer>(customerService.updateCustomerById(id, customer), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }


    @DeleteMapping("/customerDelete/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id){
         
        //customerService.deleteCustomer(id);

        try {
			Optional<Customer> customer = customerService.getCustomerById(id);
			if (customer.isPresent()) {
				customerService.deleteCustomer(customer.get().getId());
                return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

    }



}
