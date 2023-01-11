package com.example.demo.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookDto {

    private Long id;

    private String name;
    private Long authorId;

    private LocalDateTime createdAt;
}
