package com.codeclan.example.BigAppYourself.repositories;

import com.codeclan.example.BigAppYourself.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
}
