package com.jt.models;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Member {

	private static AtomicInteger memberIds = new AtomicInteger(0);

	private String memberId;
	private String memberSignupDate;
	private String membershipType;
	private String memberAddress;
	private String memberName;
	private String memberExpiryDate;

	public Member() {};

	public Member(String memberId, String memberSignupDate, String membershipType, String memberAddress,
			String memberName, String memberExpiryDate) {
		super();
		this.memberId = memberId;
		this.memberSignupDate = memberSignupDate;
		this.membershipType = membershipType;
		this.memberAddress = memberAddress;
		this.memberName = memberName;
		this.memberExpiryDate = memberExpiryDate;
	}

	public static AtomicInteger getMemberIds() {
		return memberIds;
	}

	public static void setMemberIds(AtomicInteger memberIds) {
		Member.memberIds = memberIds;
	}

	public static int getAndIncrementIds() {
		return memberIds.getAndIncrement();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberSignupDate() {
		return memberSignupDate;
	}

	public void setMemberSignupDate(String memberSignupDate) {
		this.memberSignupDate = memberSignupDate;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberExpiryDate() {
		return memberExpiryDate;
	}

	public void setMemberExpiryDate(String memberExpiryDate) {
		this.memberExpiryDate = memberExpiryDate;
	}






}
