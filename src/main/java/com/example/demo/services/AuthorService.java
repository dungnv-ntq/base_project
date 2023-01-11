package com.example.demo.services;

import com.example.demo.dtos.AuthorDetailDto;
import com.example.demo.dtos.AuthorDto;
import com.example.demo.entities.Author;
import com.example.demo.mappers.AuthorMapper;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper mapper;
    @Autowired
    private BookRepository bookRepository;

    public List<AuthorDto> getAll() {
        return authorRepository.findAll().stream().map(entity -> {
            return mapper.toDto(entity);
        }).collect(Collectors.toList());
    }

    public AuthorDetailDto getDetail(Long id) {
        return authorRepository.findById(id).map(entity -> {
            return mapper.toDetailDto(entity);
        }).orElseThrow(() -> new EntityNotFoundException());
    }

    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author entity = authorRepository.save(mapper.toEntity(authorDto));
        return mapper.toDto(entity);
    }

    public AuthorDto updateOne(AuthorDto dto) {
        return authorRepository.findById(dto.getId()).map(entity -> {
            BeanUtils.copyProperties(dto, entity);
            authorRepository.save(entity);
            return mapper.toDto(entity);
        }).orElseThrow(() -> new EntityNotFoundException());
    }

}
