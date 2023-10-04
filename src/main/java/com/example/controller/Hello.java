package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.Book;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class Hello {
	
	List<Book> list= new ArrayList<Book>();
	
@Get
public String hello() {
	return "hello message successfully running";
	
}



}
