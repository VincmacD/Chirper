package com.cst8277.usermanagementservice.repository;

import com.cst8277.usermanagementservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID>{

    @Query("SELECT r FROM Role r WHERE r.id = :id")
    Role findByIdCustom(@Param("id") UUID id);

}
