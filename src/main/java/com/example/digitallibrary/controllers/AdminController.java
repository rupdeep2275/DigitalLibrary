package com.example.digitallibrary.controllers;

import com.example.digitallibrary.dtos.CreateAdminRequest;
import com.example.digitallibrary.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/admin")
    public void createAdmin(@RequestBody @Valid CreateAdminRequest createAdminRequest){
        adminService.createAdmin(createAdminRequest.toAdmin());
    }
}
