package com.example.pet_care_veterinaire.Services;

import com.example.pet_care_veterinaire.entities.Veterinaire;
import java.util.List;

public interface IVeterianire {
    List<Veterinaire> retrieveAllVeterinaires();
    Veterinaire addVeterinaire(Veterinaire v);
    void delete(Long id); // FIXED spelling
    Veterinaire updateVeterinaire(Veterinaire v);
    Veterinaire retrieveVeterinaire(Long id);
}
