package com.gteruithi.spring6restmvc.service;

import com.gteruithi.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        log.debug("Creating Customers - CustomerServiceImpl.");
        this.customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Joe")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Zoe")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Poe")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public List<Customer> listCustomers() {
        log.debug("listCustomers - CustomerServiceImpl.");
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        log.debug("getCustomerById - CustomerServiceImpl. Customer ID: " + id);

        return customerMap.get(id);
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        log.debug("saveNewCustomer - CustomerServiceImpl.");

        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .version(customer.getVersion())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);
        return savedCustomer;
    }

    @Override
    public void updateById(UUID customerId, Customer customer) {
        log.debug("updateById - CustomerServiceImpl.");
        log.debug("Customer ID: " + customerId);


        Optional.ofNullable(customerMap.get(customerId)).ifPresent(oldCustomer -> {
            oldCustomer.setId(customerId);
            oldCustomer.setCustomerName(!customer.getCustomerName().isEmpty() && !customer.getCustomerName().isBlank() ? customer.getCustomerName() : oldCustomer.getCustomerName());
            oldCustomer.setVersion(customer.getVersion() != null ? customer.getVersion() : oldCustomer.getVersion());
            oldCustomer.setCreatedDate(oldCustomer.getCreatedDate());
            oldCustomer.setLastModifiedDate(LocalDateTime.now());

            customerMap.put(oldCustomer.getId(), oldCustomer);
        });

    }

    @Override
    public void deleteById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void patchCustomerById(UUID customerId, Customer customer) {
        log.debug("patchCustomerById - CustomerServiceImpl.");
        log.debug("Customer ID: " + customerId);

        Optional.ofNullable(customerMap.get(customerId)).ifPresent(oldCustomer -> {
            oldCustomer.setId(customerId);
            oldCustomer.setCustomerName(!customer.getCustomerName().isEmpty() && !customer.getCustomerName().isBlank() ? customer.getCustomerName() : oldCustomer.getCustomerName());
            oldCustomer.setVersion(customer.getVersion() != null ? customer.getVersion() : oldCustomer.getVersion());
            oldCustomer.setCreatedDate(oldCustomer.getCreatedDate());
            oldCustomer.setLastModifiedDate(LocalDateTime.now());

            customerMap.put(oldCustomer.getId(), oldCustomer);
        });
    }
}
