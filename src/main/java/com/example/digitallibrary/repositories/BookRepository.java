package com.example.digitallibrary.repositories;

import com.example.digitallibrary.enums.Genre;
import com.example.digitallibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByName(String bookName);
    @Query(value = "SELECT b.* FROM Book b JOIN Author a ON b.book_author_id = a.id WHERE a.name = ?1", nativeQuery = true)
    List<Book> findByAuthorName(String authorName);
    List<Book> findByGenre(Genre genre);
}
