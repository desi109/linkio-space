package com.linkiospace.repositories;

import com.linkiospace.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    @Query("SELECT u FROM User u")
    Set<User> showAllUsers();

    @Query("SELECT u FROM User u WHERE u.id = :userId")
    User findUserByUserId(Long userId);

    @Query("SELECT u FROM User u WHERE lower(u.userCode) = :userCode")
    Optional<User> findUserByUserCode(String userCode);

    @Query("SELECT u.id FROM User u WHERE lower(u.userCode) = :userCode")
    Long findUserIdByUserCode(String userCode);

    @Query("SELECT u.id FROM User u WHERE lower(u.email) = :email")
    Long findUserIdByEmail(String email);

    @Query("SELECT u FROM User u WHERE lower(u.email) = :email")
    User findUserByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id = :userId")
    Optional<User> findUserById(Long userId);

    @Query("SELECT u.userCode FROM User u WHERE lower(u.email) = :email")
    String findUserCodeByEmail(String email);

}
