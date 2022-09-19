package org.example.controller;

import org.example.model.Book;
import org.example.model.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController
{
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    List<Book> all()
    {
        return bookRepository.findAll();
    }

    //TODO: implement
}
