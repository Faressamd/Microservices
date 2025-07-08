package com.example.usermicroservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data  // Lombok - provides getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
