package com.bookapp.service;

import com.bookapp.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService{

    @Override
    public List<Book> getAll() {
        return Arrays.asList(
                new Book(1, "python", "rahul", 300),
                new Book(2, "java", "priya", 500),
                new Book(3, "node", "ram", 800),
                new Book(4, "angular", "kiran", 1100)

        );
    }

    @Override
    public List<Book> getByAuthor(String author) {
        return getAll()
                .stream()
                .filter(book ->book.getAuthor().equals(author))
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getByPriceBetween(double start, double end) {
        return getAll().stream().filter((book) -> book.getPrice()> start && book.getPrice()<end)
                .collect(Collectors.toList());
    }

    @Override
    public Book getById(int bookId) {
        return getAll().stream()
                .filter(book->book.getBookId()==bookId).findFirst().get();
    }
}
