package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Customer;
import com.luv2code.springboot.cruddemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomer(Model theModel) {

        // Fetch all customer from the database
        List<Customer> customers = customerService.findAll();

        // add to the spring model
        theModel.addAttribute("customers", customers);

        return "list-customer";
    }

    @GetMapping("/add-customer")
    public String addCustomer(Model theModel) {

        theModel.addAttribute("customer", new Customer());
        return "add-customer";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(Model theModel, @RequestParam("customerId") int customerId) {
        Customer cust = customerService.findById(customerId);
        theModel.addAttribute("customer", cust);
        return "add-customer";
    }

    @PostMapping("/processCustomer")
    public String processCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.save(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {
        customerService.deleteById(customerId);

        return "redirect:/customer/list";
    }
}
