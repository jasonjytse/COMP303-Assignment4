package com.jt.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jt.models.Book;

import reactor.core.publisher.Mono;

public interface IBookRepository extends ReactiveMongoRepository<Book, String> {
	Mono<Book> findByBookId(String bookId);
	Mono<Void> deleteByBookId(String bookId);


}
