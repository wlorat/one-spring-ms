package org.virtualizat.one.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.virtualizat.one.auth.entity.enums.State;

import java.util.UUID;

@Entity
@Table(name="session", schema="app")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(length = 36)
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;
}