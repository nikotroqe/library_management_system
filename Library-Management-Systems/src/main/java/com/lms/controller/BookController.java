package com.lms.controller;

import com.lms.model.Author;
import com.lms.model.Book;
import com.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/createBook")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable("bookId") long bookId){
        Book book = bookService.getBookById(bookId);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable long bookId, @RequestBody Book book) {
        Book updatedBook = bookService.updatedBook(bookId, book);
        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
        return ResponseEntity.noContent().build();
    }
}
