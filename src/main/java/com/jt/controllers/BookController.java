package com.jt.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jt.models.Book;
import com.jt.services.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("books")
@RestController
@CrossOrigin
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public Flux<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Mono<Book> getByBookId(@PathVariable("id") String id) {
		return bookService.getOneBookById(id);
	}
	
//	@PostMapping
//	public Mono<Book> createBook(@RequestParam String bookTitle, @RequestParam String bookAuthor, @RequestParam String bookPrice) {
//		Book book = new Book(bookTitle, bookAuthor, bookPrice);
//		return bookService.createBook(book);
//	}
	
	@PostMapping
	public Mono<Book> createBook(@RequestBody Book book) {
		book.setBookId(String.valueOf(Book.setAndIncrementIds()));
		return bookService.createBook(book); 
	}
	
	@PutMapping("/{id}")
	public Mono<Book> updateBookById(@PathVariable("id") String id, @RequestParam Optional<String> bookTitle, @RequestParam Optional<String> bookAuthor, @RequestParam Optional<String> bookPrice, @RequestParam Optional<Boolean> bookInStock) {
		Book book = new Book();
		book.setBookId(id);
		
		if (bookTitle.isPresent()) {
			book.setBookTitle(bookTitle.get());
		}
		
		if (bookAuthor.isPresent()) {
			book.setBookAuthor(bookAuthor.get());
		}
		
		if (bookPrice.isPresent()) {
			book.setBookPrice(Double.parseDouble(bookPrice.get()));
		}
		
		if (bookInStock.isPresent()) {
			book.setIsBookInStock(bookInStock.get());
		}
		

		return bookService.updateBook(id, book);
	}
	
	@DeleteMapping()
	public Mono<Void> deleteAllBooks() {
		return bookService.deleteBooks();
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deleteBookById(@PathVariable final String id) {
		return bookService.deleteBook(id);
	}

}
