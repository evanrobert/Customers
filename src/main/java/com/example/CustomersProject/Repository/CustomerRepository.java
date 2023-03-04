package com.example.CustomersProject.Repository;

import com.example.CustomersProject.Domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
