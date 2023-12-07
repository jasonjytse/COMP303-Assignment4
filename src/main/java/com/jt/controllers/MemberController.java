package com.jt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.models.Book;
import com.jt.services.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("member")
@RestController
@CrossOrigin
public class MemberController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public Flux<Book> getAllBooks() {
		return null;
	}
	
	@GetMapping("{id}")
	public Mono<Book> getByBookId() {
		return null;
	}
	
	@PutMapping("{id}")
	public Mono updateBookById() {
		return null;
	}
	
	@DeleteMapping("{id}")
	public Mono delete(@PathVariable final String id) {
		return null;
	}

}
