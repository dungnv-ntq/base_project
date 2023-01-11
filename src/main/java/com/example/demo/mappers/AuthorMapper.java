package com.example.demo.mappers;

import com.example.demo.dtos.AuthorDetailDto;
import com.example.demo.dtos.AuthorDto;
import com.example.demo.entities.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface AuthorMapper {
    AuthorDto toDto(Author author);

    Author toEntity(AuthorDto dto);

    AuthorDetailDto toDetailDto(Author author);
}
