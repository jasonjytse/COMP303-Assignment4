package com.jt.models;
/**
*
* @author Jason Tse
*
* Publisher class
*
*/

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class Publisher {

	private static AtomicInteger publisherIds = new AtomicInteger(0);

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

 	public static AtomicInteger getPublisherIds() {
		return publisherIds;
	}

	public static void setPublisherIds(AtomicInteger publisherIds) {
		Publisher.publisherIds = publisherIds;
	}

	public static int getAndIncrementIds() {
		return publisherIds.getAndIncrement();
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
