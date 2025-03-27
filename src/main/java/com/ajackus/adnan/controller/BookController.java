package com.ajackus.adnan.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajackus.adnan.entity.Book;
import com.ajackus.adnan.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	BookService bookService;

	// Constructor Injection
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// Home Page - View All Books
	@GetMapping("/list")
	public String viewHomePage(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "view-books";
	}

	// Show Add Book Form
	@GetMapping("/add")
	public String showAddBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "add-book";
	}

	// Save Book
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.saveBook(book);
		return "redirect:/books/list";
	}

	// Show Edit Form
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int id, Model theModel) {
		Book theBook = bookService.getBookById(id);
		theModel.addAttribute("book", theBook);
		return "edit-book";
	}

	// Update Book
	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute("book") Book book) {
		// Get the existing book using book.getId()
		Book existingBook = bookService.getBookById(book.getId());

		// Update the existing book with new values
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setGenre(book.getGenre());
		existingBook.setStatus(book.getStatus());

		// Save updated book
		bookService.updateBook(existingBook);

		return "redirect:/books/list";
	}

	// Delete Book
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
		return "redirect:/books/list";
	}
	
	// Search Book by ID or Title
	@GetMapping("/search")
	public String searchBooks(@RequestParam("searchType") String searchType,
	                           @RequestParam("keyword") String keyword, Model model) {
	    List<Book> books;
	    
	    if ("id".equals(searchType)) {
	        try {
	            int id = Integer.parseInt(keyword);
	            Book book = bookService.getBookById(id);
	            books = (book != null) ? List.of(book) : List.of();
	        } catch (NumberFormatException e) {
	            books = List.of(); // Handle invalid ID gracefully
	        }
	    } else {
	        books = bookService.findByTitle(keyword);
	    }

	    model.addAttribute("books", books);
	    return "view-books";
	}
	
	// Exit Library (Redirect to Welcome Page or Home)
	@GetMapping("/exit")
	public String exitLibrary() {
	    return "redirect:/";
	}



}
