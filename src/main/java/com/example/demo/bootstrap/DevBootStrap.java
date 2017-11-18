package com.example.demo.bootstrap;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.reposotries.AuthorRepository;
import com.example.demo.reposotries.BookReposotries;
import com.example.demo.reposotries.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap  implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookReposotries bookReposotries,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookReposotries = bookReposotries;
        this.publisherRepository = publisherRepository;
    }

    private BookReposotries bookReposotries;
    private void initData(){

        Author author1 = new Author();
        author1.setfName("avinash");
        author1.setLname("mishra");

        Author author2 = new Author();
        author2.setfName("avinash2");
        author2.setLname("mishra2");

        Author author3 = new Author();
        author3.setfName("avinash3");
        author3.setLname("mishra3");

        Book book1 = new Book();
        book1.setTitle("book1");

        Book book2 = new Book();
        book2.setTitle("book2");

        Book book3 = new Book();
        book3.setTitle("book3");
        author1.getBooks().add(book1);
        author2.getBooks().add(book2);
        author3.getBooks().add(book3);
        book1.getAuthors().add(author1);
        book2.getAuthors().add(author2);
        book3.getAuthors().add(author3);

        Publisher publisher = new Publisher();
        publisher.setAddress("Delhi");
        publisher.setName("SieVectro");
        book1.setPublisher(publisher);
        book2.setPublisher(publisher);
        book3.setPublisher(publisher);

        publisherRepository.save(publisher);

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);

        bookReposotries.save(book1);
        bookReposotries.save(book2);
        bookReposotries.save(book3);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initData();
    }
}
