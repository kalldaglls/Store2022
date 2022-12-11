package com.forgeeks.SpringDZ5.core.repositories;

import com.forgeeks.SpringDZ5.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
//    Optional<User> finfByUserId(Long id);
}
