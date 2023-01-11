package com.example.demo.controllers;

import com.example.demo.dtos.AuthorDetailDto;
import com.example.demo.dtos.AuthorDto;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<AuthorDto> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public AuthorDetailDto getDetail(@PathVariable Long id) {
        return authorService.getDetail(id);
    }

    @PostMapping("")
    public AuthorDto createAuthor(@RequestBody @Validated AuthorDto authorDto) {
        return authorService.createAuthor(authorDto);
    }

    @PutMapping("/{id}")
    public AuthorDto updateOne(@PathVariable Long id,
                               @RequestBody AuthorDto dto) {
        dto.setId(id);
        return authorService.updateOne(dto);
    }
}
