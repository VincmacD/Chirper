package com.cst8277.usermanagementservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "last_visit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LastVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer in;
    private Integer out;
}
