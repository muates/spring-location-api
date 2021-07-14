package com.dev.springlocationapi.repository;

import com.dev.springlocationapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User getById(Long id);

    void deleteById(Long id);
}
