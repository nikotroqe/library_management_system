package com.lms.service;

import com.lms.model.Book;

public interface BookService {
    Book createBook(Book book);
    Book getBookById(long bookId);
    Book updatedBook(long bookId, Book book);
    void deleteBookById(Long bookId);
}
