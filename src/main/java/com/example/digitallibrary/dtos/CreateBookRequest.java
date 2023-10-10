package com.example.digitallibrary.dtos;

import com.example.digitallibrary.enums.Genre;
import com.example.digitallibrary.models.Author;
import com.example.digitallibrary.models.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBookRequest {

    @NotBlank
    private String name;

    @NotNull
    private Genre genre;

    @NotBlank
    private String authorName;

    @NotBlank
    private String authorEmail;

    public Book toBook() {

        Author author = Author.builder()
                .name(authorName)
                .email(authorEmail)
                .build();

        return Book.builder()
                .name(this.name)
                .genre(this.genre)
                .book_author(author)
                .build();
    }


}
