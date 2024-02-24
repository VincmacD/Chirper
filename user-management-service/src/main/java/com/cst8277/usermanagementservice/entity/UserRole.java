package com.cst8277.usermanagementservice.entity;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "users_has_roles")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserRole implements Serializable {
    @EmbeddedId
   private UserRoleId userRoleId;

}
