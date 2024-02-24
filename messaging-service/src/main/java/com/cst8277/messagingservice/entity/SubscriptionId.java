package com.cst8277.messagingservice.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode
public class SubscriptionId implements Serializable {
    private UUID subscribers_id;
    private UUID producers_id;
}
