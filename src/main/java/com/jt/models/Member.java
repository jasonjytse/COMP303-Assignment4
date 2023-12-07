package com.jt.models;

import java.util.Date;

public class Member {

	private String memberId;
	private Date memberSignupDate;
	private String membershipType;
	private String memberAddress;
	private String memberName;
	private Date memberExpiryDate;
	
	public Member(String memberId, Date memberSignupDate, String membershipType, String memberAddress,
			String memberName, Date memberExpiryDate) {
		super();
		this.memberId = memberId;
		this.memberSignupDate = memberSignupDate;
		this.membershipType = membershipType;
		this.memberAddress = memberAddress;
		this.memberName = memberName;
		this.memberExpiryDate = memberExpiryDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getMemberSignupDate() {
		return memberSignupDate;
	}

	public void setMemberSignupDate(Date memberSignupDate) {
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

	public Date getMemberExpiryDate() {
		return memberExpiryDate;
	}

	public void setMemberExpiryDate(Date memberExpiryDate) {
		this.memberExpiryDate = memberExpiryDate;
	}
	
	
	

}
