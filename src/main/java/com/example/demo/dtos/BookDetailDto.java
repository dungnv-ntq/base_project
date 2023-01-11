package com.example.demo.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookDetailDto {
    private Long id;

    private String name;

    private AuthorDto author;

    private LocalDateTime createdAt;
}
