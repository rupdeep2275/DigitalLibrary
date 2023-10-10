package com.example.digitallibrary.repositories;

import com.example.digitallibrary.models.SecuredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SecuredUser, Integer> {
    SecuredUser findByUsername(String username);
}
