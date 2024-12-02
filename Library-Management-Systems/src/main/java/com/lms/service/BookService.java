package com.lms.service;

import com.lms.model.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    List<Book> getAllBook();
    Book getBookById(long bookId);
    Book updatedBook(long bookId, Book book);
    void deleteBookById(Long bookId);


}
