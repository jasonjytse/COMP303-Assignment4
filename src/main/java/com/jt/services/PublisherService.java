package com.jt.services;
/**
 * 
 * @author Jason Tse
 * Publisher Service layer to handle business logic
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.interfaces.IPublisherRepository;
import com.jt.models.Publisher;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Transactional
@Service
public class PublisherService {

	@Autowired
	private IPublisherRepository publisherRepository;

	public Flux<Publisher> getAllPublishers() {
		return publisherRepository.findAll();
	}

	public Mono<Publisher> getOnePublisherById(String publisherId) {
		return publisherRepository.findById(publisherId);
	}

	public Mono<Publisher> createPublisher(Publisher publisher) {
		return publisherRepository.save(publisher);
	}

	public Mono<Publisher> findAndUpdatePublisher(Publisher publisher) {
		publisherRepository.findByPublisherId(publisher.getPublisherId()).flatMap(p -> {
			p.setPublisherName(publisher.getPublisherName());
			p.setPublisherAddress(publisher.getPublisherAddress());
			return publisherRepository.save(p);
		}).subscribe();

		return publisherRepository.findById(publisher.getPublisherId());
	}

	public Mono<Void> deletePublisher(String publisherId) {
		return publisherRepository.deleteByPublisherId(publisherId);
	}

	public Mono<Void> deletePublishers() {
		return publisherRepository.deleteAll();
	}

}
