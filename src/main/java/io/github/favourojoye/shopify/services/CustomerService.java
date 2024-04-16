package io.github.favourojoye.shopify.services;

import io.github.favourojoye.shopify.model.Customer;
import io.github.favourojoye.shopify.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * get all customers
     *
     * @return all the customers
     */
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
