package com.cst8277.messagingservice.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name= "subscriptions")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription implements Serializable {
    @EmbeddedId
    private SubscriptionId subscriptionId;
}
