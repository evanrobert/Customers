package com.example.CustomersProject.Service;

import com.example.CustomersProject.Domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer getCustomer(Long id);

    void deleteCustomer(Long id);

    List<Customer> saveAllCustomer(List<Customer> customerList);
}

