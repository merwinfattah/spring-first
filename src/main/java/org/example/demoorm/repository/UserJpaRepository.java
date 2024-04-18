package org.example.demoorm.repository;

import org.example.demoorm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

        @Query(value = "SELECT * FROM users WHERE name = ?1", nativeQuery = true)
        User findUserByName(String userName);

        @Query(value = "SELECT * FROM users WHERE name = ?1 AND phone_number = ?2", nativeQuery = true)
        User findUserByUserNameAndPhoneNumber(String userName, String phoneNumber);

        Optional<User> findByUserName(String username);

        Boolean existsByUserName(String username);

        Boolean existByUserEmail(String email);
}