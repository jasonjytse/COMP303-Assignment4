package com.jt.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jt.models.Publisher;

public interface IPublisherRepository extends ReactiveMongoRepository<Publisher, String> {

}
