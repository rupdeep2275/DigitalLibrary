package com.example.digitallibrary.services;

import com.example.digitallibrary.models.Admin;
import com.example.digitallibrary.models.SecuredUser;
import com.example.digitallibrary.repositories.AdminRepository;
import com.example.digitallibrary.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserService userService;

    @Autowired
    AdminRepository adminRepository;

    public void createAdmin(Admin admin) {
        SecuredUser securedUser = admin.getSecuredUser();
        securedUser = userService.save(securedUser, Constants.ADMIN_USER);

        admin.setSecuredUser(securedUser);
        adminRepository.save(admin);
    }

    public Admin find(Integer adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }

}
