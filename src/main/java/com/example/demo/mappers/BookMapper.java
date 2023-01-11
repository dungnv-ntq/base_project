package com.example.demo.mappers;

import com.example.demo.dtos.BookDetailDto;
import com.example.demo.dtos.BookDto;
import com.example.demo.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookDto dto);

    @Mapping(target = "authorId", source = "author.id")
    BookDto toDto(Book book);

    BookDetailDto toDetailDto(Book book);
}
