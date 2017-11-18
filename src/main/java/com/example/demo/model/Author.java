package com.example.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Author(String fName, String lname, Set<Book> books) {
        this.fName = fName;
        this.lname = lname;
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return authorId != null ? authorId.equals(author.authorId) : author.authorId == null;
    }

    @Override
    public int hashCode() {
        return authorId != null ? authorId.hashCode() : 0;
    }

    private String fName;

    public Author(String fName, String lname) {
        this.fName = fName;
        this.lname = lname;
    }

    private String lname;

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author(){}

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
