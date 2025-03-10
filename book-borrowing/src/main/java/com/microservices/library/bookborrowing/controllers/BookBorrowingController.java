package com.microservices.library.bookborrowing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.microservices.library.bookborrowing.entities.Book;

@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@RestController
@RequestMapping("/books-borrowing")
public class BookBorrowingController {

    @Autowired
    private BookStorageProxy bookStorageProxy;

    @Autowired
    private RestTemplate restTemplate;

    @DeleteMapping("/{id}")
    public Book borrowBook(@PathVariable int id) {
        Book book = restTemplate.getForObject( "http://localhost:8100/books/" + id, Book.class);

        if(book == null) {
            throw new NullPointerException("Book not found");
        } else {
            restTemplate.delete( "http://localhost:8100/books/" + id );
        }

        return book;
    }

    @DeleteMapping("/feign/{id}")
    public Book borrowBookFeign(@PathVariable int id) {
        Book book = bookStorageProxy.deleteBook(id);

        return book;
    }

    @PostMapping("")
    public Book returnBook(@ModelAttribute Book book) {

        return restTemplate.postForObject( "http://localhost:8100/books", book, Book.class);
    }
}
