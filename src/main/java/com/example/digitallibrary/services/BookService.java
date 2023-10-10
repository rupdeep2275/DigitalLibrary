package com.example.digitallibrary.services;

import com.example.digitallibrary.enums.Genre;
import com.example.digitallibrary.models.Author;
import com.example.digitallibrary.models.Book;
import com.example.digitallibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookRepository bookRepository;

    public void createOrUpdateBook(Book book) {

        Author bookAuthor = book.getBook_author();

        // Create an author if it doesn't exist (getOrCreate)
        Author existingAuthor = authorService.getOrCreate(bookAuthor);

        // Book.setAuthor() -> map this author to the book
        book.setBook_author(existingAuthor);

        //Save book
        bookRepository.save(book);
    }

    public List<Book> findBook(String searchKey, String searchValue) throws Exception {
        switch (searchKey) {
            case "name":
                return bookRepository.findByName(searchValue);
            case "author_name":
                return bookRepository.findByAuthorName(searchValue);
            case "genre":
                return bookRepository.findByGenre(Genre.valueOf(searchValue));
            case "id": {
                Optional<Book> book = bookRepository.findById(Integer.parseInt(searchValue));
                if(book.isPresent()) {
                    return List.of(book.get());
                } else {
                    return new ArrayList<>();
                }
            } default:
                throw new Exception("Search key is not valid " + searchKey);
        }
    }

}