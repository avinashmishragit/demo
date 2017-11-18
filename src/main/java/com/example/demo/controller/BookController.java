package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.reposotries.BookReposotries;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    private BookReposotries bookReposotries;

    public BookController(BookReposotries bookReposotries) {
        this.bookReposotries = bookReposotries;
    }

    @RequestMapping(value = "books",method= RequestMethod.GET)
    @ResponseBody()
    public Book getAllBooks(){
       // model.addAttribute("books",bookReposotries.findAll());
         Book book= bookReposotries.findById((long)5).get();
         return book;
    }
}
