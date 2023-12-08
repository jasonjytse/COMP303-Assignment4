package com.jt.interfaces;
/**
 * 
 * @author Jason Tse
 * Publisher Repository interface implementing MongoDB interface
 */

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jt.models.Publisher;

import reactor.core.publisher.Mono;

public interface IPublisherRepository extends ReactiveMongoRepository<Publisher, String> {
    public Mono<Publisher> findByPublisherId(String publisherId);
    public Mono<Void> deleteByPublisherId(String publisherId);

}
