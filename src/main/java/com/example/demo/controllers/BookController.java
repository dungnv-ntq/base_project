package com.example.demo.controllers;

import com.example.demo.dtos.BookDetailDto;
import com.example.demo.dtos.BookDto;
import com.example.demo.entities.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("")
    public Page<BookDto> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public BookDetailDto getDetail(@PathVariable Long id) {
        return service.getDetail(id);
    }

    @PostMapping("")
    public BookDto createOne(@RequestBody BookDto book) {
        return service.createOne(book);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable Long id) {
        service.removeOne(id);
    }
}
