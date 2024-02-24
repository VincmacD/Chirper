package com.cst8277.messagingservice.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table(name="producers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Producer {
    @Id
    private UUID id;
    private String comment;
}
