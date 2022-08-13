package com.springboot.customermanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.customermanagment.model.Customer;
import com.springboot.customermanagment.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
