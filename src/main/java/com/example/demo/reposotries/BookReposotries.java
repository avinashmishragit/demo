package com.example.demo.reposotries;

import com.example.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookReposotries extends CrudRepository<Book,Long> {
}
