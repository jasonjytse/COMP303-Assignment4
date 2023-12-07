package com.jt.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jt.models.Member;

public interface IMemberRepository extends ReactiveMongoRepository<Member, String>{

}
