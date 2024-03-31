package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int theId);

    Customer save(Customer theEmployee);

    void deleteById(int theId);

}
