package com.lms.service;

import com.lms.model.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
    List<Author> getAllAuthor();
    Author getAuthorById(long authorId);
    Author updatedAuthor(long authorId, Author author);
    void deleteAuthorById(long authorId);


}
