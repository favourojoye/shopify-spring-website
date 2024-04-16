package io.github.favourojoye.shopify.services;

import io.github.favourojoye.shopify.model.Customer;
import io.github.favourojoye.shopify.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public abstract List<Customer> getAllCustomers();

    public abstract Customer createCustomer(Customer customer);
}
