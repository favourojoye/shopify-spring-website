package io.github.favourojoye.shopify.services;

import io.github.favourojoye.shopify.model.Customer;
import io.github.favourojoye.shopify.repositories.CustomerRepository;

import java.util.List;

public class CustomerServicelmpl extends CustomerService {


    private CustomerRepository customerRepository;

    public CustomerServicelmpl(CustomerRepository customerRepository) {
        super(customerRepository);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


}

