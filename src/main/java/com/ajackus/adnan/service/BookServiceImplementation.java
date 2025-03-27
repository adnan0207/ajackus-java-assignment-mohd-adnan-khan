package com.ajackus.adnan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ajackus.adnan.dao.BookRepository;
import com.ajackus.adnan.entity.Book;

@Service
public class BookServiceImplementation implements BookService {

	BookRepository bookRepository;

	// Constructor Injection
	public BookServiceImplementation(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// Add a Book
	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	// View All Books
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// Search Book by ID
	@Override
	public Book getBookById(int id) {
		return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with ID - " + id));
	}

	// Search Book by Title
	@Override
	public List<Book> searchBookByTitle(String title) {
		return bookRepository.findByTitleContainingIgnoreCase(title);
	}

	// Update Book Details
	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	// Delete a Book
	@Override
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

	// Find Books by Title
	@Override
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitleContainingIgnoreCase(title);
	}

}
