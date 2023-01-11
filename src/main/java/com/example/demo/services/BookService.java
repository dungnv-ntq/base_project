package com.example.demo.services;

import com.example.demo.dtos.BookDetailDto;
import com.example.demo.dtos.BookDto;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.mappers.BookMapper;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookMapper mapper;

    public Page<BookDto> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(entity -> {
                    return mapper.toDto(entity);
                });
    }

    public BookDetailDto getDetail(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return mapper.toDetailDto(book);
    }

    public BookDto createOne(BookDto dto) {
        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException());

        Book book = new Book();
        book.setName(dto.getName());
        book.setAuthor(author);
        bookRepository.save(book);

        dto.setId(book.getId());
        return dto;
    }

    public void removeOne(Long id) {
        bookRepository.findById(id).map(entity -> {
            bookRepository.delete(entity);
            return entity;
        }).orElseThrow(() -> new EntityNotFoundException());
    }
}
