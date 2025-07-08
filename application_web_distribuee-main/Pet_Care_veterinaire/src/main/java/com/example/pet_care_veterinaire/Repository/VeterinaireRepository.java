package com.example.pet_care_veterinaire.Repository;


import com.example.pet_care_veterinaire.entities.Veterinaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaireRepository extends JpaRepository  <Veterinaire, Long > {
    
}
