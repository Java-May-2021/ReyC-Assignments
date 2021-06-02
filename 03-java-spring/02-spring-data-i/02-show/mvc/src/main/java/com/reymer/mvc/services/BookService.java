package com.reymer.mvc.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.reymer.mvc.models.Book;
import com.reymer.mvc.repositories.BookRepository;

@Service
public class BookService {
   private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> allBooks() {
        return this.bookRepository.findAll();
    }
    public Book createBook(Book b) {
        return this.bookRepository.save(b);
    }
    public Book findBook(Long id) {
        Optional<Book> optionalBook = this.bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    private List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "English", 309),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "English", 180),
            new Book("Moby Dick", "The saga of Captain Ahab", "English", 544),
            new Book("Don Quixote", "Life of a retired country gentleman", "English", 150),
            new Book("The Odyssey", "Ancient Greek epic poem", "English", 475)
            ));
    
    public List<Book> getAllBooks() {
        return books;
    }
    
    public Book findBookByIndex(int index) {
        if (index < books.size()){
            return books.get(index);
        }else{
            return null;
        }
    }
}
