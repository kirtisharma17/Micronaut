package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Book;
import com.example.repository.BookRepository;

import jakarta.inject.Singleton;

@Singleton
public class BookServiceImpl implements BookService {
 private final BookRepository bookRepository;

 public BookServiceImpl(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }

 @Override
 public List<Book> getAllBooks() {
     return (List<Book>) bookRepository.findAll();
 }

 @Override
 public Optional<Book> getBookById(Long id) {
     return bookRepository.findById(id);
 }

 @Override
 public Book createBook(Book book) {
     return bookRepository.save(book);
 }

 @Override
 public Optional<Book> updateBook(Long id, Book book) {
     if (bookRepository.existsById(id)) {
         book.setId(id);
         return Optional.of(bookRepository.update(book));
     }
     return Optional.empty();
 }

 @Override
 public boolean deleteBook(Long id) {
     if (bookRepository.existsById(id)) {
         bookRepository.deleteById(id);
         return true;
     }
     return false;
 }
}

