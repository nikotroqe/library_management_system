package com.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
    @JsonIgnore
    private Author author;

    @Column(name = "createdDate")
    private ZonedDateTime createdDate;

    @Column(name = "modifiedDate")
    private ZonedDateTime modifiedDate;

    @Column(name = "language")
    private String language;

    public Book(long bookId, String name, String description, ZonedDateTime createdDate, ZonedDateTime modifiedDate, String language) {

    }
}