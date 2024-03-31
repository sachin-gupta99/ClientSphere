package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // that's it ... no need to write any code LOL!

    public List<Customer> findAllByOrderByLastNameAsc();

    public List<Customer> findAllByOrderByFirstNameAsc();

}
