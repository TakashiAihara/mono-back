package com.handson.spring_boot_handson.domain.repositories;

import com.handson.spring_boot_handson.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRepository extends JpaRepository<User, Integer> {

    }
