package com.jt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.models.Publisher;
import com.jt.services.PublisherService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("publisher")
@RestController
@CrossOrigin
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	@GetMapping
	public Flux<Publisher> getAllBooks() {
		return publisherService.getAllPublishers();
	}

	@GetMapping("{/id}")
	public Mono<Publisher> getPublisherById(@PathVariable("id") String id) {
		return publisherService.getOnePublisherById(id);
	}

	@PostMapping
	public Mono<Publisher> createPublisher(@RequestBody Publisher publisher) {
		publisher.setPublisherId(String.valueOf(Publisher.getAndIncrementIds())); ;
		return publisherService.createPublisher(publisher);
	}


	@PutMapping()
	public Mono<Publisher> updateBookById(@RequestBody Publisher publisher) {
		return publisherService.findAndUpdatePublisher(publisher);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable final String id) {
		return publisherService.deletePublisher(id);
	}

	@DeleteMapping()
	public Mono<Void> deleteAll() {
		return publisherService.deletePublishers();
	}

}
