package com.lms.service;

import com.lms.model.Author;

public interface AuthorService {
    Author createAuthor(Author author);
    Author getAuthorById(long authorId);
    Author updatedAuthor(long authorId, Author author);
    void deleteAuthorById(long authorId);
}
