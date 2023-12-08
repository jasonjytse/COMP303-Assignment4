package com.jt.models;
/**
 * 
 * @author Jason Tse
 * Book Model
 */

import java.util.concurrent.atomic.AtomicInteger;

public class Book {

	private static AtomicInteger bookIds = new AtomicInteger(0);

	private String bookId;
	private String bookAuthor;
	private String bookTitle;
	private Double bookPrice;
	private Boolean bookInStock;

	// empty constructor for BookService getAllBooks() method
	public Book() {}

	// Constructor for update operation
	public Book(String bookId, String bookTitle, String bookAuthor, String bookPrice, boolean bookInStock) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = Double.parseDouble(bookPrice);
		this.bookInStock = bookInStock;
	}

	// Constructor for create operation
	public Book(String bookTitle, String bookAuthor, String bookPrice) {
		this.bookId = Integer.toString(bookIds.incrementAndGet());
		this.bookInStock = true;
		this.bookAuthor = bookAuthor;
		this.bookTitle = bookTitle;
		this.bookPrice = Double.parseDouble(bookPrice);
	}

	public static AtomicInteger getBookIds() {
		return bookIds;
	}

	public static void setBookIds(AtomicInteger bookIds) {
		Book.bookIds = bookIds;
	}

	public static int getAndIncrementIds() {
		return bookIds.getAndIncrement();
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Boolean getIsBookInStock() {
		return bookInStock;
	}

	public void setIsBookInStock(Boolean bookInStock) {
		this.bookInStock = bookInStock;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookAuthor=" + bookAuthor + ", bookTitle=" + bookTitle + ", bookPrice="
				+ bookPrice + ", bookInStock=" + bookInStock + "]";
	}


}
