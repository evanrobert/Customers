package com.example.CustomersProject.Service;

import com.example.CustomersProject.Domain.Book;
import com.example.CustomersProject.Domain.Customer;
import com.example.CustomersProject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    public List<Book> findAllAvalibleBooks() {
        return getBooks().stream().filter(c -> c.getCustomer() == null)
                .collect(Collectors.toList());

    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional
    public Book saveBook(Book book) throws IllegalArgumentException{

        return bookRepository.save(book);
    }



    public void removeBook(Long customerId)  {
        Book book = bookRepository.findByCustomerId(customerId);
        if (book != null) {
            book.setCustomer(null);
            saveBook(book);

        }
    }
}



















