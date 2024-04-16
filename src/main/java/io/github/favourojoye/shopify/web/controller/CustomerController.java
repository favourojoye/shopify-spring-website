package io.github.favourojoye.shopify.web.controller;

import io.github.favourojoye.shopify.model.Customer;
import io.github.favourojoye.shopify.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return  "customers";
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
}
