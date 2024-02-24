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
@Table(name="subscribers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subscriber {
    @Id
    private UUID id;
    private String comment;
}

