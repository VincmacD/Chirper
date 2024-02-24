package com.cst8277.usermanagementservice.repository;

import com.cst8277.usermanagementservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
 User findByName(String name);

 @Query("SELECT u FROM User u WHERE u.id = :id")
 User findByIdCustom(@Param("id") UUID id);

 Optional<User> findByEmail(String email);
}

