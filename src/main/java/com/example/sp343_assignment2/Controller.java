package com.example.sp343_assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/book")
    List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/isbn/{isbn}")
    Book getBooksByIsbn(@PathVariable String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @GetMapping("/book/title/{title}")
    List<Book> getBooksByTitle(@PathVariable String title) {
        return bookRepository.findByTitle(title);
    }

    @GetMapping("book/pageCount/{lowerBound}/{upperBound}")
    List<Book> getBooksByPageCount(@PathVariable int lowerBound, @PathVariable int upperBound) {
        return bookRepository.findByPageCount(lowerBound, upperBound);
    }

}
