package com.example.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Book {

    public Long getBookId() {
        return bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return bookId.equals(book.bookId);
    }

    @Override
    public int hashCode() {
        return bookId != null ? bookId.hashCode() : 0;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    public Book(String title, Set<Author> authors) {
        this.title = title;
        this.authors = authors;
    }

    public Book(String title) {
        this.title = title;
    }

    private String title;

    public Book(){}

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @ManyToMany
    @JoinTable(name = "author_book",joinColumns =@JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
