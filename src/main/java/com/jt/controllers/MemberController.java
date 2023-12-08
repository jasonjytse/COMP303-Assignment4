package com.jt.controllers;
/**
 * 
 * @author Jason Tse
 * Mmeber Controller to handle web requests
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.models.Member;
import com.jt.services.MemberService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("member")
@RestController
@CrossOrigin
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping
	public Flux<Member> getAllMembers() {
		return memberService.getAllMembers();
	}

	@GetMapping("/{id}")
	public Mono<Member> getMemberById(@PathVariable("id") String id) {
		return memberService.getOneMemberById(id);
	}

	@PostMapping
	public Mono<Member> createMember(@RequestBody Member member) {
		member.setMemberId(String.valueOf(Member.getAndIncrementIds()));
		return memberService.createMember(member);
	}
	@PutMapping()
	public Mono<Member> updateBookById(@RequestBody Member member) {
		return memberService.findAndUpdateMember(member);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable final String id) {
		return memberService.deleteMember(id);
	}

	@DeleteMapping()
	public Mono<Void> deleteAll() {
		return memberService.deleteMembers();
	}

}
