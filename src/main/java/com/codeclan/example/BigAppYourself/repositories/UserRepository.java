package com.codeclan.example.BigAppYourself.repositories;

import com.codeclan.example.BigAppYourself.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
