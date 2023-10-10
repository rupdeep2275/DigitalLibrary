package com.example.digitallibrary.repositories;

import com.example.digitallibrary.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findStudentByAge(Integer age);

    List<Student> findStudentByRollNumber(String rollNumber);

    List<Student> findStudentByEmail(String email);

    List<Student> findStudentByName(String name);

}
