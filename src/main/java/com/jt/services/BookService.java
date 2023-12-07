package com.jt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.interfaces.IBookRepository;
import com.jt.models.Book;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Transactional
@Service
public class BookService {

	@Autowired
	private IBookRepository bookRepository;

	public Flux<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Mono<Book> getOneBookById(String bookId) {
		return bookRepository.findByBookId(bookId);
	}

	public Mono<Book> createBook(Book book) {
		return bookRepository.save(book);
	}

	public Mono<Book> updateBook(String bookId, Book book) {
		return bookRepository.findByBookId(bookId).map(oldBook -> {
			if (book.getBookTitle() != null) {
				oldBook.setBookTitle(book.getBookTitle());
			}

			if (book.getBookAuthor() != null) {
				oldBook.setBookAuthor(book.getBookAuthor());
			}

			if (book.getBookPrice() != null) {
				oldBook.setBookPrice(book.getBookPrice());
			}

			if (book.getIsBookInStock() != null) {
				oldBook.setIsBookInStock(book.getIsBookInStock());
			}
			return oldBook;
		}).flatMap(bookRepository::save);
	}

	public Mono<Void> deleteBook(String bookId) {
		return bookRepository.deleteByBookId(bookId);
	}

	public Mono<Void> deleteBooks() {
		return bookRepository.deleteAll();
	}

}
