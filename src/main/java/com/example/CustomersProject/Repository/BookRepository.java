package com.example.CustomersProject.Repository;

import com.example.CustomersProject.Domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book findByCustomerId(Long id);
}
