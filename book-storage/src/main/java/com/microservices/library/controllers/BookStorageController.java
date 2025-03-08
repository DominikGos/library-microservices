package com.microservices.library.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public class BookStorageController {

    @GetMapping("")
    public String index() {
        return "Hello World";
    }
}
