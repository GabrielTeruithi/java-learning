package com.gteruithi.spring6restmvc.controller;

import com.gteruithi.spring6restmvc.model.Customer;
import com.gteruithi.spring6restmvc.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PatchMapping
    public ResponseEntity patchCustomerById(@PathVariable("customerId")UUID customerId, Customer customer){
        log.debug("patchCustomerById - CustomerController.");
        customerService.patchCustomerById(customerId, customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteById(@PathVariable("customerId")UUID customerId) {
        log.debug("deleteById - CustomerController.");

        customerService.deleteById(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomer() {
        log.debug("listCustomer - CustomerController.");
        return customerService.listCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId) {
        log.debug("getCustomerById - CustomerController. Customer ID: " + customerId);
        return customerService.getCustomerById(customerId);
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        log.debug("addCustomer - CustomerController. Customer ID: " + customer.toString());
        Customer customerSaved = customerService.saveNewCustomer(customer);
        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/v1/customer/" + customerSaved.getId().toString());
        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateById(@PathVariable("customerId") UUID customerId, Customer customer){
        log.debug("updateById - CustomerController. Customer ID: " + customerId);

        customerService.updateById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
