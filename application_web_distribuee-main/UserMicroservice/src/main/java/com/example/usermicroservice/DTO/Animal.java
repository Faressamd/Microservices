package com.example.usermicroservice.DTO;

import lombok.Data;

@Data
public class Animal {
    private Long id;
    private String nom; // name of the animal

    // make sure it's named 'nom' if you're calling getNom()
}
