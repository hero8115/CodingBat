package com.example.codingbat.repository;

import com.example.codingbat.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    boolean existsByEmail(String email);

    boolean existsById(Integer id);
}
