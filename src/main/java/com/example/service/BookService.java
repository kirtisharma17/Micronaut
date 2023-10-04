package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Book;

public interface BookService {
 
 List<Book> getAllBooks();
 
 Optional<Book> getBookById(Long id);
 
 Book createBook(Book book);
 
 Optional<Book> updateBook(Long id, Book book);
 
 boolean deleteBook(Long id);
}
