package com.reymer.mvc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.reymer.mvc.models.Book;
import com.reymer.mvc.services.BookService;

@RestController
@RequestMapping("/api")
public class BookApiController {
	@Autowired
    private final BookService bookService;
    public BookApiController(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/books")
    public List<Book> index() {
        return this.bookService.allBooks();
    }
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return this.bookService.createBook(book);
    }
    @RequestMapping("/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = this.bookService.findBook(id);
        return book;
    }
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = this.bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        this.bookService.deleteBook(id);
    }
}