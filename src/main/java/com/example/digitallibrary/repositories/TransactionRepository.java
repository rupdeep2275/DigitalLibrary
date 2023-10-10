package com.example.digitallibrary.repositories;

import com.example.digitallibrary.enums.TransactionType;
import com.example.digitallibrary.models.Book;
import com.example.digitallibrary.models.Student;
import com.example.digitallibrary.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    // todo - verify with List<Transaction>
    Transaction findTransactionByStudentAndBookAndTransactionTypeOrderByIdDesc(Student student, Book book, TransactionType transactionType);
}
