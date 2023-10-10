package com.example.digitallibrary.controllers;

import com.example.digitallibrary.dtos.CreateStudentRequest;
import com.example.digitallibrary.dtos.SearchRequest;
import com.example.digitallibrary.models.SecuredUser;
import com.example.digitallibrary.models.Student;
import com.example.digitallibrary.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    // create student

    //User -> set id of this user in student object -> save the student object


    // SIGN UP API - OPEN FOR ALL
    @PostMapping("/create")
    public void createStudent(@RequestBody @Valid CreateStudentRequest createStudentRequest) {
        studentService.createStudent(createStudentRequest.toStudent());
    }



    //updating a student

    // findStudentById

    //findStudentByEmail

    //findStudentByRollNumber

    //findStudentByName

    @GetMapping("/profile")
    public Student findStudent() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser user = (SecuredUser) authentication.getPrincipal();
        Integer studentId = user.getStudent().getId();
        return studentService.find(studentId);
    }

    @GetMapping("/getInfo")
    public Student findStudent(@RequestBody @Valid SearchRequest searchRequest) throws Exception {
        List<Student> list = studentService.findStudent(searchRequest.getSearchKey(), searchRequest.getSearchValue());
        return list.get(0);
    }

}






//@PreAuthorize("hasAuthority(Constants.STUDENT_SELF_INFO_AUTHORITY)")
