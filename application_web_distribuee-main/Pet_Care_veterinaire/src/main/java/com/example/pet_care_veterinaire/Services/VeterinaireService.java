package com.example.pet_care_veterinaire.Services;

import com.example.pet_care_veterinaire.entities.Veterinaire;
import com.example.pet_care_veterinaire.Repository.VeterinaireRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinaireService implements IVeterianire {

    @Autowired
    VeterinaireRepository veterinaireRepository;

    @Override
    public List<Veterinaire> retrieveAllVeterinaires() {
        return veterinaireRepository.findAll();
    }

    @Override
    public Veterinaire addVeterinaire(Veterinaire v) {
        return veterinaireRepository.save(v);
    }

    @Override
    public void delete(Long id) {
        veterinaireRepository.deleteById(id);
    }

    @Override
    public Veterinaire updateVeterinaire(Veterinaire v) {
        return veterinaireRepository.save(v);
    }

    @Override
    public Veterinaire retrieveVeterinaire(Long id) {
        return veterinaireRepository.findById(id).orElse(null);
    }
}
