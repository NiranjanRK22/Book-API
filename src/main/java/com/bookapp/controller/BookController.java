package com.bookapp.controller;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST API to be used by any other applications
@RestController
@RequestMapping("book-api")
public class BookController {

    private IBookService bookService;

    @Autowired
    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }

    //http://localhost:8080/book-api/books/id/2
    @GetMapping("/books/id/{bookId}")
    public Book getById(@PathVariable("bookId") int bookId)  {
        return bookService.getById(bookId);
    }

    @GetMapping("/books")
    List<Book> getAll()  {
        return bookService.getAll();
    }
    //http://localhost:8081/book-api/books/author/rahul
    @GetMapping("/books/author/{author}")
    List<Book> getByAuthor(@PathVariable("author") String author)  {
        return bookService.getByAuthor(author);
    }

    //http://localhost:8080/book-api/books/cost?startprice=2000&endprice=3000
    @GetMapping("/books/cost")
    List<Book> getByCostBetween(@RequestParam("startprice") double start,@RequestParam("endprice") double end)  {
        return bookService.getByPriceBetween(start, end);
    }
}
