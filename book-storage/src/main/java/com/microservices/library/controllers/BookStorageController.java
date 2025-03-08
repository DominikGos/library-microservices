package com.microservices.library.controllers;

import com.microservices.library.entities.Book;
import com.microservices.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public Book addBook(@ModelAttribute Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public Book deleteBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new NullPointerException("There is no book with id " + id));

        bookRepository.delete(book);

        return book;
    }
}
