package com.example.digitallibrary.controllers;

import com.example.digitallibrary.dtos.CreateBookRequest;
import com.example.digitallibrary.dtos.SearchRequest;
import com.example.digitallibrary.models.Book;
import com.example.digitallibrary.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    // Adding a book

    /**
     * Book ---> Author -> map book to the author
     */

    @Autowired
    BookService bookService;

    //Creation of a book
    // Restricted to ADMIN
    @PostMapping("/create")
//    @PreAuthorize("hasAuthority('CREATE_BOOK')")
    public void createBook(@RequestBody @Valid CreateBookRequest createBookRequest) {
        bookService.createOrUpdateBook(createBookRequest.toBook());
    }

    //Getting a list of Books
    @GetMapping("/getBook")

    public List<Book> getBooks(@RequestBody @Valid SearchRequest searchRequest) throws Exception {
        return bookService.findBook(searchRequest.getSearchKey(), searchRequest.getSearchValue());
    }


// authorName = Robert, genre = NULL,
// genre = PROGRAMMING, authorName = NULL

//    key = authorName, value = Robert
//    key = genre, value = PROGRAMMING

}
