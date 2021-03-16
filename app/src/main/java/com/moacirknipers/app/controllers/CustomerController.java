package com.moacirknipers.app.controllers;

import com.moacirknipers.app.entities.Customer;
import com.moacirknipers.app.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Customer Service")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @ApiOperation(value = "Customer list")
    @GetMapping("customers")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @ApiOperation(value = "Find customer by identify document")
    @GetMapping("customers/{identifyDocument}")
    public Optional<Customer> getCustomerByCpf(@PathVariable String identifyDocument) {
        return service.getCustomerByIdentifyDocument(identifyDocument);
    }

    @ApiOperation(value = "Register a new customer")
    @PostMapping("customers")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }
}
