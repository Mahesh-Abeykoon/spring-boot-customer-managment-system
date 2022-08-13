package com.springboot.customermanagment.service;

import java.util.List;
import java.util.Optional;

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

    public List <Customer> getAllDetails(){
    return customerRepository.findAll();       
    }

    public Optional <Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }


    public  Customer updateCustomerById(Long id, Customer customer ){
        Customer existingCustomer = new Customer();
        existingCustomer.setId(id);
        existingCustomer.setName(customer.getName());
        existingCustomer.setMarried(customer.isMarried());
        existingCustomer.setLocation(customer.getLocation());
        existingCustomer.setContactNumber(customer.getContactNumber());
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return updatedCustomer;
    }




}
