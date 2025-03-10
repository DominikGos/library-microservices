package com.microservices.library.bookborrowing.controllers;

import com.microservices.library.bookborrowing.entities.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="book-storage", url="localhost:8100")
public interface BookStorageProxy {
    @DeleteMapping("/books/{id}")
    Book deleteBook(@PathVariable("id") long id);
}
