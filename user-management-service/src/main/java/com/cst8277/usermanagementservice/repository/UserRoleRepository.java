package com.cst8277.usermanagementservice.repository;

import com.cst8277.usermanagementservice.entity.UserRole;
import com.cst8277.usermanagementservice.entity.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
    @Query("SELECT ur FROM UserRole ur WHERE ur.userRoleId.users_id = :user_id")
    List<UserRole> findByIdCustom(UUID user_id);
}


