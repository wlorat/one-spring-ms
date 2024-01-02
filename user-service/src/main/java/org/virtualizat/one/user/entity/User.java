package org.virtualizat.one.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.virtualizat.one.user.entity.enums.State;

import java.util.UUID;

@Entity
@Table(name="user", schema="app")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(length = 36)
    private UUID id;
    @Column(name="username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "hashtag")
    private String hashtag;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;
}