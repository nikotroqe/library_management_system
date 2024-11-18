package com.lms.service.impl;

import com.lms.model.Author;
import com.lms.model.Book;
import com.lms.repository.BookRepository;
import com.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(()-> new RuntimeException("Book is not exist with given id: " + bookId));
    }

    @Override
    public Book updatedBook(long bookId, Book book) {
        Book existingBook = bookRepository.findById(bookId).orElse(null);
        if (existingBook != null) {
            existingBook.setName(book.getName());
            existingBook.setDescription(book.getDescription());
            existingBook.setCreatedDate(book.getCreatedDate());
            existingBook.setModifiedDate(book.getModifiedDate());
            existingBook.setLanguage(book.getLanguage());
            return bookRepository.save(existingBook);
        }
        return null;
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
