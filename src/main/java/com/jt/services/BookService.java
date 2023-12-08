package com.jt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.interfaces.IBookRepository;
import com.jt.models.Book;

import lombok.AllArgsConstructor;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Transactional
@Service
public class BookService {

	@Autowired
	private IBookRepository bookRepository;

	@Autowired
	private ReactiveMongoTemplate mongoTemplate;

	public Flux<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// public Mono<Book> getOneBookById(String bookId) {
	// 	return bookRepository.findByBookId(bookId);
	// }

	public Mono<Book> getOneBookById(String bookId) {
		return bookRepository.findById(bookId);
	}

	public Mono<Book> createBook(Book book) {
		return bookRepository.save(book);
	}

	// public Mono<Book> findAndUpdateBook(String bookId, String bookTitle, String bookAuthor, Double bookPrice,
	// 		Boolean isBookInStock) {
	// 	Query query = new Query();
	// 	query.addCriteria(Criteria.where("bookId").is(bookId));

	// 	Update update = new Update();
	// 	update.set("bookTitle", bookTitle);
	// 	update.set("bookAuthor", bookAuthor);
	// 	update.set("bookPrice", bookPrice);
	// 	update.set("isBookInStock", isBookInStock);

	// 	return mongoTemplate.findAndModify(query, update, Book.class);
	// }

	public Mono<Book> findAndUpdateBook(Book book) {
		bookRepository.findByBookId(book.getBookId()).flatMap(b -> {
			b.setBookTitle(book.getBookTitle());
			b.setBookAuthor(book.getBookAuthor());
			b.setBookPrice(book.getBookPrice());
			b.setIsBookInStock(book.getIsBookInStock());
			return bookRepository.save(b);
		}).subscribe();

		return bookRepository.findByBookId(book.getBookId());
	}

	public Mono<Void> deleteBook(String bookId) {
		return bookRepository.deleteByBookId(bookId);
	}

	public Mono<Void> deleteBooks() {
		return bookRepository.deleteAll();
	}

}
