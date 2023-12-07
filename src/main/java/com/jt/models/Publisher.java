package com.jt.models;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Jason Tse
 * 
 * Publisher class represents a book publisher. A publisher can publish many books, but a book can only have one publisher
 * 
 */

public class Publisher {
	
	private String publisherId;
	private String publisherAddress;
	private String publisherName;
	
	public Publisher() {
		
	}
	
	
	public Publisher(String publisherId, String publisherAddress, String publisherName) {
		super();
		this.publisherId = publisherId;
		this.publisherAddress = publisherAddress;
		this.publisherName = publisherName;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}	

}
