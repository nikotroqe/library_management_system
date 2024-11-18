package com.lms.service.impl;

import com.lms.model.Author;
import com.lms.repository.AuthorRepository;
import com.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(()-> new RuntimeException("Author is not exist with given id: " + authorId));
    }

    @Override
    public Author updatedAuthor(long authorId, Author author) {
        Author existingAuthor = authorRepository.findById(authorId).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setName(author.getName());
            existingAuthor.setSurname(author.getSurname());
            existingAuthor.setBirthdate(author.getBirthdate());
            existingAuthor.setBirthplace(author.getBirthplace());
            existingAuthor.setNationality(author.getNationality());
            existingAuthor.setCreatedDate(author.getCreatedDate());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }

    @Override
    public void deleteAuthorById(long authorId) {
        authorRepository.deleteById(authorId);
    }
}
