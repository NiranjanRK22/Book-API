package com.bookapp.service;

import com.bookapp.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    List<Book> getByAuthor(String author);
    List<Book> getByPriceBetween(double start, double end);
    Book getById(int bookId);
}
