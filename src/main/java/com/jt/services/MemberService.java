package com.jt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.interfaces.IMemberRepository;
import com.jt.models.Member;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Transactional
@Service
public class MemberService {

	@Autowired
	private IMemberRepository memberRepository;

	public Flux<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	public Mono<Member> getOneMemberById(String memberId) {
		return memberRepository.findById(memberId);
	}

	public Mono<Member> createMember(Member member) {
		return memberRepository.save(member);
	}

	public Mono<Member> findAndUpdateMember(Member member) {
		memberRepository.findByMemberId(member.getMemberId()).flatMap(m -> {
			m.setMemberName(member.getMemberName());
			m.setMemberAddress(member.getMemberAddress());
			m.setMembershipType(member.getMembershipType());
			m.setMemberExpiryDate(member.getMemberExpiryDate());
			return memberRepository.save(m);
		}).subscribe();

		return memberRepository.findById(member.getMemberId());
	}

	public Mono<Void> deleteMember(String memberId) {
		return memberRepository.deleteByMemberId(memberId);
	}

	public Mono<Void> deleteMembers() {
		return memberRepository.deleteAll();
	}
}
