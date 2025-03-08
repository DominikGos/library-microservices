package com.microservices.library.controllers;

import com.microservices.library.entities.Book;
import com.microservices.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookStorageController {
    private BookRepository bookRepository;

    @Autowired
    public BookStorageController(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("")
    public List<Book> index() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
