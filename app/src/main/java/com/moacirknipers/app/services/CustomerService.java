package com.moacirknipers.app.services;

import com.moacirknipers.app.entities.Customer;
import com.moacirknipers.app.exceptions.CustomerException;
import com.moacirknipers.app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Customer> createCustomer(Customer customer) {
        Customer createdCustomer;
        URI location = null;
        try {
            createdCustomer = repository.save(customer);
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCustomer.getId()).toUri();
        } catch (Exception e) {
            throw new CustomerException(String.format("Customer register error with identify document: %s", customer.getIdentityDocument()), e);
        }
        return ResponseEntity.created(location).build();
    }

    public Optional<Customer> getCustomerByIdentifyDocument(String identifyDocument) {
        Optional<Customer> customer = null;
        try {
            customer = repository.findByIdentityDocument(identifyDocument);
            if (!customer.isPresent()) {
                throw new CustomerException(String.format("Identify document invalid - %s", identifyDocument));
            }
        } catch (Exception e) {
            throw new CustomerException(String.format("Identify document invalid - %s", identifyDocument), e);
        }
        return customer;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> list;
        try {
            list = repository.findAll();
        } catch (Exception e) {
            throw new CustomerException("Find all customers error", e);
        }
        return list;
    }
}
