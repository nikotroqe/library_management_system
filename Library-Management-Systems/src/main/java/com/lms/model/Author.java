package com.lms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorId;
    @Column(name = "name")
	private String name;
    @Column(name = "surname")
	private String surname;
    @Column(name = "birthdate")
	private Date birthdate;
    @Column(name = "birthplace")
	private String birthplace;
    @Column(name = "nationality")
	private String nationality;
    @Column(name = "createdDate")
	private ZonedDateTime createdDate;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy="author")
    private Book book;

}
