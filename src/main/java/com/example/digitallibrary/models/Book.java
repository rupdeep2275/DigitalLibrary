package com.example.digitallibrary.models;

import com.example.digitallibrary.enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn
    private Author book_author;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @ManyToOne
    @JoinColumn
    private Student student;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;

//    trxn <-> Book
//        [n:1]


}
