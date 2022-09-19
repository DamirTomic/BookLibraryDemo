package org.example.controller;

import org.example.model.Book;
import org.example.model.BookRepository;
import org.example.model.UserBookHistory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/books/{id}")
    Book one(@PathVariable Long id)
    {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookController.BookNotFoundException(id));
    }

    @GetMapping("/books/{id}/history")
    List<UserBookHistory> all(@PathVariable Long id)
    {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookController.BookNotFoundException(id));

        return book.getUserBookHistory();
    }

    @PostMapping("/books")
    Book newBook(@RequestBody Book newUser)
    {
        return bookRepository.save(newUser);
    }


    @PutMapping("books/{id}")
    Book replaceUser(@RequestBody Book newBook, @PathVariable Long id)
    {
        return bookRepository.findById(id)
                .map(book ->
                {
                    book.setName(newBook.getName());
                    book.setAuthor(newBook.getAuthor());
                    book.setId(newBook.getId());
                    book.setUserBookHistory(newBook.getUserBookHistory());
                    return bookRepository.save(book);
                })
                .orElseGet(() ->
                {
                    newBook.setId(id);
                    return bookRepository.save(newBook);
                });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id)
    {
        bookRepository.deleteById(id);
    }

    @ResponseBody
    @ExceptionHandler(BookController.BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String bookNotFoundException(BookController.BookNotFoundException ex)
    {
        return ex.getMessage();
    }

    static class BookNotFoundException extends RuntimeException
    {
        BookNotFoundException(Long id)
        {
            super("Could not find book " + id);
        }
    }
}
