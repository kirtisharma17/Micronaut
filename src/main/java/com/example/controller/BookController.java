package com.example.controller;


import java.util.List;
import java.util.Optional;

import com.example.entity.Book;
import com.example.service.BookService;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

@Controller("/books")
public class BookController {
 
	private final BookService bookService;

 public BookController(BookService bookService) {
     this.bookService = bookService;
 }

 @Get("/")
 public List<Book> getAllBooks() {
     return bookService.getAllBooks();
 }

 @Get("/{id}")
 public Optional<Book> getBookById(Long id) {
     return bookService.getBookById(id);
 }

 @Post("/")
 public HttpResponse<Book> createBook(@Body Book book) {
     Book createdBook = bookService.createBook(book);
     return HttpResponse.created(createdBook);
 }

 @Put("/{id}")
 public HttpResponse<Book> updateBook(Long id, @Body Book book) {
     Optional<Book> updatedBook = bookService.updateBook(id, book);
     return updatedBook.map(HttpResponse::ok).orElse(HttpResponse.notFound());
 }

 @Delete("/{id}")
 public HttpResponse<Void> deleteBook(Long id) {
     if (bookService.deleteBook(id)) {
         return HttpResponse.noContent();
     }
     return HttpResponse.notFound();
 }
}

