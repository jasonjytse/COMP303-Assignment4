package com.jt.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jt.models.Member;

import reactor.core.publisher.Mono;

public interface IMemberRepository extends ReactiveMongoRepository<Member, String>{
    public Mono<Member> findByMemberId(String memberId);
    public Mono<Void> deleteByMemberId(String memberId);
}
