package com.lms.controller;

import com.lms.model.Author;
import com.lms.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/createAuthor")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author createdAuthor = authorService.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("authorId") long authorId){
        Author author = authorService.getAuthorById(authorId);
        return ResponseEntity.ok(author);
    }

    @PutMapping("/update/{authorId}")
    public ResponseEntity<Author> updateAuthor(@PathVariable long authorId, @RequestBody Author author) {
        Author updatedAuthor = authorService.updatedAuthor(authorId, author);
        return updatedAuthor != null ? ResponseEntity.ok(updatedAuthor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthorById(authorId);
        return ResponseEntity.noContent().build();
    }


}
