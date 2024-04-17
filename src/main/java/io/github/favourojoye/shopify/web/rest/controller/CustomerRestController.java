package io.github.favourojoye.shopify.web.rest.controller;

import io.github.favourojoye.shopify.model.Customer;
import io.github.favourojoye.shopify.services.CustomerService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers/" )

public class CustomerRestController  {
    private final CustomerService customerService;
    public CustomerRestController (CustomerService customerService){
        this.customerService=customerService;
    }
    @GetMapping
    public ResponseEntity <List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.findAll());
    }
}
