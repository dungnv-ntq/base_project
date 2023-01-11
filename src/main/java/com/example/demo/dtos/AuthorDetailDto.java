package com.example.demo.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AuthorDetailDto {
    private Long id;

    private String name;

    private List<BookDto> books;

    private LocalDateTime createdAt;
}
