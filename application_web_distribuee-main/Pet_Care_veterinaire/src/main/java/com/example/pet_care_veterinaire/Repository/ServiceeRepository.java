package com.example.pet_care_veterinaire.Repository;

import com.example.pet_care_veterinaire.entities.Servicee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceeRepository  extends JpaRepository <Servicee, Long > {
}
