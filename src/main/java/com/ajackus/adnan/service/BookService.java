package com.ajackus.adnan.service;

import java.util.List;

import com.ajackus.adnan.entity.Book;

public interface BookService {

	// Add a Book
	Book saveBook(Book book);

	// View All Books
	List<Book> getAllBooks();

	// Search Book by ID
	Book getBookById(int id);

	// Search Book by Title
	List<Book> searchBookByTitle(String title);

	// Update Book Details
	Book updateBook(Book book);

	// Delete a Book
	void deleteBook(int id);

	// Find Books by Title
	List<Book> findByTitle(String title);

}
